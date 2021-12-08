package com.gildedrose;

import java.util.Objects;

public class SellIn {
    private static final int SELLIN_OVER = 0;
    private static final int ONE = 1;

    private final int value;

    private SellIn(final int value) {
        this.value = value;
    }

    public static SellIn of(final int sellIn) {
        return new SellIn(sellIn);
    }

    public boolean isOver() {
        return isOverFor(SELLIN_OVER);
    }

    public SellIn decrease() {
        return new SellIn(value - ONE);
    }

    public boolean isOverFor(final int expectedSellIn) {
        return value < expectedSellIn;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final SellIn sellIn = (SellIn) o;
        return value == sellIn.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
