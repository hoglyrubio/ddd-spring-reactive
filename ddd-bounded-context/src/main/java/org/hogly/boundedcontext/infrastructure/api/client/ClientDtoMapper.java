package org.hogly.boundedcontext.infrastructure.api.client;

import org.hogly.boundedcontext.domain.client.valueobjects.Client;

public class ClientDtoMapper {

    public static Client toClient(ClientDto dto) {
        return Client.builder()
                .id(dto.getId())
                .name(dto.getName())
                .address(dto.getAddress())
                .birthDay(dto.getBirthDay())
                .build();
    }

    public static ClientDto toDto(Client client) {
        return ClientDto.builder()
                .id(client.getId())
                .name(client.getName())
                .address(client.getAddress())
                .birthDay(client.getBirthDay())
                .build();

    }
}
