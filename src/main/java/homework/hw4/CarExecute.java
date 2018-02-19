package homework.hw4;

import homework.hw3.car_builer.simple.Car;


public class CarExecute implements Execute {
        private Car car;
        private int gen;
        int year;

        public CarExecute (Car car, int year){
            this.car = car;
            this.year = year;
            gen = getGeneration(car);
        }

        public int getGeneration(Car car){
            for (int i = 0; i < car.getGenerations().size(); i++) {
                if (year>=car.getGenerations().get(i).getFromYear()&&year<=car.getGenerations().get(i).getToYear()){
                    return i;
                }
            }
            return 0;
        }

        @Override
        public String toString() {
            return  car.getMark() + " " + car.getModel()
                    + ", " + car.getBodyType() + ", поколение="+(gen+1)+"("+year+")";
        }

        @Override
        public void execute() {
            System.out.println("Авто клиента - "+this );
        }
}


