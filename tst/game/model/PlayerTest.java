package game.model;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by user on 20.02.2016.
 */
public class PlayerTest {

    @Test
    public void testGetName() throws Exception {
        final String inputValue = "Talshyn";
        final String expectedValue = inputValue;

        final Player player = new Player(inputValue,null);
        final String actualValue = player.getName();
        assertEquals(expectedValue,actualValue);
    }

    @Test
    public void testGetFigure() throws Exception {
        final Figure inputValue = Figure.O;
        final Figure expectedValue = inputValue;

        final Player player = new Player(null,inputValue);
        final Figure actualValue = player.getFigure();
        assertEquals(expectedValue,actualValue);
    }
}