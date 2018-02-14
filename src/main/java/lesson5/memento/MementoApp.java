package lesson5.memento;

public class MementoApp {
    public static void main(String[] args) {
        Game game = new Game();
        game.set("level1", 123);
        System.out.println(game);

        File file = new File();
        file.setSave(game.saveGame());
        game.set("level2", 50000);
        System.out.println(game);

        System.out.println("Load game");
        game.loadGame(file.getSave());
        System.out.println(game);
    }

}

class Game{
    private String level;
    private int ms;


    public void set(String level, int ms) {
        this.level = level;
        this.ms = ms;
    }

    public Save saveGame(){
        return new Save(level, ms);
    }

    public void loadGame(Save save){
    level = save.getLevel();
    ms = save.getMs();
    }

    @Override
    public String toString() {
        return ms+" "+level;
    }
}

class Save{
    public String getLevel() {
        return level;
    }

    public int getMs() {
        return ms;
    }

    private final String level;
    private final int ms;



    public Save(String level, int ms) {
        this.level = level;
        this.ms = ms;
    }
}

class File{
    public Save getSave() {
        return save;
    }

    public void setSave(Save save) {
        this.save = save;
    }

    Save save;

}