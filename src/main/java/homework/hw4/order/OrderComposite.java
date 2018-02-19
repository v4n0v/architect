package homework.hw4.order;

import homework.hw3.car_window_factory.order_interface.Employer;
import homework.hw3.car_window_factory.order_personal.GlassOrderFactory;
import homework.hw3.service_type_fabric_method.Service;
import homework.hw3.service_type_fabric_method.ServiceMaker;
import homework.hw3.service_type_fabric_method.ServiceType;
import homework.hw4.Execute;

import java.util.ArrayList;
import java.util.List;


public class OrderComposite implements Execute{
    GlassOrderFactory factory;
    ArrayList<Employer> employers;
    ServiceMaker serviceMaker;
    Service service;

    List<Execute> orderList = new ArrayList<>();

    public OrderComposite(ServiceType serviceType) {
//        factory = GlassOrderFactory.getInstance();
//        employers = new ArrayList<Employer>();
//        serviceMaker = ServiceFabric.getServiceByType(serviceType);
//        service= serviceMaker.createService();

    }
    public void addEmployer(){
        employers.add(factory.getEmployer());
    }

//    OrderCashier cashier = (OrderCashier) factory.getCashier();
//    OrderEmployer employer = (OrderEmployer) factory.getEmployer();
//    Car car = (Car) factory.getCar();

    public void addComponent(Execute component){
        orderList.add(component);
    }
    public void removeComponent(Execute component){
        orderList.remove(component);
    }


    @Override
    public void execute() {
        for (Execute component: orderList){
            component.execute();
        }
    }
}
