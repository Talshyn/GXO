package game.model;

import game.model.exception.AlreadyOccupiedException;
import game.model.exception.InvalidPointException;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;


public class FieldTest {

    @Test
    public void testGetSize() throws Exception {
    final Field field = new Field(3);
        assertEquals(3,field.getSize());
    }

    @Test
    public void testSetFigure() throws Exception {
      final Point inputPoint = new Point(0,0);
        final Figure inputFigure = Figure.X;

        final Field field = new Field(3);

        field.setFigure(inputPoint,inputFigure);
        final Figure actualPoint = field.getFigure(inputPoint);

        assertEquals(inputFigure, actualPoint);

    }

    @Test
    public void testGetFigureWhenItisntSetted() throws Exception {
        final Point inputPoint = new Point(0,0);
        final Field field = new Field(3);

        final Figure actualPoint = field.getFigure(inputPoint);

        assertNull(actualPoint);

    }
    @Test
    public void testGetFigureWhenXisLessZero() throws Exception {
        final Point inputPoint = new Point(-1,0);
        final Field field = new Field(3);
        try {
            final Figure actualPoint = field.getFigure(inputPoint);
            fail();
        }catch (final InvalidPointException e){}

    }
    @Test
    public void testGetFigureWhenYisLessZero() throws Exception {
        final Point inputPoint = new Point(0,-1);
        final Field field = new Field(3);
        try {
            final Figure actualPoint = field.getFigure(inputPoint);
            fail();
        }catch (final InvalidPointException e){}

    }
    @Test
    public void testGetFigureWhenXisMoreSize() throws Exception {
        final Field field = new Field(3);
        final Point inputPoint = new Point(field.getSize()+1,0);

        try {
            final Figure actualPoint = field.getFigure(inputPoint);
            fail();
        }catch (final InvalidPointException e){}

    }
    @Test
    public void testGetFigureWhenYisMoreSize() throws Exception {
        final Field field = new Field(3);
        final Point inputPoint = new Point(0,field.getSize()+1);

        try {
            final Figure actualPoint = field.getFigure(inputPoint);
            fail();
        }catch (final InvalidPointException e){}

    }
}