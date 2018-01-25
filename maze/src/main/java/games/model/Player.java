package games.model;

import games.ai.Task1Ai;

import java.util.List;

/**
 * Created by wangdehao on 18/1/25.
 */
public class Player {
    private Task1Ai task1Ai;
    private String name = "Explorer";

    private int currRoundNum = 0;
    private Location initLocation;
    private Location currLocation;

    private List<MoveRecord> moveRecords;

    public Player(Task1Ai task1Ai, String name) {
        this.task1Ai = task1Ai;
        this.name = name;
    }

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getInitial(){
        return name.substring(0,1);
    }

    public void setName(String name) {
        this.name = name;
    }

    public Location getInitLocation() {
        return initLocation;
    }

    public void setInitLocation(Location initLocation) {
        this.initLocation = initLocation;
    }

    public Location getCurrLocation() {
        return currLocation;
    }

    public void setCurrLocation(Location currLocation) {
        this.currLocation = currLocation;
    }

    public Task1Ai getTask1Ai() {
        return task1Ai;
    }

    public void setTask1Ai(Task1Ai task1Ai) {
        this.task1Ai = task1Ai;
    }

    public void initLocation(Location location) {
        initLocation = location;
        currLocation = location;
    }

    public void recordFeedBack(Direction direction, FeedBack feedBack) {
//        moveRecords.add(new MoveRecord(currRoundNum, currLocation, direction, feedBack));

    }
}
