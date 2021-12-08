package com.gildedrose;

public class Sulfuras extends Item {

    private static final Quality SULFURAS_QUALITY = Quality.of(80);
    private static final SellIn NONE_SELLIN = SellIn.of(0);

    public Sulfuras() {
        super(Name.of("Sulfuras, Hand of Ragnaros"), NONE_SELLIN, SULFURAS_QUALITY);
    }

    @Override
    public void update() {
        //implementation not needed, doesn't change
    }
}
