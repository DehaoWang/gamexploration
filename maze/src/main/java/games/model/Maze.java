package games.model;

/**
 * Created by wangdehao on 18/1/25.
 */
public class Maze {
    private Space[][] maze;
    private int mazeSizeM;
    private int mazeSizeN;

    public Maze(int mazeSizeM, int mazeSizeN) {
        this.mazeSizeM = mazeSizeM;
        this.mazeSizeN = mazeSizeN;
        this.init();
    }

    public void init() {
        this.maze = new Space[mazeSizeM][mazeSizeN];
        for(int i = 0; i < mazeSizeM; i++){
            for(int j = 0; j < mazeSizeN; j++){
                maze[i][j] = new Space();
            }
        }
    }

    public void setBlock(int x, int y){
        maze[x][y].setBlocked(true);
    }

    public int getMazeSizeM() {
        return mazeSizeM;
    }

    public void setMazeSizeM(int mazeSizeM) {
        this.mazeSizeM = mazeSizeM;
    }

    public int getMazeSizeN() {
        return mazeSizeN;
    }

    public void setMazeSizeN(int mazeSizeN) {
        this.mazeSizeN = mazeSizeN;
    }

    public Space getSpace(int i, int j){
        return maze[i][j];
    }
}
