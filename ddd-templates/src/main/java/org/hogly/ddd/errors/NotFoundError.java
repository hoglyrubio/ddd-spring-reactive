package org.hogly.ddd.errors;

public class NotFoundError extends DomainError {

    public NotFoundError(String message, Object... values) {
        super(message, values);
    }

    public NotFoundError(Throwable cause, String message, Object... values) {
        super(cause, message, values);
    }
}
