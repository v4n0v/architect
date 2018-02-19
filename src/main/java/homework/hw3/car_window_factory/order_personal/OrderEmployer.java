package homework.hw3.car_window_factory.order_personal;

import homework.hw3.car_window_factory.order_interface.Employer;
import homework.hw4.Execute;

public class OrderEmployer extends Person implements Employer, Execute {

    public void startedOrder() {
        System.out.println("Сотрудник "+getName()+ " начал(а) обработку заказа");
    }

    public void finishedOrder() {
        System.out.println("Сотрудник "+getName()+" закончил(а) обработку заказа");
    }

    @Override
    public void execute() {

            System.out.println("Сотрудник "+getName()+ " выполняет заказ");
    }
}
