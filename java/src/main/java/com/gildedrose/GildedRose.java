package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }


    /*
     /!\ Do not change code above this line /!\
     */

    public void updateQuality() {
        for (Item item : items) {
            if (!item.name.contains("Aged Brie")
                && !item.name.contains("Backstage passes")
                && !item.name.contains("Sulfuras")
                && item.quality > 0) {
                item.quality = item.name.contains("Conjured") ? item.quality - 2 : item.quality - 1;
            } else {
                if (item.quality < 50) {
                    item.quality = item.quality + 1;

                    if (item.name.contains("Aged Brie")) {
                        item.quality = item.quality + 1;
                    }

                    if (item.name.contains("Backstage passes")) {
                        if (item.quality < 50) {
                            item.quality = item.sellIn < 6 ? item.quality + 2 : item.quality + 1;
                        }

                        if (item.sellIn < 0) {
                            item.quality = 0;
                        }
                    }
                }
            }

            if (!item.name.contains("Sulfuras")) {
                item.sellIn = item.sellIn - 1;
            }

            if (item.sellIn < 0
                && !item.name.contains("Aged Brie")
                && !item.name.contains("Backstage passes")
                && !item.name.contains("Sulfuras")
                && item.quality > 0) {
                item.quality = item.quality - 1;
            }
        }
    }
}
