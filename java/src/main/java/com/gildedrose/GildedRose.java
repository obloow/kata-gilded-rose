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
                item.quality = item.quality - 1;
            } else {
                if (item.quality < 50) {
                    item.quality = item.quality + 1;

                    if (item.name.contains("Backstage passes")) {
                        if (item.sellIn < 11) {
                            if (item.quality < 50) {
                                item.quality = item.quality + 1;
                            }
                        }

                        if (item.sellIn < 6) {
                            if (item.quality < 50) {
                                item.quality = item.quality + 1;
                            }
                        }
                    }
                }
            }

            if (!item.name.contains("Sulfuras")) {
                item.sellIn = item.sellIn - 1;
            }

            if (item.sellIn < 0) {
                if (!item.name.contains("Aged Brie")) {
                    if (!item.name.contains("Backstage passes")) {
                        if (item.quality > 0) {
                            if (!item.name.contains("Sulfuras")) {
                                item.quality = item.quality - 1;
                            }
                        }
                    } else {
                        item.quality = 0;
                    }
                } else {
                    if (item.quality < 50) {
                        item.quality = item.quality + 1;
                    }
                }
            }
        }
    }
}
