package hw3.car_builer.advanced;

public class BuilderAdvanced {
    public static void main(String[] args) {
        Director director = new Director();
       // director.setBuilder(new RenaultLoganBuilder());
        director.setBuilder(new HyundaiSolarisBuilder());
        Carrr car=director.buildCar();
        System.out.println(car);
    }
}
class Carrr {
    String mark;
    String model;

    int year;
//    CarsGlassType type;

    public void setMark(String mark) {
        this.mark = mark;
    }
    public void setModel(String model) {
        this.model = model;
    }


    public void setYear(int year) {
        this.year = year;
    }
    @Override
    public String toString() {
        return  mark+" " +model+"("+ year+")";
    }
//    public void setType(CarsGlassType type) {
//        this.type = type;
//    }
}
abstract class CarBuilder{
    Carrr car;
    void createCar(){
        car = new Carrr();
    }
    abstract void buildMark();
    abstract  void buildModel();
    abstract  void buildYear() ;
    Carrr getCar(){return car;}


}

class RenaultLoganBuilder extends CarBuilder{

    void buildMark() {
        car.setMark("Renault");
    }

    void buildModel( ) {
        car.setModel("Logan");
    }

    void buildYear(){
        car.setYear(2005);
    }
}
class HyundaiSolarisBuilder extends CarBuilder{

    void buildMark() {
        car.setMark("Hyundai");
    }

    void buildModel( ) {
        car.setModel("Solaris");
    }

    void buildYear(){
        car.setYear(2012);
    }
}

class Director{
    CarBuilder builder;
    void  setBuilder(CarBuilder b) {builder =b;}

    Carrr buildCar(){
        builder.createCar();
        builder.buildMark();
        builder.buildModel();
        builder.buildYear();
       Carrr car = builder.getCar();
       return car;
    }
}


