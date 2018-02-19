package homework.hw3.car_window_factory.order_personal;

import homework.hw3.car_window_factory.order_interface.Cashier;
import homework.hw4.Execute;

public class OrderCashier extends Person implements Cashier, Execute{

    public void createsOrder() {
        System.out.println("Кассир "+getName()+" оформил(а) заказ");
    }

    @Override
    public void execute() {
        System.out.println("Кассир "+getName()+" оформил(а) заказ");
    }
}
