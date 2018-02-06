package lesson4.decorator;

import java.util.function.Predicate;

public class DecoratorApp {
    public static void main(String[] args) {
        PrinterInterface printer = new LeftBracketDecorator( new RightBracketDecorator( new QuoteDecorator(new Printer("Привет"))));

        printer.print();
    }
}


interface PrinterInterface {
    void print();
}

abstract class Decorator implements PrinterInterface{
   PrinterInterface component;
    public Decorator(PrinterInterface component) {
        this.component = component;
    }

    @Override
    public void print() {
        component.print();
    }
}

class Printer implements PrinterInterface {
    String val;
    public Printer(String val) {
        this.val = val;
    }

    @Override
    public void print() {
        System.out.print(val);
    }
}

class QuoteDecorator extends Decorator {

    public QuoteDecorator(PrinterInterface component) {
        super(component);
    }

    @Override
    public void print() {
        System.out.print("\"");
        super.print();
        System.out.print("\"");
    }
}

class LeftBracketDecorator extends Decorator {

    public LeftBracketDecorator(PrinterInterface component) {
       super(component);
    }

    @Override
    public void print() {
        System.out.print("(");
        super.print();
    }
}

class RightBracketDecorator extends Decorator {
    public RightBracketDecorator(PrinterInterface component) {
       super(component);
    }

    @Override
    public void print() {
        super.print();
        System.out.print(")");
    }
}