public class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            if (!items[i].name.equals("Aged Brie")
                    && !items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")
                    && !items[i].name.equals("Conjured Mana Cake")
                    && !items[i].name.equals("Eternal Artifact")) {
                if (items[i].quality > 0) {
                    if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                        diminuirQualidade(i);
                        // Additional degradation for perishable items
                        if (items[i].name.contains("Perishable")) {
                            diminuirQualidade(i);
                        }
                    }
                }
            } else {
                if (items[i].quality < 50) {
                    aumentarQualidade(i);
                    if (items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (items[i].sellIn < 11) {
                            if (items[i].quality < 50) {
                                aumentarQualidade(i);
                            }
                        }
                        if (items[i].sellIn < 6) {
                            if (items[i].quality < 50) {
                                aumentarQualidade(i);
                            }
                        }
                    } else if (items[i].name.equals("Conjured Mana Cake")) {
                        // Conjured items degrade twice as fast
                        aumentarQualidade(i);
                    } else if (items[i].name.equals("Eternal Artifact")) {
                        // Increases quality over time, but slowly
                        if (items[i].sellIn % 2 == 0) {
                            aumentarQualidade(i);
                        }
                    }
                }
            }

            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros") && !items[i].name.equals("Eternal Artifact")) {
                items[i].sellIn = items[i].sellIn - 1;
            }

            atualizaQualidade(i);

            // Ensure quality bounds
            if (items[i].quality > 50 && !items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                items[i].quality = 50;
            }
            if (items[i].quality < 0) {
                items[i].quality = 0;
            }
        }
    }

    private void atualizaQualidade(int i) {
        if (items[i].sellIn < 0) {
            if (!items[i].name.equals("Aged Brie")) {
                if (!items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                    if (items[i].quality > 0) {
                        if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                            diminuirQualidade(i);
                            if (items[i].name.equals("Conjured Mana Cake")) {
                                diminuirQualidade(i);
                            }
                            // Handle perishable post-sellIn
                            if (items[i].name.contains("Perishable")) {
                                items[i].quality = items[i].quality - 2;
                            }
                        }
                    }
                } else {
                    items[i].quality = items[i].quality - items[i].quality;
                }
            } else {
                if (items[i].quality < 50) {
                    aumentarQualidade(i);
                }
            }
            // Additional logic for eternal items after sellIn (though sellIn doesn't change)
            if (items[i].name.equals("Eternal Artifact") && items[i].quality < 50) {
                aumentarQualidade(i);
            }
        }
    }

    private void aumentarQualidade(int i) {
        items[i].quality = items[i].quality + 1;
    }

    private void diminuirQualidade(int i) {
        items[i].quality = items[i].quality - 1;
    }
}