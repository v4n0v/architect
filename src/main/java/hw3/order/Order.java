package hw3.order;

import hw3.car_builer.simple.Car;
import hw3.car_window_factory.order_interface.Cashier;
import hw3.car_window_factory.order_interface.ClientCar;
import hw3.car_window_factory.order_interface.Employer;
import hw3.car_window_factory.order_personal.GlassOrderFactory;
import hw3.car_window_factory.order_personal.OrderCashier;
import hw3.car_window_factory.order_personal.OrderEmployer;
import hw3.service_type_fabric_method.Service;
import hw3.service_type_fabric_method.ServiceFabric;
import hw3.service_type_fabric_method.ServiceMaker;
import hw3.service_type_fabric_method.ServiceType;

import java.util.ArrayList;


public class Order {
    GlassOrderFactory factory;
    ArrayList<Employer> employers;
    ServiceMaker serviceMaker;
    Service service;

    public Order(ServiceType serviceType) {
        factory = GlassOrderFactory.getInstance();
        employers = new ArrayList<Employer>();
        serviceMaker = ServiceFabric.getServiceByType(serviceType);
        service= serviceMaker.createService();

    }
    public void addEmployer(){
        employers.add(factory.getEmployer());
    }

    OrderCashier cashier = (OrderCashier) factory.getCashier();
    OrderEmployer employer = (OrderEmployer) factory.getEmployer();
    Car car = (Car) factory.getCar();

}
