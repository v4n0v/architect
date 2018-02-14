

import hw3.car_builer.simple.Car;
import hw3.car_builer.simple.CarBodyType;
import hw3.car_builer.simple.CarBuilder;
import hw3.car_window_factory.order_personal.OrderCashier;
import hw3.car_window_factory.order_personal.OrderEmployer;
import hw4.order.OrderComposite;
import hw3.service_type_fabric_method.ServiceType;
import hw4.CarExecute;
import hw4.OrderFacade;
import hw5.*;


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

        CarExecute orderCar = new CarExecute(car, 2010);
        OrderComposite orderExecutor = new OrderComposite(ServiceType.REPLACE);
        orderExecutor.addComponent(new OrderCashier());
        orderExecutor.addComponent(orderCar);
        orderExecutor.addComponent(new OrderEmployer());
        orderExecutor.execute();


        OrderFacade order = new OrderFacade();
        order.execute();

/// HomeWork 5 см класс hw5/ManagerCommand
//        OrderOperation orderOperation = new OrderOperation();
//        User manager = new ManagerUser(orderOperation);
//        User admin = new AdministratorUser(orderOperation);
//        User employer = new EmployerUser(orderOperation);
//
//        manager.init(1111, "Ольга Ольгина");
//        admin.init(2222, "Наталья Натальина");
//        employer.init(10101, "Петр Петров");
//
//        manager.createOrder(1102321);
//        System.out.println();
//
//        manager.editOrder(1102321);
//        System.out.println();
//
//        admin.editOrder(1102321);
//        System.out.println();
//
//        manager.showOrder(1102321);
//        System.out.println();
//
//        employer.deleteOrder(1102321);
//        System.out.println();
//
//        admin.deleteOrder(1102321);
//        System.out.println();
    }
}
