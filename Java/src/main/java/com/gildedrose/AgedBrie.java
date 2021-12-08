package com.gildedrose;

public class AgedBrie extends Item {

    public AgedBrie(final SellIn sellIn, final Quality quality) {
        super(Name.of("Aged Brie"), sellIn, quality);
    }

    @Override
    public void update() {
        decreaseSellIn();

        if (isBetweenQualityRange()) {
            increaseQuality();

            if (isSellInOver()) {
                increaseQuality();
            }
        }
    }
}
