package lesson4.bridge;

public class ProgramCreator {
    public static void main(String[] args) {
        Program[] programs = {
            new BankSystem(new JavaDeveloper()),
            new StockExchange(new CppDeveloper()),
                new OnlineRecource(new JavaDeveloper())
        };

        for (Program program: programs){
            program.showProcecc();
            System.out.println("");
        }

    }
}

abstract class Program{
    Developer developer;
    Program(Developer developer){
        this.developer=developer;
    }
    public abstract void developProgram();
    void showProcecc(){
        developProgram();
        developer.writeCode();
    }}

interface  Developer{
    void writeCode();
}

class JavaDeveloper implements Developer{
    @Override
    public void writeCode() {
        System.out.println("Java разработчик пишет код");
    }
}

class CppDeveloper implements Developer{
    @Override
    public void writeCode() {
        System.out.println("C++ разработчик пишет код");
    }
}

class BankSystem extends Program {
    protected  BankSystem(Developer developer){
        super(developer);
    }

    @Override
    public void developProgram() {
        System.out.println("Bank system in progress");

    }
}

class OnlineRecource extends Program{

    OnlineRecource(Developer developer) {
        super(developer);
    }

    @Override
    public void developProgram() {
        System.out.println("Online recource in progress");
    }
}

class StockExchange extends Program {
    protected StockExchange(Developer developer){
        super(developer);
    }

    @Override
    public void developProgram() {
        System.out.println("StockExchange in progress");

    }
}