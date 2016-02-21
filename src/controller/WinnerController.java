package controller;

import game.model.Field;
import game.model.Figure;
import game.model.exception.InvalidePointException;

import java.awt.*;

public class WinnerController {

    public Figure getWinner(final Field field){
        try {
        for (int i = 0; i < 3; i++){
            if (check(field, new Point(i,0),point -> new Point(point.x,point.y+1) ))
                return field.getFigure(new Point(i,0));
                }

            for (int i = 0; i < 3; i++){
                if (check(field, new Point(i,0),point -> new Point(point.x+1,point.y) ))
                    return field.getFigure(new Point(i,0));
                if (check(field, new Point(0,0),  point -> new Point(point.x+1,point.y+1) ))
                    return field.getFigure(new Point(0,0));
                if (check(field, new Point(0,2),point -> new Point(point.x+1,point.y-1) ))
                    return field.getFigure(new Point(1,1));
            }
        } catch (InvalidePointException e) {
            e.printStackTrace();
        }
        return null;
    }


 public boolean check(final Field field, final Point currentPoint, final IPointGenerator pointGenerator){
     final Figure currentFigure;
     final Figure nextFigure;
     final Point nextPoint = pointGenerator.next(currentPoint);
     try {
        currentFigure = field.getFigure(currentPoint);
         nextFigure = field.getFigure(nextPoint);
     } catch (InvalidePointException e) {
        return true;
     }


     if (currentFigure != null) return false;
     if(currentFigure != nextFigure) return false;
     return check(field,nextPoint,pointGenerator);

 }



    /*Внутренний класс*/
    private interface IPointGenerator{

        public Point next(final Point point);
    }
}
