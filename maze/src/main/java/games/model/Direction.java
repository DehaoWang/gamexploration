package games.model;

/**
 * Created by wangdehao on 18/1/25.
 */
public class Direction {
    public static final int UP = 0;
    public static final int DOWN = 1;
    public static final int LEFT = 2;
    public static final int RIGHT = 3;

    private int direction = -1;

    public Direction(int direction) {
        this.direction = direction;
    }

    public int getDirection() {
        return direction;
    }
}
