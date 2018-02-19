package homework.hw3.car_builer.simple;

import java.util.ArrayList;

public class Generation {

    private int fromYear;
    private int toYear;

    public static ArrayList<Generation> gen = new ArrayList<Generation>();

    Generation (int from, int to){
       this.fromYear=from;
       this.toYear=to;
    }

    public void addGeneration(int from, int to){
        gen.add(new Generation(from, to));
    }

    public int getToYear() {
        return toYear;
    }
    public int getFromYear() {
        return fromYear;
    }



    public int getGeneration(int generation){


        return 0;
    }

}
