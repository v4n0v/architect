package lesson3.factory;

public class CitilinkExchangeFactory implements ExchangeFactory {

    public PriceProvider createPriceProvider() {
        return new CitilinkPriceProvider();
    }

    public DocProvider createDocProvider() {
        return new CitilinkDocProvider();
    }

    public MarketingProvider createMarketingProvider() {
        return new CitilinkMarketingProvider();
    }
}
