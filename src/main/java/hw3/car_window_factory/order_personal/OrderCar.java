package hw3.car_window_factory.order_personal;

import hw3.car_builer.simple.Car;
import hw3.car_window_factory.order_interface.ClientCar;

public class OrderCar extends Car implements ClientCar {



    public void enteredBox() {
        System.out.println("Машина заехала в бокс");

    }

    public void leftBox() {
        System.out.println("Машина покинула бокс");
    }
}
