package ru.geekbrains.pattern.lesson3.factory;



public interface DocProvider {
    Doc getDoc(int id);
    void sendPayment(Payment payment);

}
