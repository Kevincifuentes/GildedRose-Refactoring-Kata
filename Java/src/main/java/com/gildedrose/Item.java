package com.gildedrose;

import java.util.Objects;

public class Item {
    private final Name name;

    private SellIn sellIn;

    private Quality quality;

    public Item(Name name, SellIn sellIn, Quality quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

   @Override
   public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final Item item = (Item) o;
        return Objects.equals(name, item.name) &&
            Objects.equals(sellIn, item.sellIn) &&
            Objects.equals(quality, item.quality);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, sellIn, quality);
    }

    public void update() {
        decreaseSellIn();

        if (isBetweenQualityRange()) {
            decreaseQuality();

            if (isSellInOver()) {
                decreaseQuality();
            }
        }
    }

    public boolean isSellInOver() {
        return sellIn.isOver();
    }

    public boolean isBetweenQualityRange() {
        return quality.isInRange();
    }

    public void increaseQuality() {
        quality = quality.increase();
    }

    public void decreaseQuality() {
        quality = quality.decrease();
    }

    public void resetQuality() {
        quality = Quality.ZERO;
    }

    public void decreaseSellIn() {
        sellIn = sellIn.decrease();
    }

    public boolean isSellInOverFor(final int expectedSellIn) {
        return sellIn.isOverFor(expectedSellIn);
    }
}
