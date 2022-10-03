package org.hogly.boundedcontext.infrastructure.api.client;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Builder
@Data
public class ClientDto {

    private final String id;
    private final String name;
    private final String address;
    private final LocalDate birthDay;

}
