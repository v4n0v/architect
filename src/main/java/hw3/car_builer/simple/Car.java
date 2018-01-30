package hw3.car_builer.simple;

import java.util.ArrayList;

public class  Car {
    int article;
    String mark;
    String model;
    ArrayList<Generation> generations = new ArrayList<Generation>();
    int year;
    CarBodyType bodyType;

    public void setBodyType(CarBodyType bodyType) {
        this.bodyType = bodyType;
    }


    public void setArticle(int article) {
        this.article = article;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setGenerations(ArrayList<Generation> generations) {
        this.generations = generations;
    }

    public void setYear(int year) {
        this.year = year;
    }


    @Override
    public String toString() {
        return "[" + article + "] " + mark + " " + model + ", " + bodyType + "\n" + printGenerations();
    }

    public Generation getGeneration(int id){

        return generations.get(id);
    }

    private String printGenerations() {
        String gen = "";
        for (int i = 0; i < generations.size(); i++) {
            gen += "Generation " + (i + 1) + "(" + generations.get(i).getFromYear() + "-" + generations.get(i).getToYear() + ")\n";
        }
        return gen;
    }
}