package homework.hw5;

// реализация паттерна Стратегия
public class ManagerStrategy {
    public static void main(String[] args) {

        Manager manager = new Manager();
        manager.init(123, "Марина Малинова");

        manager.setOperation(new CreateOrder());
        manager.executeOperation(1001);

        manager.setOperation(new DeleteOrder());
        manager.executeOperation(1001);
    }
}

class Manager{
    int id;
    String name;

    public void init(int id, String name) {
        this.id = id;
        this.name = name;
    }

    Operation operation;
    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public void executeOperation(int orderID){
        System.out.print(name+" выполняет: ");
        operation.execute(orderID);
    }


}

interface Operation{
    void execute(int orderID);
}

class CreateOrder implements Operation{

    @Override
    public void execute(int orderID) {
        System.out.println("создание заказа N"+orderID);
    }
}
class DeleteOrder implements Operation {

    @Override
    public void execute(int orderID) {
        System.out.println("удаление заказа N" + orderID);
    }
}