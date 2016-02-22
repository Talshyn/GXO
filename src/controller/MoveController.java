package controller;

import game.model.Field;
import game.model.Figure;
import game.model.exception.AlreadyOccupiedException;
import game.model.exception.InvalidPointException;

import java.awt.*;

public class MoveController {
    public void applyFigure(Field field, Point point, Figure figure) throws AlreadyOccupiedException, InvalidPointException {
         /*If the space is not empty*/
        if(field.getFigure(point)!=null){
            throw new AlreadyOccupiedException();
        }
        field.setFigure(point,figure);
    }
}
