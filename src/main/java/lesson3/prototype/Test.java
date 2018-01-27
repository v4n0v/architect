package ru.geekbrains.pattern.lesson3.prototype;

public class Test {
    public static void main(String[] args) {
        ComplicatedObject prototype = new ComplicatedObject();

        ComplicatedObject clone = prototype.copy();

        clone.setType(ComplicatedObject.Type.ONE);


    }

}
