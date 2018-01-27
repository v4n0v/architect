package ru.geekbrains.pattern.lesson3.factory;

public interface PriceProvider {
    Money getPrice(String article);
}
