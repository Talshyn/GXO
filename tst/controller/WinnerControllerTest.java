package controller;

import game.model.Field;
import game.model.Figure;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;


public class WinnerControllerTest {

    @Test
    public void testGetWinnerWhenWinnerRow() throws Exception {

    final WinnerController winnerController = new WinnerController();
        for(int i = 0; i < 3; i++){
            final Field field = new Field(3);
            field.setFigure(new Point(i, 0), Figure.X);
            field.setFigure(new Point(i, 1), Figure.X);
            field.setFigure(new Point(i, 2), Figure.X);
            winnerController.getWinner(field);
            assertEquals(Figure.X,winnerController.getWinner(field));

        }

    }
    @Test
    public void testGetWinnerWhenNoWinner() throws Exception {

        final WinnerController winnerController = new WinnerController();
        for(int i = 0; i < 3; i++){
            final Field field = new Field(3);
            field.setFigure(new Point(i, 0), Figure.X);
            field.setFigure(new Point(i, 1), Figure.X);
            field.setFigure(new Point(i, 2), Figure.O);
            assertNull(winnerController.getWinner(field));

        }

    }


}