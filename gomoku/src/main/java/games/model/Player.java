package games.model;


import games.ai.AI;

/**
 * Created by wangdehao on 18/1/16.
 */
public class Player {
    private AI ai = null;

    private String name = "";

    public Player(String n) {
        name = n;
    }

    public Player(String n, AI ai) {
        this.name = n;
        this.ai = ai;
    }
    public String getName() {
        return name;
    }

    public boolean hasAi() {
        return ai != null;
    }

    public AI getAi() {
        return ai;
    }
}
