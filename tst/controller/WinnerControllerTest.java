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
    public void testGetWinnerWhenNoRowWinner() throws Exception {

        final WinnerController winnerController = new WinnerController();
        for(int i = 0; i < 3; i++){
            final Field field = new Field(3);
            field.setFigure(new Point(i, 0), Figure.X);
            field.setFigure(new Point(i, 1), Figure.X);
            field.setFigure(new Point(i, 2), Figure.O);
            assertNull(winnerController.getWinner(field));

        }

    }
    @Test
    public void testGetWinnerWhenWinnerColumn() throws Exception {

        final WinnerController winnerController = new WinnerController();
        for(int i = 0; i < 3; i++){
            final Field field = new Field(3);
            field.setFigure(new Point(0, i), Figure.O);
            field.setFigure(new Point(1, i), Figure.O);
            field.setFigure(new Point(2, i), Figure.O);
            winnerController.getWinner(field);
            assertEquals(Figure.O,winnerController.getWinner(field));

        }

    }
    @Test
    public void testGetWinnerWhenNoWinnerColumn() throws Exception {

        final WinnerController winnerController = new WinnerController();
        for(int i = 0; i < 3; i++){
            final Field field = new Field(3);
            field.setFigure(new Point(0, i), Figure.O);
            field.setFigure(new Point(1, i), Figure.O);
            field.setFigure(new Point(2, i), Figure.X);
            winnerController.getWinner(field);
            assertNull(winnerController.getWinner(field));

        }

    }


    @Test
    public void testGetWinnerDiagonalByX() throws Exception {

        final WinnerController winnerController = new WinnerController();

            final Field field = new Field(3);
            field.setFigure(new Point(0, 0), Figure.X);
            field.setFigure(new Point(1, 1), Figure.X);
            field.setFigure(new Point(2, 2), Figure.X);

            assertEquals(Figure.X, winnerController.getWinner(field));



    }

    @Test
    public void testGetWinnerDiagonalByY() throws Exception {

        final WinnerController winnerController = new WinnerController();
        final Field field = new Field(3);
        field.setFigure(new Point(0, 2), Figure.X);
        field.setFigure(new Point(1, 1), Figure.X);
        field.setFigure(new Point(2, 0), Figure.X);

            assertEquals(Figure.X, winnerController.getWinner(field));



    }

    @Test
    public void testGetWinnerNoDiagonalByY() throws Exception {

        final WinnerController winnerController = new WinnerController();
        final Field field = new Field(3);
        field.setFigure(new Point(0, 2), Figure.X);
        field.setFigure(new Point(1, 1), Figure.X);
        field.setFigure(new Point(2, 0), Figure.O);

        assertNull( winnerController.getWinner(field));



    }

    @Test
    public void testGetWinnerNoDiagonalByX() throws Exception {

        final WinnerController winnerController = new WinnerController();
        final Field field = new Field(3);
        field.setFigure(new Point(0, 0), Figure.X);
        field.setFigure(new Point(1, 1), Figure.X);
        field.setFigure(new Point(2, 2), Figure.O);

        assertNull(winnerController.getWinner(field));



    }

}