package ru.geekbrains.pattern.lesson3.factory;

public class CitilinkDocProvider implements DocProvider {
    @Override
    public Doc getDoc(int id) {
        return new Doc();
    }

    @Override
    public void sendPayment(Payment payment) {

    }
}
