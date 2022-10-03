package org.hogly.boundedcontext.domain.client.services;

import org.hogly.boundedcontext.domain.client.entities.ClientEntity;
import org.hogly.boundedcontext.domain.client.valueobjects.Client;

public class ClientMapper {

    public static ClientEntity toEntity(Client client) {
        return ClientEntity.builder()
                .id(client.getId())
                .name(client.getName())
                .address(client.getAddress())
                .birthDay(client.getBirthDay())
                .build();
    }

    public static Client fromEntity(ClientEntity entity) {
        return Client.builder()
                .id(entity.getId())
                .name(entity.getName())
                .address(entity.getAddress())
                .birthDay(entity.getBirthDay())
                .build();
    }
}
