package org.hogly.boundedcontext.application;

import org.hogly.boundedcontext.domain.client.ClientAggregate;
import org.hogly.boundedcontext.domain.client.services.ClientDomainService;
import org.hogly.boundedcontext.domain.client.services.ClientMapper;
import org.hogly.boundedcontext.domain.client.valueobjects.Client;
import org.hogly.boundedcontext.domain.client.valueobjects.ClientId;
import org.hogly.ddd.ApplicationService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ClientApplicationService implements ApplicationService {

    private final ClientDomainService clientDomainService;

    public ClientApplicationService(ClientDomainService clientDomainService) {
        this.clientDomainService = clientDomainService;
    }

    public Mono<Client> create(Client client) {
        return clientDomainService.validateNotExists(client.getClientId())
                .map(clientId -> new ClientAggregate(ClientMapper.toEntity(client)))
                .flatMap(clientDomainService::save)
                .map(clientAggregate -> ClientMapper.fromEntity(clientAggregate.getEntity()));
    }

    public Mono<Client> read(ClientId clientId) {
        return clientDomainService.validateExists(clientId)
                .map(clientAggregate -> ClientMapper.fromEntity(clientAggregate.getEntity()));
    }

    public Flux<Client> readAll() {
        return clientDomainService.findAll()
                .map(clientAggregate -> ClientMapper.fromEntity(clientAggregate.getEntity()));
    }

}
