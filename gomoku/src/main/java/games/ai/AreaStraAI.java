package games.ai;

import games.model.Board;
import games.model.Location;

import java.util.Random;

/**
 * Created by wangdehao on 18/1/16.
 */
public class AreaStraAI extends AI{
    // vs. simpleAI: set shrinkSize, get win rate
    // 1 - 75.0%
    // 2 - 90.0%
    // 3 - 97.5%
    // 4 - 99.5%
    int shrinkStart = 2;

    public AreaStraAI(int sleepTime) {
        this.sleepTime = sleepTime;
    }

    @Override
    public Location getLocationBasedOnBoard(Board board) throws InterruptedException {
        int boardSize = board.getBoardSize();

        int sizeAfterShrink = boardSize-2*shrinkStart;

        Random random = new Random();
        int x = shrinkStart + Math.abs(random.nextInt()) % sizeAfterShrink;
        int y = shrinkStart + Math.abs(random.nextInt()) % sizeAfterShrink;
        Thread.sleep(sleepTime);
        return new Location(x+","+y);
    }
}
