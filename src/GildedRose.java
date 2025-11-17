public class GildedRose {
    listaItem[] item;

    public GildedRose(listaItem[] itemAtual) {
        this.item = itemAtual;
    }

    public void atualizarItens() {
        for (int i = 0; i < item.length; i++) {
            if (!item[i].name.equals("Aged Brie")
                    && !item[i].name.equals("Backstage passes to a TAFKAL80ETC concert")
                    && !item[i].name.equals("Conjured Mana Cake")
                    && !item[i].name.equals("Eternal Artifact")) {
                if (item[i].quality > 0) {
                    if (!item[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                        diminuirQualidade(i);
                        // Additional degradation for perishable items
                        if (item[i].name.contains("Perishable")) {
                            diminuirQualidade(i);
                        }
                    }
                }
            } else {
                if (item[i].quality < 50) {
                    aumentarQualidade(i);
                    if (item[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (item[i].sellIn < 11) {
                            if (item[i].quality < 50) {
                                aumentarQualidade(i);
                            }
                        }
                        if (item[i].sellIn < 6) {
                            if (item[i].quality < 50) {
                                aumentarQualidade(i);
                            }
                        }
                    } else if (item[i].name.equals("Conjured Mana Cake")) {
                        // Conjured items degrade twice as fast
                        aumentarQualidade(i);
                    } else if (item[i].name.equals("Eternal Artifact")) {
                        // Increases quality over time, but slowly
                        if (item[i].sellIn % 2 == 0) {
                            aumentarQualidade(i);
                        }
                    }
                }
            }

            if (!item[i].name.equals("Sulfuras, Hand of Ragnaros") && !item[i].name.equals("Eternal Artifact")) {
                item[i].sellIn = item[i].sellIn - 1;
            }

            atualizaQualidade(i);

            // Ensure quality bounds
            if (item[i].quality > 50 && !item[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                item[i].quality = 50;
            }
            if (item[i].quality < 0) {
                item[i].quality = 0;
            }
        }
    }

    private void atualizaQualidade(int i) {
        if (item[i].sellIn < 0) {
            if (!item[i].name.equals("Aged Brie")) {
                if (!item[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                    if (item[i].quality > 0) {
                        if (!item[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                            diminuirQualidade(i);
                            if (item[i].name.equals("Conjured Mana Cake")) {
                                diminuirQualidade(i);
                            }
                            // Handle perishable post-sellIn
                            if (item[i].name.contains("Perishable")) {
                                item[i].quality = item[i].quality - 2;
                            }
                        }
                    }
                } else {
                    item[i].quality = item[i].quality - item[i].quality;
                }
            } else {
                if (item[i].quality < 50) {
                    aumentarQualidade(i);
                }
            }
            // Additional logic for eternal items after sellIn (though sellIn doesn't change)
            if (item[i].name.equals("Eternal Artifact") && item[i].quality < 50) {
                aumentarQualidade(i);
            }
        }
    }

    private void aumentarQualidade(int i) {
        item[i].quality = item[i].quality + 1;
    }

    private void diminuirQualidade(int i) {
        item[i].quality = item[i].quality - 1;
    }
}