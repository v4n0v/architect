package homework.hw5;

// реализация паттерна Команда, вызывающего Цепочку событий

public class ManagerCommand {
    public static void main(String[] args) {

        OrderOperation orderOperation = new OrderOperation();
        User manager = new ManagerUser(orderOperation);
        User admin = new AdministratorUser(orderOperation);
        User employer = new EmployerUser(orderOperation);

        manager.init(1111, "Ольга Ольгина");
        admin.init(2222, "Наталья Натальина");
        employer.init(10101, "Петр Петров");

        manager.createOrder(1102321);
        System.out.println();

        manager.editOrder(1102321);
        System.out.println();

        admin.editOrder(1102321);
        System.out.println();

        manager.showOrder(1102321);
        System.out.println();

        employer.deleteOrder(1102321);
        System.out.println();

        admin.deleteOrder(1102321);
        System.out.println();

    }
}


interface Command {
    void execute(int orderID);
}


abstract class UserFunction implements Command {
    OrderOperation manager;

    public UserFunction(OrderOperation manager) {
        this.manager = manager;
    }
}

 class OrderOperation {
    RequestExecutor createExecutor;
    RequestExecutor showExecutor;
    RequestExecutor delExecutor;
    RequestExecutor editExecutor;

    public OrderOperation() {
        createExecutor = new InsertRequestExecutor();
        showExecutor = new ShowRequestExecutor();
        delExecutor = new DeleteRequestExecutor();
        editExecutor = new EditRequestExecutor();
        showExecutor.setNext(createExecutor);
        createExecutor.setNext(delExecutor);
        delExecutor.setNext(editExecutor);
    }


    public void createOrder(int orderID) {
        System.out.println("создание заказа " + orderID);
        createExecutor.executeRequest(orderID, RequestType.INSERT);

    }

    public void deleteOrder(int orderID) {
        System.out.println(" удалиление заказа " + orderID);
        delExecutor.executeRequest(orderID, RequestType.DELETE);

    }

    public void editOrder(int orderID) {
        System.out.println("редактирование заказа " + orderID);
        editExecutor.executeRequest(orderID, RequestType.EDIT);

    }

    public void showOrder(int orderID) {
        System.out.println("просмотр заказа " + orderID);
        showExecutor.executeRequest(orderID, RequestType.EDIT);

    }

}

class ShowOperation extends UserFunction {

    public ShowOperation(OrderOperation orderOperation) {
        super(orderOperation);
    }

    @Override
    public void execute(int orderID) {
        manager.showOrder(orderID);
    }
}


class CreateOperation extends UserFunction {

    public CreateOperation(OrderOperation orderOperation) {
        super(orderOperation);
    }

    @Override
    public void execute(int orderID) {
        manager.createOrder(orderID);
    }
}


class DeleteOperation extends UserFunction {

    public DeleteOperation(OrderOperation orderOperation) {
        super(orderOperation);
    }

    @Override
    public void execute(int orderID) {
        manager.deleteOrder(orderID);
    }
}

class EditOperation extends UserFunction {

    public EditOperation(OrderOperation orderOperation) {
        super(orderOperation);
    }

    @Override
    public void execute(int orderID) {
        manager.editOrder(orderID);
    }
}

  class User {
    private int id;
    private String name;

    public void init(int id, String name) {
        this.id = id;
        this.name = name;
    }


    UserFunction show;
    UserFunction create;
    UserFunction edit;
    UserFunction delete;

    public void showOrder(int orderID) {
        personalizeOperation(show, orderID);
    }

    public void createOrder(int orderID) {
        personalizeOperation(create, orderID);
    }

    public void editOrder(int orderID) {
        personalizeOperation(edit, orderID);
    }

    public void deleteOrder(int orderID) {
        personalizeOperation(delete, orderID);
    }

    void personalizeOperation(UserFunction userFunction, int orderID) {
        if (userFunction != null) {
            System.out.print("Пользователь " + name + " выполняет ");
            userFunction.execute(orderID);
        } else {
            System.out.println("У пользователя " + name + " нет прав на выполнение этой операции. ");
        }
    }
}

  class AdministratorUser extends User {
    //    OrderOperation orderOperation
    public AdministratorUser(OrderOperation orderOperation) {
        this.create = new CreateOperation(orderOperation);
        this.edit = new EditOperation(orderOperation);
        this.delete = new DeleteOperation(orderOperation);
        this.show = new ShowOperation(orderOperation);
    }
}

 class ManagerUser extends User {
    public ManagerUser(OrderOperation orderOperation) {
        this.create = new CreateOperation(orderOperation);
        this.show = new ShowOperation(orderOperation);
    }
}
  class EmployerUser extends User {

    public EmployerUser(OrderOperation orderOperation) {
        this.show = new ShowOperation(orderOperation);
    }
}