package lessons.lesson4.composite;

import java.util.ArrayList;
import java.util.List;

public class CompsiteApp {
    public static void main(String[] args) {

        Square sq1= new Square();
        Triangle tri = new Triangle();
        Round round1 = new Round();

        Square sq12= new Square();
        Triangle tri2 = new Triangle();
        Triangle tri3 = new Triangle();
        Triangle tri4 = new Triangle();
        Round round2 = new Round();

        Composite composite = new Composite();

        composite.addComponent(sq1);
        composite.addComponent(tri);
        composite.addComponent(round1);

        Composite composite1 = new Composite();
        composite1.addComponent(tri2);
        composite1.addComponent(tri3);
        composite1.addComponent(tri4);

        composite.addComponent(composite1);
        composite.draw();
    }
}


interface Shape{
    void draw();
}

class Square implements Shape{

    @Override
    public void draw() {
        System.out.println("drawing square");
    }
}

class Round implements Shape{

    @Override
    public void draw() {
        System.out.println("drawing round");
    }
}

class Triangle implements Shape{

    @Override
    public void draw() {
        System.out.println("drawing triangle");
    }
}

class Composite implements Shape{

    private List<Shape> components = new ArrayList<>();

    public void addComponent(Shape component){
        components.add(component);
    }
    public void removeComponent(Shape component){
        components.remove(component);
    }
    @Override
    public void draw() {
        for (Shape component: components){
            component.draw();
        }
    }
}