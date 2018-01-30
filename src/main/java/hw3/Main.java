package hw3;

import hw3.car_builer.simple.Car;
import hw3.car_builer.simple.CarBodyType;
import hw3.car_builer.simple.CarBuilder;
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

public class Main {
    public static void main(String[] args) {
        // создаем эклемпляр автомобля для записи в базу
        Car car = new CarBuilder()
                .buildArticle(100001)
                .buildMark("Renault")
                .buildModel("Logan")
                .buildBodyType(CarBodyType.SEDAN)
                .buildGeneration(2004, 2009)
                .buildGeneration(2009, 2015)
                .buildGeneration(2015, 5000)
                .build();
        System.out.println(car);

        // создаем фабрику, формирующую болваку заказа

// создаем абстрактные объекты
        GlassOrderFactory factory = GlassOrderFactory.getInstance();
        Cashier cashier = factory.getCashier();
        Employer employer = factory.getEmployer();
        ClientCar clientCar = factory.getCar();


// создаем конкретные объекты
//        GlassOrderFactory factory = GlassOrderFactory.getInstance();
//        OrderCashier cashier = (OrderCashier) factory.getCashier();
//        cashier.setName("Наталья Нательевна Наталевская");
//
//        OrderEmployer employer = (OrderEmployer) factory.getEmployer();
//        employer.setName("Иванов Иван Иванович");


        // создаем услугу
        ServiceMaker serviceMaker = ServiceFabric.getServiceByType(ServiceType.REPLACE);
        Service service = serviceMaker.createService();

        // выполняем заказ
        System.out.println("<<<<Новый клиент на замену стекла>>>>");

        cashier.createsOrder();
        clientCar.enteredBox();
        service.execute();
        employer.startedOrder();
        employer.finishedOrder();
        clientCar.leftBox();
    }
}
