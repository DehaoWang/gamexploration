package games.model;

/**
 * Created by wangdehao on 18/1/25.
 */
public class Location {
    int x;
    int y;


    public Location(String loc) {
        String[] locs = loc.split(",");
        this.x = Integer.parseInt(locs[0]);
        this.y = Integer.parseInt(locs[1]);
    }

    public Location(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return "Location{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
