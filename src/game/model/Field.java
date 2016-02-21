package game.model;

import game.model.exception.InvalidePointException;


import java.awt.*;

/**
 * Created by user on 20.02.2016.
 */
public class Field {


    private static final int MIN_CORDINATE = 0;
    private Figure[][] field;
    private  final int fieldsize;

    public Field(final int fieldsize) {
        this.fieldsize = fieldsize;
       field = new Figure[fieldsize][fieldsize];
    }

    public int getSize(){
        return fieldsize;
    }

    public Figure getFigure(final Point point) throws InvalidePointException{
        if(!checkPoint(point)) {
            throw new InvalidePointException();
        }
        return field[point.x][point.y];
    }
    public void setFigure(final Point point, Figure figure) throws InvalidePointException{
        if(!checkPoint(point)) {
            throw new InvalidePointException();
        }

        field[point.x][point.y] = figure;
    }

    private boolean checkPoint(Point point){
    return checkCordinate(point.x,field.length) && checkCordinate(point.y,field[point.x].length);
    }

    private boolean checkCordinate(final int coordinate,final int maxCooordinate){
        return coordinate >= MIN_CORDINATE && coordinate < maxCooordinate;
    }
}
