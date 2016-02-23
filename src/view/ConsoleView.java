package view;


import controller.CurrentMoveController;
import controller.MoveController;
import controller.WinnerController;
import game.model.Field;
import game.model.Figure;
import game.model.Game;
import game.model.exception.AlreadyOccupiedException;
import game.model.exception.InvalidPointException;

import java.awt.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleView {
    private final CurrentMoveController currentMoveController = new CurrentMoveController();
    private final WinnerController winnerController = new WinnerController();
    private final MoveController moveController = new MoveController();

    private void printLine(final Field field, final int x) {
        printSeparator();
        for(int y = 0;y < field.getSize(); y++){
            final Figure figure;
            try {
                figure = field.getFigure(new Point(y,x));
            } catch (InvalidPointException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
            System.out.print(figure != null ? figure : " ");
            System.out.print('|');

        }
        System.out.println();

    }

    private void printSeparator() {
        System.out.println("-------");
    }




    public void show(final Game game){
        System.out.format("Game's name :%s\n",game.getName());
        final Field field =game.getField();
        for(int x = 0; x< field.getSize(); x++){
            printLine(field,x);
        }
        printSeparator();


    }


    public boolean move(final Game game){
        final Field field = game.getField();

        final Figure winner = winnerController.getWinner(field);
        if(winner != null){
            System.out.format("Winner is %s !!!!", winner);
            return false;}
        final Figure currentFigure = currentMoveController.currentMove(field);
        if (currentFigure == null){
            System.out.println("No winner and no moves left");
            return false;}

        System.out.format("Please enter move point %s\n", currentFigure);
        final Point point = askPoint();
        try {
            try {
                moveController.applyFigure(field,point,currentFigure);
            } catch (final InvalidPointException e) {
                System.out.println("Point is invalid");
            }
        } catch (final AlreadyOccupiedException e) {
            System.out.println("Point is invalid");
        }


        return true;

    }

    private Point askPoint(){
        return new Point(askCoordinate("X")-1, askCoordinate("Y")-1);
    }



    private int askCoordinate(String coordinateName) {
        System.out.format("Please input%s", coordinateName);

        final Scanner in = new Scanner(System.in);
        try {
            return in.nextInt();
        } catch (final InputMismatchException e) {
            System.out.println("O_O ololololo!!!");
            return askCoordinate(coordinateName);
        }

    }



}
