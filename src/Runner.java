import game.model.Field;
import game.model.Figure;
import game.model.Game;
import game.model.Player;
import view.ConsoleView;


public class Runner {
    public static void main(String[] args) {
        final String name1 = "Talshyn";
        final String name2 = "Aygerim";

     final Field field = new Field(3);
        final Player[] players = new Player[2];
        players[0] = new Player(name1,Figure.X);
        players[1] = new Player(name2,Figure.O);

        final Game gameXO = new Game(players,field,"Game X&O");
        ConsoleView consoleView = new ConsoleView();
        consoleView.show(gameXO);
        while (consoleView.move(gameXO)){
            consoleView.show(gameXO);
        }




    }
}
