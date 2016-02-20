package game.model;

import game.model.exception.AlreadyOccupiedException;
import game.model.exception.InvalidePointException;

import java.awt.*;

/**
 * Created by user on 20.02.2016.
 */
public class Field {

    private static final int FIELD_SIZE = 3;
    private static final int MIN_CORDINATE = 0;
    private static final int MAX_CORDINATE = FIELD_SIZE;
    private Figure[][] field = new Figure[FIELD_SIZE][FIELD_SIZE];

    public int getSize(){
        return FIELD_SIZE;
    }

    public Figure getFigure(final Point point) throws InvalidePointException{
        if(!checkPoint(point)) {
            throw new InvalidePointException();
        }
        return field[point.x][point.y];
    }
    public void setFigure(final Point point, Figure figure) throws InvalidePointException, AlreadyOccupiedException{
        if(!checkPoint(point)) {
            throw new InvalidePointException();
        }
        /*If the space is not empty*/
        if(field[point.x][point.y]!=null){
            throw new AlreadyOccupiedException();
        }
        field[point.x][point.y] = figure;
    }

    private boolean checkPoint(Point point){
    return checkCordinate(point.x) && checkCordinate(point.y);
    }

    private boolean checkCordinate(final int cordinate){
        return cordinate >= MIN_CORDINATE && cordinate < MAX_CORDINATE;
    }
}
