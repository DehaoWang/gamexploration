package games.model;

/**
 * Created by wangdehao on 18/1/18.
 */
public class Config {
    private int numOfGames = 100;
    private int sleepTimeForSingleGame = 2000;
    private int sleepTimeForSingleStep = 500;
    private int boardSize = 15;
    private int cntOfWin = 5;
    private boolean printInfo = true;

    public Config(int numOfGames, int sleepTimeForSingleGame, int sleepTimeForSingleStep, int boardSize, int cntOfWin, boolean printInfo) {
        this.numOfGames = numOfGames;
        this.sleepTimeForSingleGame = sleepTimeForSingleGame;
        this.sleepTimeForSingleStep = sleepTimeForSingleStep;
        this.boardSize = boardSize;
        this.cntOfWin = cntOfWin;
        this.printInfo = printInfo;
    }

    public Config() {
        
    }

    public int getNumOfGames() {
        return numOfGames;
    }

    public int getSleepTimeForSingleGame() {
        return sleepTimeForSingleGame;
    }

    public int getSleepTimeForSingleStep() {
        return sleepTimeForSingleStep;
    }

    public int getBoardSize() {
        return boardSize;
    }

    public int getCntOfWin() {
        return cntOfWin;
    }

    public boolean isPrintInfo() {
        return printInfo;
    }

    public void setSleepTimeForSingleStep(int sleepTimeForSingleStep) {
        this.sleepTimeForSingleStep = sleepTimeForSingleStep;
    }
}
