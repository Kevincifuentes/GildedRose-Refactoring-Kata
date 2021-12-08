package com.gildedrose;

public class Conjured extends Item {

    public Conjured(final Name name, final SellIn sellIn, final Quality quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void update() {
        if(isBetweenQualityRange()) {
            decreaseQuality();
        }

        super.update();
    }
}
