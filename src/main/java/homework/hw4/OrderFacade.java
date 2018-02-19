package homework.hw4;

import homework.hw3.car_window_factory.order_interface.Cashier;
import homework.hw3.car_window_factory.order_interface.ClientCar;
import homework.hw3.car_window_factory.order_interface.Employer;
import homework.hw3.car_window_factory.order_personal.GlassOrderFactory;
import homework.hw3.service_type_fabric_method.Service;
import homework.hw3.service_type_fabric_method.ServiceFabric;
import homework.hw3.service_type_fabric_method.ServiceMaker;
import homework.hw3.service_type_fabric_method.ServiceType;

public class OrderFacade {
    // создаем фабрику, формирующую болваку заказа
    // создаем абстрактные объекты
    GlassOrderFactory factory = GlassOrderFactory.getInstance();
    Cashier cashier = factory.getCashier();
    Employer employer = factory.getEmployer();
    ClientCar clientCar = factory.getCar();


    public void execute() {
        // создаем услугу
        ServiceMaker serviceMaker = ServiceFabric.getServiceByType(ServiceType.REPLACE);
        Service service = serviceMaker.createService();

        // выполняем заказ

        System.out.println("\n<<<<Новый заказ на замену стекла>>>>");

        cashier.createsOrder();
        clientCar.enteredBox();
        service.execute();
        employer.startedOrder();
        employer.finishedOrder();
        clientCar.leftBox();
        System.out.println("<<<<Заказ на замену стекла выполнен>>>>");
    }

}
