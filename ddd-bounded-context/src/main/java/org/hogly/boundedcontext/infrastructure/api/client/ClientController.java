package org.hogly.boundedcontext.infrastructure.api.client;

import lombok.AllArgsConstructor;
import org.hogly.boundedcontext.application.ClientApplicationService;
import org.hogly.boundedcontext.domain.client.valueobjects.ClientId;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@AllArgsConstructor
public class ClientController {

    private final ClientApplicationService clientApplicationService;

    @PostMapping("/api/clients")
    public Mono<ClientDto> create(@RequestBody ClientDto dto) {
        return clientApplicationService.create(ClientDtoMapper.toClient(dto))
                .map(ClientDtoMapper::toDto);
    }

    @GetMapping("/api/clients/{clientId}")
    public Mono<ClientDto> read(@PathVariable("clientId") String clientId) {
        return clientApplicationService.read(new ClientId(clientId))
                .map(ClientDtoMapper::toDto);
    }

    @GetMapping("/api/clients")
    public Flux<ClientDto> readAll() {
        return clientApplicationService.readAll()
                .map(ClientDtoMapper::toDto);
    }

}
