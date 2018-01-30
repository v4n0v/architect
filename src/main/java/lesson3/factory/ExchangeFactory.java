package lesson3.factory;

public interface ExchangeFactory {
    PriceProvider createPriceProvider();
    DocProvider createDocProvider();
    MarketingProvider createMarketingProvider();
}
