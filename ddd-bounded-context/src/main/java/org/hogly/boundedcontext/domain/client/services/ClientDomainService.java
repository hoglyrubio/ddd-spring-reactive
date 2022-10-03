package org.hogly.boundedcontext.domain.client.services;

import org.hogly.boundedcontext.domain.client.ClientAggregate;
import org.hogly.boundedcontext.domain.client.repositories.ClientRepository;
import org.hogly.boundedcontext.domain.client.valueobjects.ClientId;
import org.hogly.ddd.errors.AlreadyExists;
import org.hogly.ddd.errors.NotFoundError;
import org.hogly.ddd.DomainService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ClientDomainService implements DomainService {

    private final ClientRepository clientRepository;

    public ClientDomainService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Mono<ClientAggregate> save(ClientAggregate clientAggregate) {
        return clientRepository.save(clientAggregate.getEntity())
                .map(entity -> clientAggregate.toBuilder()
                        .entity(entity)
                        .build());
    }

    public Mono<ClientAggregate> find(ClientId clientId) {
        return clientRepository.findById(clientId.getValue())
                .map(ClientAggregate::new);
    }

    public Flux<ClientAggregate> findAll() {
        return clientRepository.findAll()
                .map(ClientAggregate::new);
    }

    public Mono<ClientId> validateNotExists(ClientId clientId) {
        return find(clientId)
                .flatMap(clientAggregate -> Mono.<ClientId>error(new AlreadyExists("Client %s already exist", clientId)))
                .switchIfEmpty(Mono.just(clientId));

    }

    public Mono<ClientAggregate> validateExists(ClientId clientId) {
        return find(clientId)
                .switchIfEmpty(Mono.error(new NotFoundError("Client %s not found", clientId)));
    }


}
