package homework.hw3.car_window_factory.order_personal;

import homework.hw3.car_builer.simple.Car;
import homework.hw3.car_window_factory.order_interface.ClientCar;
import homework.hw3.car_window_factory.order_interface.Cashier;
import homework.hw3.car_window_factory.order_interface.Employer;
import homework.hw3.car_window_factory.order_interface.OrderFactory;

public class GlassOrderFactory implements OrderFactory {

    public ClientCar getCar() {return new OrderCar();}
    public Cashier getCashier() {
        return new OrderCashier();
    }
    public Employer getEmployer() {
        return new OrderEmployer();
    }

    // получаем образец через синглтон
    private static GlassOrderFactory instance = new GlassOrderFactory();
    private GlassOrderFactory() {
    }
    public static synchronized GlassOrderFactory getInstance(){
        return instance;
    }

}
