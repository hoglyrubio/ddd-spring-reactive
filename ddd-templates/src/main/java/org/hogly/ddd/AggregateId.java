package org.hogly.ddd;

public abstract class AggregateId {

    protected final String value;

    protected AggregateId(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }
}
