package games.model;

/**
 * Created by wangdehao on 18/1/19.
 */
public class Space {
    private final String DEFAULT_FILLER = "+  ";
    private String filler;
    private boolean available = true;

    public Space() {
        filler = DEFAULT_FILLER;
    }

    public void setFiller(String filler) {
        this.filler = filler;
        available = false;
    }

    public String getFiller() {
        return filler;
    }

    public boolean isAvailable() {
        return available;
    }


}
