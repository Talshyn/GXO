package controller;


import game.model.Field;
import game.model.Figure;
import game.model.exception.InvalidPointException;

import java.awt.*;

public class CurrentMoveController {

    public Figure currentMove(final Field field){
        int countFigure = 0;

        for (int x=0;x < field.getSize();x++){
            countFigure+=countFiguresInTheRow(field,x);
            }
        if(countFigure == field.getSize()*field.getSize()){
            return null;
        }
        if(countFigure % 2 == 0){
            return Figure.X;
        }
        return Figure.O;
    }

    private int countFiguresInTheRow(final Field field,final int row){
        int countFigure = 0;
        for(int y=0; y < field.getSize();y++){
            try {
                if (field.getFigure(new Point(y,row)) != null){
                    countFigure++;
                }
            } catch (InvalidPointException e) {
                e.printStackTrace();
            }
        }
        return countFigure;
    }
}
