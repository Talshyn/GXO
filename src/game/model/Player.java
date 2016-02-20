package game.model;

/**
 * Created by user on 20.02.2016.
 */
public class Player {

    private final String name;
    private final Figure figure;


    public Player(String name, Figure figure) {
        this.name = name;
        this.figure = figure;
    }

    public Figure getFigure() {
        return figure;
    }

    public String getName() {
        return name;
    }
}
