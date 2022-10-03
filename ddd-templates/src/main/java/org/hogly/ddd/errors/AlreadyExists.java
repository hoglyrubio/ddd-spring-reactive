package org.hogly.ddd.errors;

public class AlreadyExists extends DomainError {

    public AlreadyExists(String message, Object... values) {
        super(message, values);
    }

    public AlreadyExists(Throwable cause, String message, Object... values) {
        super(cause, message, values);
    }
}
