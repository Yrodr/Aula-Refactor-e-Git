public class GildedRose {
    listaItem[] item;

    public GildedRose(listaItem[] itemAtual) {
        this.item = itemAtual;
    }

    public void atualizarItens() {
        for (int i = 0; i < item.length; i++) {
            listaItem atual = item[i];
            boolean Backstage = !atual.name.equals("Backstage passes to a TAFKAL80ETC concert");
            boolean manaCake = !atual.name.equals("Conjured Mana Cake");
            boolean eternalArtifact = !atual.name.equals("Eternal Artifact");
            boolean Sulfuras = atual.name.equals("Sulfuras, Hand of Ragnaros");

            if (!atual.name.equals("Aged Brie")
                    && Backstage
                    && manaCake
                    && eternalArtifact) {
                if (atual.quality > 0) {
                    if (!Sulfuras) {
                        diminuirQualidade(i);
                        // Additional degradation for perishable items
                        if (atual.name.contains("Perishable")) {
                            diminuirQualidade(i);
                        }
                    }
                }
            } else {
                if (atual.quality < 50) {
                    aumentarQualidade(i);
                    if (atual.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (atual.sellIn < 11) {
                            if (atual.quality < 50) {
                                aumentarQualidade(i);
                            }
                        }
                        if (atual.sellIn < 6) {
                            if (atual.quality < 50) {
                                aumentarQualidade(i);
                            }
                        }
                    } else if (atual.name.equals("Conjured Mana Cake")) {
                        // Conjured items degrade twice as fast
                        aumentarQualidade(i);
                    } else if (atual.name.equals("Eternal Artifact")) {
                        // Increases quality over time, but slowly
                        if (atual.sellIn % 2 == 0) {
                            aumentarQualidade(i);
                        }
                    }
                }
            }

            if (!Sulfuras && eternalArtifact) {
                atual.sellIn = atual.sellIn - 1;
            }

            atualizaQualidade(i);

            // Ensure quality bounds
            if (atual.quality > 50 && !Sulfuras) {
                atual.quality = 50;
            }
            if (atual.quality < 0) {
                atual.quality = 0;
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
                    //Mudado para receber 0 ao invés de .quality - quality
                    item[i].quality = 0 ;
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