package lesson5.template_method;

public class TemplateMethod {
    public static void main(String[] args) {
       A a  = new A();
       a.templateMethod();

        B b  = new B();
        b.templateMethod();
    }
}
interface TempMethod{
    void method();
}

abstract class C{
    void templateMethod(){
        System.out.println("1");
        differ();
        System.out.println("3");
    }
    abstract void differ();
}

class A extends C{


    @Override
    void differ() {
        System.out.println("2");
    }
}

class B extends C{


    @Override
    void differ() {
        System.out.println("4");
    }
}