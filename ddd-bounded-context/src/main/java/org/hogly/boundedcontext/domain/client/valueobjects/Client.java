package org.hogly.boundedcontext.domain.client.valueobjects;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.hogly.ddd.ValueObject;

import java.time.LocalDate;

@Builder(toBuilder = true)
@Getter
@EqualsAndHashCode
@ToString
public class Client implements ValueObject {

    private final String id;
    private final String name;
    private final String address;
    private final LocalDate birthDay;

    public ClientId getClientId() {
        return new ClientId(id);
    }

}
