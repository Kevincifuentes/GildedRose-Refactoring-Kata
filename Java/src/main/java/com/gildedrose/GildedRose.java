package com.gildedrose;

import java.util.Arrays;

class GildedRose {

    public static final int EMPTY_QUALITY = 0;
    public static final int MAX_QUALITY = 50;
    public static final int TWO = 2;
    public static final int THREE = 3;
    public static final int BACKSTAGE_PASSES_FIRST_DAY_SELLIN = 11;
    public static final int BACKSTAGE_PASSES_CLOSEST_DAY_SELLIN = 6;
    public static final int ONE = 1;
    public static final int ZERO_DAYS = 0;
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        Arrays.asList(items).forEach(GildedRose::updateItemQuality);
    }

    private static void updateItemQuality(final Item item) {
        if (!item.name.equals("Aged Brie")
                && !item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            if (item.quality > EMPTY_QUALITY) {
                if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                    item.quality = item.quality - ONE;
                }
            }
        } else {
            if (item.quality < MAX_QUALITY) {
                item.quality = item.quality + 1;

                if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                    if (item.sellIn < BACKSTAGE_PASSES_FIRST_DAY_SELLIN) {
                        if (item.quality < MAX_QUALITY) {
                            item.quality = item.quality + TWO;
                        }
                    }

                    if (item.sellIn < BACKSTAGE_PASSES_CLOSEST_DAY_SELLIN) {
                        if (item.quality < MAX_QUALITY) {
                            item.quality = item.quality + THREE;
                        }
                    }
                }
            }
        }

        if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
            item.sellIn = item.sellIn - ONE;
        }

        if (item.sellIn < ZERO_DAYS) {
            if (!item.name.equals("Aged Brie")) {
                if (!item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                    if (item.quality > EMPTY_QUALITY) {
                        if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                            item.quality = item.quality - ONE;
                        }
                    }
                } else {
                    item.quality = EMPTY_QUALITY;
                }
            } else {
                if (item.quality < MAX_QUALITY) {
                    item.quality = item.quality + ONE;
                }
            }
        }
    }
}
