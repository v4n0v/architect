package lessons.lesson4.facade;

public class FacadeApp {
    public static void main(String[] args) {
//        Power power = new Power();
//        power.on();
//
//        DVDrom dvd = new DVDrom();
//        dvd.loadData();
//
//        HDD hdd = new HDD();
//        hdd.copyFromDVD(dvd);
//
//        power.off();

        Computer computer = new Computer();
        computer.copy();
    }
}

class Computer {
    private Power power = new Power();
    private DVDrom dvd = new DVDrom();
    private HDD hdd = new HDD();

    void copy() {
        power.on();
        dvd.loadData();
        hdd.copyFromDVD(dvd);
    }
}

class Power {
    void on() {
        System.out.println("Влючение питания");
    }

    void off() {
        System.out.println("Вылючение питания");
    }
}

class DVDrom {
    public boolean isData() {
        return data;
    }

    private boolean data = false;

    void loadData() {
        data = true;
    }

    void unloadData() {
        data = false;
    }
}

class HDD {
    void copyFromDVD(DVDrom dvd) {
        if (dvd.isData()) {
            System.out.println("Происходит копирование");
        } else {
            System.out.println("Вставьте диск в DVD");
        }
    }
}
