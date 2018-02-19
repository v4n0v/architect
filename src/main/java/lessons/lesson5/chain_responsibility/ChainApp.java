package lessons.lesson5.chain_responsibility;

public class ChainApp {


    public static void main(String[] args) {
        Logger logger0 =new SMSLogger(Level.ERROR);
        Logger logger1 = new FileLogger(Level.DEBUG);
        Logger logger2 = new EmailLogger(Level.INFO);

        logger0.setNext(logger1);
        logger1.setNext(logger2);

        logger0.writeMessage("Все ок", Level.INFO);
        logger0.writeMessage("Работаем", Level.DEBUG);
        logger0.writeMessage("Все плохо", Level.ERROR);
    }

}


class Level{
    public static final int ERROR = 1;
    public static final int DEBUG = 2;
    public static final int INFO = 3;
}

abstract class Logger{

    public void setNext(Logger next) {
        this.next = next;
    }

    Logger next;
    int priority;

    public Logger(int priority) {
        this.priority = priority;
    }
    void writeMessage(String msg, int level){
        if (level<=priority)
            write(msg);
        if (next!=null)
            next.writeMessage(msg, level);
    }
    abstract void write(String msg);
}

class SMSLogger extends Logger{
    public SMSLogger(int priority) {super(priority);}
    public void write(String msg){System.out.println("SMS: "+msg);}
}

class FileLogger extends Logger{
    public FileLogger(int priority) {super(priority);}
    public void write(String msg){System.out.println("File: "+msg);}
}

class EmailLogger extends Logger{
    public EmailLogger(int priority) {super(priority);}
    public void write(String msg){System.out.println("File: "+msg);}
}