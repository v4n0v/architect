package lessons.lesson5.command;

abstract class RequestCommand implements CommandRequest{
    Operator operator;

    public RequestCommand(Operator operator) {
        this.operator = operator;
    }
}


interface CommandRequest{
    void execute();
}


class Operator{
    void insert(){
        System.out.println("insert");
    }
    void update(){
        System.out.println("update");
    }
    void select(){
        System.out.println("select");
    }
    void delete(){
        System.out.println("delete");
    }
}

class InsertCommand extends RequestCommand{

    public InsertCommand(Operator operator) {
        super(operator);
    }

    @Override
    public void execute() {
        operator.insert();
    }
}


class UpdateCommand extends RequestCommand{

    public UpdateCommand(Operator operator) {
        super(operator);
    }

    @Override
    public void execute() {
        operator.update();
    }
}

class DeleteCommand extends RequestCommand{

    public DeleteCommand(Operator operator) {
        super(operator);
    }

    @Override
    public void execute() {
        operator.delete();
    }
}
class SelectCommand extends RequestCommand{

    public SelectCommand(Operator operator) {
        super(operator);
    }

    @Override
    public void execute() {
        operator.select();
    }
}