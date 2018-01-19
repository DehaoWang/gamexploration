package games.ai;

import games.model.Game;
import games.model.Location;
import games.model.Player;

import java.util.Random;

/**
 * Created by wangdehao on 18/1/16.
 */
public class Lv1RandomMoveAI extends AI{
    // set shrinkSize, get win rate
    // 1 - 75.0%
    // 2 - 90.0%
    // 3 - 97.5%
    // 4 - 99.5%
    int shrinkStart = 0;

    public Lv1RandomMoveAI(int sleepTime, int shrinkStart) {
        this.sleepTime = sleepTime;
        this.shrinkStart = shrinkStart;
    }

    @Override
    public Location getLocationBasedOnBoard(Game game, Player movePlayer) throws InterruptedException {

        int boardSize = game.getBoard().getBoardSize();

        int sizeAfterShrink = boardSize-2*shrinkStart;

        Random random = new Random();
        int x = shrinkStart + Math.abs(random.nextInt()) % sizeAfterShrink;
        int y = shrinkStart + Math.abs(random.nextInt()) % sizeAfterShrink;
        Thread.sleep(sleepTime);
        return new Location(x,y);
    }
}
