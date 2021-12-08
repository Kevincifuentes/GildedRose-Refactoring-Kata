package com.gildedrose;

import java.util.Objects;

public class Quality {

    public static final Quality ZERO = Quality.of(0);

    private static final int ONE = 1;

    private static final int MIN_QUALITY = 0;
    private static final int MAX_QUALITY = 50;

    private final int value;

    private Quality(final int value) {
        this.value = value;
    }

    public static Quality of(final int quality) {
        return new Quality(quality);
    }

    public boolean isInRange() {
        return value > MIN_QUALITY && value < MAX_QUALITY;
    }

    public Quality increase() {
        return new Quality(value + ONE);
    }

    public Quality decrease() {
        return new Quality(value - ONE);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final Quality quality = (Quality) o;
        return value == quality.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
