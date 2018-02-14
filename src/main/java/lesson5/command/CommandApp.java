package lesson5.command;

public class CommandApp {
    public static void main(String[] args) {
      Computer comp = new Computer();
      User user = new User (new StartCommand(comp), new StopCommand(comp), new ResetCommand(comp));

      user.startComputer();
      user.stopComputer();
      user.resetComputer();
    }
}
interface Command {
    void execute();
}


abstract class Commando implements Command {
    Computer computer;

    public Commando(Computer computer) {
        this.computer = computer;
    }

}


class Computer  {
    void start(){
        System.out.println("Start");
    }
    void stop(){
        System.out.println("Stop");
    }
    void reset(){
        System.out.println("Reset");
    }

}


class StartCommand extends Commando{
    public StartCommand(Computer computer) { super(computer);}

    @Override
    public void execute() {
        computer.start();
    }
}

class StopCommand extends Commando{

    public StopCommand(Computer computer) {super(computer); }

    @Override
    public void execute() {
        computer.stop();
    }
}

class ResetCommand extends Commando{

    public ResetCommand(Computer computer) {super(computer); }

    @Override
    public void execute() {
        computer.reset();
    }
}



class User {
    Commando start;
    Commando stop;
    Commando reset;

    public User(Commando start, Commando stop, Commando reset) {
        this.start = start;
        this.stop = stop;
        this.reset = reset;
    }

    void startComputer(){
        start.execute();
    }
    void stopComputer(){
        stop.execute();
    }
    void resetComputer(){
        reset.execute();
    }
}