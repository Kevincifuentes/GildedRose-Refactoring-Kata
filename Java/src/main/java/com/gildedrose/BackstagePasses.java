package com.gildedrose;

public class BackstagePasses extends Item {

    private static final int BACKSTAGE_PASSES_FIRST_DAY_SELL_IN = 11;
    private static final int BACKSTAGE_PASSES_CLOSEST_DAY_SELL_IN = 6;

    public BackstagePasses(final Name name, final SellIn sellIn, final Quality quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void update() {

        if (isBetweenQualityRange()) {
            increaseQuality();
        }

        decreaseQualityWhenDueDate(BACKSTAGE_PASSES_FIRST_DAY_SELL_IN);
        decreaseQualityWhenDueDate(BACKSTAGE_PASSES_CLOSEST_DAY_SELL_IN);

        decreaseSellIn();

        if(isSellInOver()) {
            resetQuality();
        }
    }

    private void decreaseQualityWhenDueDate(final int backstagePassesFirstDaySellIn) {
        if (isSellInOverFor(backstagePassesFirstDaySellIn) && isBetweenQualityRange()) {
            increaseQuality();
        }
    }
}
