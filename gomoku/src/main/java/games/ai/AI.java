package games.ai;


import games.model.Board;
import games.model.Location;

/**
 * Created by wangdehao on 18/1/16.
 */
public class AI {
    public int sleepTime = 500;

    public Location getLocationBasedOnBoard(Board board) throws InterruptedException {
        return new Location("0,0");
    }
}
