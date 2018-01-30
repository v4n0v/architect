package hw3.service_type_fabric_method;

public class ServiceFabric {

    public static ServiceMaker getServiceByType(ServiceType type){
        if (type==ServiceType.REPLACE)
            return new ReplaceServiceMaker();
        else if (type==ServiceType.REPAIR)
            return new RepaireServiceMaker();

        throw new RuntimeException("Мы таким не занимаемся, за кого вы нас принимаете?!?");
    }

}




class ReplaceCarGlass implements Service {
    public void execute() {
        System.out.println("Услуга: Замена автостекла.");
    }
}

class CrackRepairCarGlass implements Service {
    public void execute() {
        System.out.println("Услуга: Удаление скола.");
    }
}


class ReplaceServiceMaker implements ServiceMaker{
    public Service createService() {
        return new ReplaceCarGlass();
    }
}
class RepaireServiceMaker implements ServiceMaker{
    public Service createService() {
        return new CrackRepairCarGlass();
    }
}