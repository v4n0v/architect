package hw3.car_window_factory.order_personal;

import hw3.car_window_factory.order_interface.ClientCar;
import hw3.car_window_factory.order_interface.Cashier;
import hw3.car_window_factory.order_interface.Employer;
import hw3.car_window_factory.order_interface.OrderFactory;

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
