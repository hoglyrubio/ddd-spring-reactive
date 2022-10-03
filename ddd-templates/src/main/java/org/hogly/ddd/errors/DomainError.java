package org.hogly.ddd.errors;

public class DomainError extends RuntimeException {

    public DomainError(String message, Object ... values) {
        super(String.format(message, values));
    }

    public DomainError(Throwable cause, String message, Object ... values) {
        super(String.format(message, values), cause);
    }
}
