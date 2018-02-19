package ru.geekbrains.pattern.lesson3.builder;

public class BuilderExample {
    public static void main(String[] args) {
        Director director = new Director();
        ComputerBuilder cheapComputerBuilder = new CheapComputerBuilder();

        director.setComputerBuilder(cheapComputerBuilder);
        director.constructComputer();

        Computer computer = director.getComputer();
    }
}
