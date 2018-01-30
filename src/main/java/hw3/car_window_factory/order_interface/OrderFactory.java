package hw3.car_window_factory.order_interface;

public interface OrderFactory {
    ClientCar getCar();
    Cashier getCashier();
    Employer getEmployer();

}
