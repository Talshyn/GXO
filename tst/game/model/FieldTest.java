package game.model;

import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

/**
 * Created by user on 20.02.2016.
 */
public class FieldTest {

    @Test
    public void testGetSize() throws Exception {
    final Field field = new Field();
        assertEquals(3,field.getSize());
    }

    @Test
    public void testSetFigure() throws Exception {
      final Point inputPoint = new Point(0,0);
        final Figure inputFigure = Figure.O;
        final Field field = new Field();
        field.setFigure(inputPoint,inputFigure);
        final Figure actualPoint = field.getFigure(inputPoint);
        assertEquals(inputFigure, actualPoint);

    }
}