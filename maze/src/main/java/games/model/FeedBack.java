package games.model;

/**
 * Created by wangdehao on 18/1/25.
 */
public class FeedBack {
    // 0 -> valid
    // 1 -> invalid: block
    // 2 -> invalid: boundary
    // 3 -> invalid: b or b
    public static final int VALID = 0;
    public static final int BLOCK = 1;
    public static final int BOUNDARY = 2;
    public static final int BLOCK_OR_BOUNDARY = 3;


    private int type;

    public void setType(int type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }
}
