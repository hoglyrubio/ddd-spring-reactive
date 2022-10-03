package org.hogly.boundedcontext.domain.common.valueobjects;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.hogly.ddd.ValueObject;

import java.math.BigDecimal;
import java.util.Currency;

@Builder(toBuilder = true)
@AllArgsConstructor
@Getter
public class Money implements ValueObject {

    private final BigDecimal value;
    private final Currency currency;

}
