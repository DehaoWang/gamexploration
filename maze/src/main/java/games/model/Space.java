package games.model;

/**
 * Created by wangdehao on 18/1/25.
 */
public class Space {
    private boolean blocked = false;
    private String filler = ".";
    private String blockFiller = "#";

    public boolean isBlocked() {
        return blocked;
    }

    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }

    public String getFiller() {
        if(blocked){
            return blockFiller;
        }
        return filler;
    }

    public void setFiller(String filler) {
        this.filler = filler;
    }
}
