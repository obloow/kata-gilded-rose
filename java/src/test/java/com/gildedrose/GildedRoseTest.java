package com.gildedrose;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class GildedRoseTest {

    @Test
    public void simpleItem() {
        Item foo = new Item("foo", 20, 10);
        Item[] items = new Item[]{foo};
        GildedRose gildedRose = new GildedRose(items);

        gildedRose.updateQuality();

        assertEquals(19, foo.sellIn);
        assertEquals(9, foo.quality);
    }

    @Test
    public void actualOutputIsSameThatGoldenMaster() throws FileNotFoundException {
        Application.main(null);

        StringBuilder sbExpected = new StringBuilder();
        StringBuilder sbActual = new StringBuilder();

        File myObjExpected = new File("../golden-master/expected-output.txt");
        Scanner myReaderExpected = new Scanner(myObjExpected);
        while (myReaderExpected.hasNextLine()) {
            String data = myReaderExpected.nextLine();
            sbExpected.append(data).append("\n");
        }
        myReaderExpected.close();

        File myObjActual = new File("./actual_output.txt");
        Scanner myReaderActual = new Scanner(myObjActual);
        while (myReaderActual.hasNextLine()) {
            String data = myReaderActual.nextLine();
            sbActual.append(data).append("\n");
        }
        myReaderActual.close();

        assertEquals(sbActual.toString(), sbExpected.toString());
    }

    @Test
    public void onceTheSellByDateHasPassedTheQualityDegradesTwiceAsFast() {
        Item foo = new Item("foo", 0, 10);
        Item[] items = new Item[]{foo};
        GildedRose gildedRose = new GildedRose(items);

        gildedRose.updateQuality();

        assertEquals(8, foo.quality);
    }

    @Test
    public void theQualityOfAnItemIsNeverNegative() {
        Item foo = new Item("foo", 0, 0);
        Item[] items = new Item[]{foo};
        GildedRose gildedRose = new GildedRose(items);

        gildedRose.updateQuality();

        assertEquals(0, foo.quality);
    }

    @Test
    public void agedBrieActuallyIncreasesInQualityTheOlderItGets() {
        Item foo = new Item("Aged Brie", 0, 0);
        Item[] items = new Item[]{foo};
        GildedRose gildedRose = new GildedRose(items);

        gildedRose.updateQuality();

        assertEquals(2, foo.quality);
    }

    @Test
    public void backstagePassesQualityIncreasesBy2WhenThereAre10DaysOrLess() {
        Item foo = new Item("Backstage passes to a TAFKAL80ETC concert", 10, 5);
        Item[] items = new Item[]{foo};
        GildedRose gildedRose = new GildedRose(items);

        gildedRose.updateQuality();

        assertEquals(7, foo.quality);
    }

    @Test
    public void backstagePassesQualityIncreasesBy3WhenThereAre5DaysOrLess() {
        Item foo = new Item("Backstage passes to a TAFKAL80ETC concert", 5, 5);
        Item[] items = new Item[]{foo};
        GildedRose gildedRose = new GildedRose(items);

        gildedRose.updateQuality();

        assertEquals(8, foo.quality);
    }

    @Test
    public void theQualityOfAnItemIsNeverMoreThan50() {
        Item foo = new Item("Aged Brie", 0, 50);
        Item[] items = new Item[]{foo};
        GildedRose gildedRose = new GildedRose(items);

        gildedRose.updateQuality();

        assertEquals(50, foo.quality);
    }

    @Test
    public void SulfurasNeverHasToBeSoldOrDecreasesInQuality() {
        Item foo = new Item("Sulfuras, Hand of Ragnaros", 10, 50);
        Item[] items = new Item[]{foo};
        GildedRose gildedRose = new GildedRose(items);

        gildedRose.updateQuality();

        assertEquals(10, foo.sellIn);
        assertEquals(50, foo.quality);
    }

    @Test
    public void ConjuredItemsDegradeInQualityTwiceAsFastAsNormalItems() {
        Item foo = new Item("Conjured", 10, 50);
        Item[] items = new Item[]{foo};
        GildedRose gildedRose = new GildedRose(items);

        gildedRose.updateQuality();

        assertEquals(48, foo.quality);
    }
}
