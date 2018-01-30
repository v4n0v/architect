package hw3.car_window_factory.order_personal;

import hw3.car_window_factory.order_interface.Cashier;

public class OrderCashier extends Person implements Cashier{

    public void createsOrder() {
        System.out.println("Кассир "+getName()+" оформил(а) заказ");
    }
}
