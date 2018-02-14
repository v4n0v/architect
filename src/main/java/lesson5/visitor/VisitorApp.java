package lesson5.visitor;

public class VisitorApp {
    public static void main(String[] args) {
        EngineElement engine = new EngineElement();
        BodyElement body = new BodyElement();
        HooliganVisitor hooliganVisitor = new HooliganVisitor();
//
//        engine.accept(hooliganVisitor);
//        body.accept(hooliganVisitor);

        CarElement carElement = new CarElement();
        carElement.accept(hooliganVisitor);

    }
}

interface Visitor {
    void visit(EngineElement engine);

    void visit(BodyElement engine);

    void visit(WheelElement wheelElement);

    void visit(CarElement carElement);
}

interface Element {
    void accept(Visitor visitor);
}

class EngineElement implements Element {

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

class CarElement implements Element {
    Element[] elements;

    public CarElement() {
        this.elements = new Element[]{
                new WheelElement("переднее левое"),
                new WheelElement("заднее левое"),
                new WheelElement("переднее правое"),
                new WheelElement("заднее правое"),
                new BodyElement(),
                new EngineElement()
        };
    }

    @Override
    public void accept(Visitor visitor) {
        for (Element e : elements) {
            e.accept(visitor);
        }
        visitor.visit(this);
    }
}


class WheelElement implements Element {
    public WheelElement(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

class BodyElement implements Element {

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

class MechanicVisitor implements Visitor {

    @Override
    public void visit(EngineElement engine) {
        System.out.println("Проверил двигатель");
    }

    @Override
    public void visit(BodyElement engine) {
        System.out.println("Проверил кузов");
    }

    @Override
    public void visit(WheelElement wheelElement) {
        System.out.println("Накачал "+wheelElement.getName()+ " колесо" );
    }

    @Override
    public void visit(CarElement carElement) {

    }
}

class HooliganVisitor implements Visitor {

    @Override
    public void visit(EngineElement engine) {
        System.out.println("Завел двигатель");
    }

    @Override
    public void visit(BodyElement engine) {
        System.out.println("Постучал по кузову");
    }

    @Override
    public void visit(WheelElement wheelElement) {
        System.out.println("Пнул "+wheelElement.getName()+ " колесо" );
    }

    @Override
    public void visit(CarElement carElement) {
        System.out.println("Покурил внутри машины" );
    }
}