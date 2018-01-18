package games.ai;

import games.model.Board;
import games.model.Location;

import java.util.Random;

/**
 * Created by wangdehao on 18/1/16.
 */
public class SimpleAI extends AI{

    public SimpleAI(int sleepTime) {
        this.sleepTime = sleepTime;
    }

    @Override
    public Location getLocationBasedOnBoard(Board board) throws InterruptedException {
        int boardSize = board.getBoardSize();
        Random random = new Random();
        int x = Math.abs(random.nextInt()) % boardSize;
        int y = Math.abs(random.nextInt()) % boardSize;
        Thread.sleep(sleepTime);
        return new Location(x+","+y);
    }
}
