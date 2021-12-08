package com.gildedrose;

import java.util.Objects;

public class Name {

    private String value;

    private Name(final String value) {
        this.value = value;
    }

    public static Name of(final String name) {
        return new Name(name);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final Name name1 = (Name) o;
        return Objects.equals(value, name1.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
