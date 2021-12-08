package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void should_decrease_any_item_quality_and_sell_in() {
        //given
        final Name name = Name.of("foo");
        Item[] items = new Item[] { new Item(name, SellIn.of(10), Quality.of(5)) };
        GildedRose app = new GildedRose(items);

        //when
        app.updateQuality();

        //then
        final Item expectedItem = new Item(
            name,
            SellIn.of(9),
            Quality.of(4)
        );
        assertEquals(items[0], expectedItem);
    }

    @Test
    void should_not_increase_item_quality_when_maximum() {
        //given
        final Name name = Name.of("foo");
        Item[] items = new Item[] { new Item(name, SellIn.of(10), Quality.of(50)) };
        GildedRose app = new GildedRose(items);

        //when
        app.updateQuality();

        //then
        final Item expectedItem = new Item(
            name,
            SellIn.of(9),
            Quality.of(50)
        );
        assertEquals(items[0], expectedItem);
    }

    @Test
    void should_not_decrease_quality_when_negative() {
        //given
        final Name name = Name.of("foo");
        Item[] items = new Item[] { new Item(name, SellIn.of(0), Quality.of(0)) };
        GildedRose app = new GildedRose(items);

        //when
        app.updateQuality();

        //then
        final Item expectedItem = new Item(
            name,
            SellIn.of(-1),
            Quality.of(0)
        );
        assertEquals(items[0], expectedItem);
    }

    @Test
    void should_aged_brie_increase_quality_when_older() {
        //given
        Item[] items = new Item[] { new AgedBrie(SellIn.of(2), Quality.of(4)) };
        GildedRose app = new GildedRose(items);

        //when
        app.updateQuality();

        //then
        final Item expectedItem = new AgedBrie(
            SellIn.of(1),
            Quality.of(5)
        );
        assertEquals(items[0], expectedItem);
    }

    @Test
    void should_aged_brie_not_increase_quality_when_maximum() {
        //given
        Item[] items = new Item[] { new AgedBrie(SellIn.of(2), Quality.of(50)) };
        GildedRose app = new GildedRose(items);

        //when
        app.updateQuality();

        //then
        final Item expectedItem = new AgedBrie(
            SellIn.of(1),
            Quality.of(50)
        );
        assertEquals(items[0], expectedItem);
    }

    @Test
    void should_aged_brie_increase_twice_quality_when_sell_in_over() {
        //given
        Item[] items = new Item[] { new AgedBrie(SellIn.of(0), Quality.of(12)) };
        GildedRose app = new GildedRose(items);

        //when
        app.updateQuality();

        //then
        final Item expectedItem = new AgedBrie(
            SellIn.of(-1),
            Quality.of(14)
        );
        assertEquals(items[0], expectedItem);
    }

    @Test
    void should_sulfuras_not_increase_quality_nor_sell_in() {
        //given
        Item[] items = new Item[] { new Sulfuras() };
        GildedRose app = new GildedRose(items);

        //when
        app.updateQuality();

        //then
        final Item expectedItem = new Sulfuras();
        assertEquals(items[0], expectedItem);
    }

    @Test
    void should_backstage_passes_increase_when_time_passes() {
        //given
        final Name name = Name.of("Iron maiden");
        Item[] items = new Item[] { new BackstagePasses(Name.of("Iron maiden"), SellIn.of(15), Quality.of(12)) };
        GildedRose app = new GildedRose(items);

        //when
        app.updateQuality();

        //then
        final Item expectedItem = new BackstagePasses(
            name,
            SellIn.of(14),
            Quality.of(13)
        );
        assertEquals(items[0], expectedItem);
    }

    @Test
    void should_backstage_passes_increase_twice_when_sell_in_less_than_11_days() {
        //given
        final Name name = Name.of("Iron maiden");
        Item[] items = new Item[] { new BackstagePasses(Name.of("Iron maiden"), SellIn.of(10), Quality.of(12)) };
        GildedRose app = new GildedRose(items);

        //when
        app.updateQuality();

        //then
        final Item expectedItem = new BackstagePasses(
            name,
            SellIn.of(9),
            Quality.of(14)
        );
        assertEquals(items[0], expectedItem);
    }

    @Test
    void should_backstage_passes_quality_reset_to_zero_when_sell_in_over() {
        //given
        final Name name = Name.of("Iron maiden");
        Item[] items = new Item[] { new BackstagePasses(Name.of("Iron maiden"), SellIn.of(0), Quality.of(12)) };
        GildedRose app = new GildedRose(items);

        //when
        app.updateQuality();

        //then
        final Item expectedItem = new BackstagePasses(
            name,
            SellIn.of(-1),
            Quality.of(0)
        );
        assertEquals(items[0], expectedItem);
    }

    @Test
    void should_backstage_passes_increase_twice_when_sell_in_less_than_6_days() {
        //given
        final Name name = Name.of("Iron maiden");
        Item[] items = new Item[] { new BackstagePasses(Name.of("Iron maiden"), SellIn.of(5), Quality.of(12)) };
        GildedRose app = new GildedRose(items);

        //when
        app.updateQuality();

        //then
        final Item expectedItem = new BackstagePasses(
            name,
            SellIn.of(4),
            Quality.of(15)
        );
        assertEquals(items[0], expectedItem);
    }

    @Test
    void should_conjured_decrease_twice() {
        //given
        final Name name = Name.of("Iron maiden");
        Item[] items = new Item[] { new Conjured(Name.of("Iron maiden"), SellIn.of(5), Quality.of(12)) };
        GildedRose app = new GildedRose(items);

        //when
        app.updateQuality();

        //then
        final Item expectedItem = new Conjured(
            name,
            SellIn.of(4),
            Quality.of(10)
        );
        assertEquals(items[0], expectedItem);
    }
}
