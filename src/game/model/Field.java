package game.model;

import java.awt.*;

/**
 * Created by user on 20.02.2016.
 */
public class Field {

    private static final int FIELD_SIZE = 3;
    private Figure[][] field = new Figure[FIELD_SIZE][FIELD_SIZE];

    public int getSize(){
        return FIELD_SIZE;
    }

    public Figure getFigure(final Point point){
        return field[point.x][point.y];
    }
    public void setFigure(final Point point, Figure figure){
        field[point.x][point.y] = figure;
    }
}
