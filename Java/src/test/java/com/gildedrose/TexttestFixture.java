package com.gildedrose;

public class TexttestFixture {
    public static void main(String[] args) {
        System.out.println("OMGHAI!");

        Item[] items = new Item[] {
                new Item(Name.of("+5 Dexterity Vest"), SellIn.of(10), Quality.of(20)), //
                new AgedBrie(SellIn.of(2), Quality.of(0)), //
                new Item(Name.of("Elixir of the Mongoose"), SellIn.of(5), Quality.of(7)), //
                new Sulfuras(), //
                new Sulfuras(),
                new BackstagePasses(Name.of("Backstage passes to a TAFKAL80ETC concert"), SellIn.of(15), Quality.of(20)),
                new BackstagePasses(Name.of("Backstage passes to a TAFKAL80ETC concert"), SellIn.of(10), Quality.of(49)),
                new BackstagePasses(Name.of("Backstage passes to a TAFKAL80ETC concert"), SellIn.of(10), Quality.of(40)),
                new BackstagePasses(Name.of("Backstage passes to a TAFKAL80ETC concert"), SellIn.of(5), Quality.of(40)),
                new BackstagePasses(Name.of("Backstage passes to a TAFKAL80ETC concert"), SellIn.of(5), Quality.of(49)),
                new BackstagePasses(Name.of("Backstage passes to a TAFKAL80ETC concert"), SellIn.of(0), Quality.of(49)),
                // this conjured item does not work properly yet
                new Conjured(Name.of("Conjured Mana Cake"), SellIn.of(3), Quality.of(6)) };

        GildedRose app = new GildedRose(items);

        int days = 2;
        if (args.length > 0) {
            days = Integer.parseInt(args[0]) + 1;
        }

        for (int i = 0; i < days; i++) {
            System.out.println("-------- day " + i + " --------");
            System.out.println("name, sellIn, quality");
            for (Item item : items) {
                System.out.println(item);
            }
            System.out.println();
            app.updateQuality();
        }
    }

}
