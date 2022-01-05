# kata-gilded-rose

The Gilded Rose Kata

Inspired by:

https://github.com/emilybache/GildedRose-Refactoring-Kata

*Reminder: read **the full README** before starting to write code!*

## Specifications


Hi and welcome to team Gilded Rose. As you know, we are a small inn with a prime location in a
prominent city ran by a friendly innkeeper named Allison. We also buy and sell only the finest goods.
Unfortunately, our goods are constantly degrading in quality as they approach their sell by date. We
have a system in place that updates our inventory for us. It was developed by a no-nonsense type named
Leeroy, who has moved on to new adventures. Your task is to add the new feature to our system so that
we can begin selling a new category of items. First an introduction to our system:

* All items have a SellIn value which denotes the number of days we have to sell the item
* All items have a Quality value which denotes how valuable the item is
* At the end of each day our system lowers both values for every item

Pretty simple, right? Well this is where it gets interesting:

* Once the sell by date has passed, Quality degrades twice as fast
* The Quality of an item is never negative
* "Aged Brie" actually increases in Quality the older it gets
* The Quality of an item is never more than 50
* "Sulfuras", being a legendary item, never has to be sold or decreases in Quality
* "Backstage passes", like aged brie, increases in Quality as its SellIn value approaches, but:
    * Quality increases by 2 when there are 10 days or less
    * Quality increases by 3 when there are 5 days or less
    * Quality drops to 0 after the concert

We have recently signed a supplier of conjured items. This requires an update to our system:

* "Conjured" items degrade in Quality twice as fast as normal items

Feel free to make any changes to the UpdateQuality method and add any new code as long as everything
still works correctly. However, do not alter the Item class or Items property as those belong to the
goblin in the corner who will insta-rage and one-shot you as he doesn't believe in shared code
ownership.

Just for clarification, an item can never have its Quality increase above 50, however "Sulfuras" is a
legendary item and as such its Quality is 80 and it never alters.

## Instructions

1. Choose a programming language and a test framework you know well and fork this repo.

2. Write a small piece of code to run  the main entry point and check it produces *exactly*
the standard output matching the text in golden-master/expected-output.txt. It may be possible to to use
the test framework to do that.

3. Execute a series of *small* refactorings, while *adding* more tests in the process. If you have access to
refactoring features from your IDE, use them.

4. Make a commit at the end of each refactoring

5. When the production code is clean enough and you have enough tests (and **only then**), implement the
"conjured items" feature.

