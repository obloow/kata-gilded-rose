/* Do not touch this file */
package com.gildedrose;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Item[] items = new Item[]{
            new Item("+5 Dexterity Vest", 10, 20), //
            new Item("Aged Brie", 2, 0), //
            new Item("Elixir of the Mongoose", 5, 7), //
            new Item("Sulfuras, Hand of Ragnaros", 0, 80), //
            new Item("Sulfuras, Hand of Ragnaros", -1, 80),
            new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
            new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
            new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
            // this conjured item does not work properly yet
            new Item("Conjured Mana Cake", 3, 6)};

        GildedRose app = new GildedRose(items);

        StringBuilder sb = new StringBuilder();

        int days = 30;
        for (int i = 0; i <= days; i++) {
            sb.append("-------- day ").append(i).append(" --------").append("\n");
            sb.append("name, sellIn, quality").append("\n");
            for (Item item : items) {
                sb.append(item).append("\n");
            }
            sb.append("\n");
            app.updateQuality();
        }

        try {
            File myObj = new File("actual_output.txt");
            myObj.createNewFile();
            FileWriter myWriter = new FileWriter("actual_output.txt");
            myWriter.write(sb.toString());
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
