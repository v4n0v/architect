package hw5;


// реализация паттерна Цепочка событий
public class ServerRequestManager {
    public static void main(String[] args) {

        RequestExecutor showExecutor = new ShowRequestExecutor();
        RequestExecutor createExecutor = new InsertRequestExecutor();
        RequestExecutor delExecutor = new DeleteRequestExecutor();

        showExecutor.setNext(createExecutor);
        createExecutor.setNext(delExecutor);

        showExecutor.executeRequest(12321, RequestType.SHOW);
        showExecutor.executeRequest(31231, RequestType.DELETE);
    }
}
enum RequestType {
    INSERT, DELETE, EDIT, SHOW
}

 abstract class RequestExecutor {
    public void setNext(RequestExecutor next) {
        this.next = next;
    }

    protected RequestExecutor next;
    protected RequestType type;

    RequestExecutor(RequestType type){
        this.type=type;
    }

    void executeRequest(int orderID, RequestType type){
        if (type==this.type) {
            execute();
        }
        if (next!=null)
            next.executeRequest(orderID, type);
    }

    abstract  void execute();
}

 class InsertRequestExecutor extends RequestExecutor{

    InsertRequestExecutor( ) {
        super(RequestType.INSERT);
    }

    @Override
    void execute() {
        System.out.println("Обрабатывается запрос на добавление элемента в базу");
    }
}

class EditRequestExecutor extends RequestExecutor{

    EditRequestExecutor( ) {
        super(RequestType.EDIT);
    }

    @Override
    void execute() {
        System.out.println("Обрабатывается запрос на редактирование элемента в базе");
    }
}


 class DeleteRequestExecutor extends RequestExecutor{

    DeleteRequestExecutor( ) {
        super(RequestType.DELETE);
    }

    @Override
    void execute() {
        System.out.println("Обрабатывается запрос на удаление элемента из базы");
    }
}
class ShowRequestExecutor extends RequestExecutor{

    ShowRequestExecutor( ) {
        super(RequestType.SHOW);
    }

    @Override
    void execute() {
        System.out.println("Обрабатывается запрос на получение элемента из базы");
    }
}