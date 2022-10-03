package org.hogly.boundedcontext.domain.client.repositories;

import org.hogly.boundedcontext.domain.client.entities.ClientEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends ReactiveCrudRepository<ClientEntity, String> {

}
