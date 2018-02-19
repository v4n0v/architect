package homework.hw6;

import homework.hw3.car_builer.simple.Car;

import java.util.HashMap;
import java.util.Map;

public class DataMapper {

    Map<Long, Auto> autoMap = new HashMap<>();

    public DataMapper() {

        // при создании экземпляра забираем из базы все объекты, кладем их в autoMap

        // select * from auto;
        System.out.println("Объекты взяты из базы");

    }


    public static void main(String[] args) {

        Auto auto0 = new Auto(1, "Audi", "A4");
        Auto auto1 = new Auto(2, "Audi", "A6");
        Auto auto2 = new Auto(3, "BMW", "5 ser");
        Auto auto3 = new Auto(3, "BMW", "3 ser");
        DataMapper dm = new DataMapper();

        dm.insertAuto(auto0);
        dm.insertAuto(auto1);
        dm.insertAuto(auto2);
        dm.insertAuto(auto3);

        Auto auto = dm.getAuto(1);
        System.out.println(auto);

        dm.delAuto(1);

        auto=dm.getAuto(1);
        System.out.println(auto);

    }

    private void insertAuto(Auto auto) {
        // добавляем в базу через JDBС
        // prepared statement
        //insert into auto (id, mark,model) values (auto.id, auto.mark, auto.model);
        System.out.println(auto.getMark()+" "+auto.getModel()+" добавлена в базу");
        // добавляем в коллекцию
        autoMap.put(auto.getId(), auto);
    }


    private Auto getAuto(long id) {
        // если колелкция пуста, заполняем ее из базы
        if (autoMap.size()==0)
            selectFromDB();
        return autoMap.get(id);
    }

    private void delAuto(long id) {
        // prepared statement
        // delete from auto where id = auto.id;
        System.out.println("Запись удалена из базы");
        autoMap.remove(id);
    }





    private void insertDB(Auto auto) {

    }

    private void selectFromDB( ) {



    }
}

class Auto {
    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    private String mark;
    private String model;

    public Auto(long id, String mark, String model) {
        this.id = id;
        this.mark = mark;
        this.model = model;
    }

    @Override
    public String toString() {
        return this.id+": "+this.mark+", "+this.model;
    }
}


