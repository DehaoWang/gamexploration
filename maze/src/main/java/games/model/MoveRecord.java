package games.model;

/**
 * Created by wangdehao on 18/1/25.
 */
public class MoveRecord {
    private int currRoundNum = 0;
    private Location currLocation;
    private Direction direction;
    private FeedBack feedBack;

    public MoveRecord(int currRoundNum, Location currLocation, Direction direction, FeedBack feedBack) {
        this.currRoundNum = currRoundNum;
        this.currLocation = currLocation;
        this.direction = direction;
        this.feedBack = feedBack;
    }
}
