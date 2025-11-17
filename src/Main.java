public class Main {
    public static void main(String[] args) {
        listaItem[] listaItems = new listaItem[] {
                new listaItem("+5 Dexterity Vest", 10, 20),
                new listaItem("Aged Brie", 2, 0),
                new listaItem("Elixir of the Mongoose", 5, 7),
                new listaItem("Sulfuras, Hand of Ragnaros", 0, 80),
                new listaItem("Backstage passes to a TAFKAL80ETC concert", 15, 20),
                new listaItem("Conjured Mana Cake", 3, 6),
                new listaItem("Eternal Artifact", 5, 40),
                new listaItem("Perishable Fruit", 4, 10)
        };

        GildedRose app = new GildedRose(listaItems);

        // Simulate one day
        app.atualizarItens();

        // Print updated items
        for (listaItem listaItem : listaItems) {
            System.out.println(listaItem);
        }
    }
}