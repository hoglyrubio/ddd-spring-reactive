package org.hogly.boundedcontext.domain.client;

import lombok.Builder;
import lombok.Getter;
import org.hogly.boundedcontext.domain.client.entities.ClientEntity;
import org.hogly.boundedcontext.domain.client.valueobjects.ClientId;
import org.hogly.ddd.Aggregate;
import org.hogly.ddd.errors.ValidationError;
import org.springframework.util.Assert;
import reactor.core.publisher.Mono;

@Builder(toBuilder = true)
@Getter
public class ClientAggregate implements Aggregate {

    private ClientEntity entity;

    public ClientAggregate(ClientEntity entity) {
        this.entity = entity;
    }

    public ClientId aggregateId() {
        return new ClientId(entity.getId());
    }

    public Mono<ClientAggregate> validate() {
        return Mono.fromSupplier(() -> {
            Assert.hasText(entity.getId(), "Id is required");
            Assert.hasText(entity.getName(), "Name is required");
            Assert.hasText(entity.getAddress(), "Address is required");
            Assert.notNull(entity.getBirthDay(), "Birthday is required");
            return this;
        }).onErrorMap(throwable -> new ValidationError(throwable, throwable.getMessage()));
    }

}
