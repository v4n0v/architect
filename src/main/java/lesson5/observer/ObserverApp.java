package lesson5.observer;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;


public class ObserverApp {
    public static void main(String[] args) {
        MeteoStation station = new MeteoStation();

        station.addObserver(new ConsoleObserver());
        station.addObserver(new FileObserver());

        station.setWeather(21, 760);
        station.setWeather(26, 740);
    }

}

interface Observer {
    void handleEvent(int temp, int pressure);
}

interface Observed {
    void addObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObserver();
}

class MeteoStation implements Observed {
    int temp;
    int pressure;

    List<Observer> observers = new ArrayList<>();

    public void setWeather(int temp, int pressure) {
        this.temp = temp;
        this.pressure = pressure;
        notifyObserver();
    }

    @Override
    public void addObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObserver() {
        for (Observer o : observers) {
            o.handleEvent(temp, pressure);
        }
    }
}


class ConsoleObserver implements Observer {

    @Override
    public void handleEvent(int temp, int pressure) {
        System.out.println("Погода изменилась. Температура = " + temp + ", давление = " + pressure + ".");
    }
}


class FileObserver implements Observer {

    @Override
    public void handleEvent(int temp, int pressure) {
        File f;

        try {
            f = File.createTempFile("temp-pressure", "txt");
            PrintWriter pw = new PrintWriter(f);
            pw.print("Погода изменилась. Температура = " + temp + ", давление = " + pressure + ".");
            pw.println();
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}