package  lessons.lesson3.factory;

public class CitilinkDocProvider implements DocProvider {

    public  Doc getDoc(int id) {
        return new Doc();
    }

    public void sendPayment(Payment payment) {

    }
}
