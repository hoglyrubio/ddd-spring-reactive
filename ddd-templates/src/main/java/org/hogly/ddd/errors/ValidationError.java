package org.hogly.ddd.errors;

public class ValidationError extends DomainError {

    public ValidationError(String message, Object... values) {
        super(message, values);
    }

    public ValidationError(Throwable cause, String message, Object... values) {
        super(cause, message, values);
    }
}
