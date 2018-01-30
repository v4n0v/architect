package hw3.car_builer.simple;

import java.util.ArrayList;

public class CarBuilder {
    private String mark = "Noname";
    private String model = "Noname";
    private int year = 0;
    private CarBodyType type;
    private int article;
    ArrayList<Generation> generations = new ArrayList<Generation>();

   public  CarBuilder buildMark(String mark) {
        this.mark = mark;
        return this;
    }

    public CarBuilder buildModel(String model) {
        this.model = model;
        return this;
    }

    public CarBuilder buildArticle(int article) {
        this.article = article;
        return this;
    }

    public  CarBuilder buildGeneration(int from, int to) {
        generations.add(new Generation(from, to));

        return this;
    }

    public  CarBuilder buildBodyType(CarBodyType type) {
        this.type = type;

        return this;
    }

    public Car build() {
        Car carGlass = new Car();
        carGlass.setArticle(article);
        carGlass.setModel(model);
        carGlass.setMark(mark);
        carGlass.setBodyType(type);

        carGlass.setGenerations(generations);
        return carGlass;
    }


}
