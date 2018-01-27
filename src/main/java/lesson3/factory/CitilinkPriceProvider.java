package ru.geekbrains.pattern.lesson3.factory;



public class CitilinkPriceProvider implements PriceProvider {
    private Catalog catalog;

    @Override
    public Money getPrice(String article) {
        return catalog.findByArticle(article).getPrice(article);
    }

}
