package org.hogly.boundedcontext.domain.client.entities;

import lombok.Builder;
import lombok.Getter;
import org.hogly.ddd.Entity;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;

@Builder(toBuilder = true)
@Getter
@Table("CLIENT")
public class ClientEntity implements Entity {

    @Id
    @Column("ID")
    private final String id;
    @Column("NAME")
    private final String name;
    @Column("ADDRESS")
    private final String address;
    @Column("BIRTH_DAY")
    private final LocalDate birthDay;


}
