package games.entrance;

import games.ai.Task1Ai;
import games.model.Engine;
import games.model.Game;
import games.model.Maze;
import games.model.Player;

/**
 * Created by wangdehao on 18/1/15.
 */
public class Mmain {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("MAZE");

        Maze maze = new Maze(9, 9);
        Task1Ai task1Ai = new Task1Ai();
        Player player = new Player("Exp1");
        player.setTask1Ai(task1Ai);
        Game game = new Game(maze, player, 4, 4, 5);
        game.getMaze().setBlock(5, 5);
        game.printState();
        Engine engine = new Engine(game);
        engine.gameRun();

    }
}
