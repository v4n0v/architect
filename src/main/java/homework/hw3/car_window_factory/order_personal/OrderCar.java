package homework.hw3.car_window_factory.order_personal;

import homework.hw3.car_builer.simple.Car;
import homework.hw3.car_builer.simple.Generation;
import homework.hw3.car_window_factory.order_interface.ClientCar;
import homework.hw4.Execute;

public class OrderCar extends Car implements ClientCar, Execute {


    public void enteredBox() {System.out.println("Машина заехала в бокс");}
    public void leftBox() {
        System.out.println("Машина покинула бокс");
    }
}
