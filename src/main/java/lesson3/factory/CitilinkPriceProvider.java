package  lesson3.factory;



public class CitilinkPriceProvider implements PriceProvider {
    private Catalog catalog;

    public Money getPrice(String article) {
        return catalog.findByArticle(article).getPrice(article);
    }

}
