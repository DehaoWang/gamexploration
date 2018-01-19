package games.model;

/**
 * Created by wangdehao on 18/1/16.
 */
public class Board {
//    private final String emptyLocation = "+  ";
    private final int height = 1;
    private Space[][] board;
    private int boardSize;
    private int cntOfWin;
    private Location winnerLocation;
    private boolean printInfo = true;
    private Space space;

    public boolean putPiece(int x, int y, String movePlayerName, int roundNum){
        if(board[x][y].isAvailable()){
            board[x][y].setFiller(String.format("%-3s",movePlayerName + roundNum));
            return true;
        }
        else {
            if(printInfo){
                System.out.println("The location has an PIECE !");
            }
            return false;
        }
    }

    public void init(int boardSize, int cntOfWin, boolean printInfo) {
        this.printInfo = printInfo;
        this.boardSize = boardSize;
        board = new Space[boardSize][boardSize];
        this.cntOfWin = cntOfWin;
        for(int i = 0; i < boardSize; i++){
            for(int j = 0; j < boardSize; j++){
                board[i][j] = new Space();
            }
        }
    }

    public void printBoard(){
        System.out.println("==========================\nPrinting Current Board\n==========================");
        for(int i = 0; i < boardSize; i++){
            for(int j = 0; j < boardSize; j++){
                System.out.print(board[i][j].getFiller()+" ");
            }
            for(int k = 0; k < height; k++){
                System.out.println();
            }
        }
    }

    public int getBoardSize() {
        return boardSize;
    }

    public Location getWinnerLocation() {
        return winnerLocation;
    }

    public int validateDegree45(Player p) {
        int maxCombo = 0;
        for(int i = 0; i < boardSize; i++){
            for(int j = 0; j < boardSize; j++){
                if(i * j > 0){
                    continue;
                }
                int cnt = 0;
                for(int k = 0; k < boardSize-i-j; k++){
                    if(board[i+k][j+k].getFiller().charAt(0) == p.getName().charAt(0)){
                        cnt++;
                    }
                    else {
                        cnt = 0;
                    }
                    if(cnt == cntOfWin){
                        winnerLocation = new Location(i+k, j+k);
                    }
                    if(cnt > maxCombo){
                        maxCombo = cnt;
                    }
                }
            }
        }
        return maxCombo;
    }

    public int validateDegree135(Player p) {
        int maxCombo = 0;
        // j = 0
        for(int i = 0; i < boardSize; i++){
            int cnt = 0;
            for(int k = 0; k <= i; k++){
                if(board[i-k][k].getFiller().charAt(0) == p.getName().charAt(0)){
                    cnt++;
                }
                else {
                    cnt = 0;
                }
                if(cnt == cntOfWin){
                    winnerLocation = new Location(i-k, k);
                }
                if(cnt > maxCombo){
                    maxCombo = cnt;
                }
            }
        }
        // i = boardSize-1
        for(int j = 0; j < boardSize; j++){
            int cnt = 0;
            for(int k = 0; k < boardSize-j; k++){
                if(board[boardSize-1-k][j+k].getFiller().charAt(0) == p.getName().charAt(0)){
                    cnt++;
                }
                else {
                    cnt = 0;
                }
                if(cnt == cntOfWin){
                    winnerLocation = new Location(boardSize-1-k, j+k);
                }
                if(cnt > maxCombo){
                    maxCombo = cnt;
                }
            }
        }
        return maxCombo;
    }

    public int validateDegree0(Player p){
        int maxCombo = 0;
        for(int i = 0; i < boardSize; i++){
            int cnt = 0;
            for(int j = 0; j < boardSize; j++){
                if(board[i][j].getFiller().charAt(0) == p.getName().charAt(0)){
                    cnt++;
                }else {
                    cnt = 0;
                }
                if(cnt == cntOfWin){
                    winnerLocation = new Location(i, j);
                }
                if(cnt > maxCombo){
                    maxCombo = cnt;
                }
            }
        }
        return maxCombo;
    }

    public int validateDegree90(Player p){
        int maxCombo = 0;
        for(int j = 0; j < boardSize; j++){
            int cnt = 0;
            for(int i = 0; i < boardSize; i++){
                if(board[i][j].getFiller().charAt(0) == p.getName().charAt(0)){
                    cnt++;
                }else {
                    cnt = 0;
                }
                if(cnt == cntOfWin){
                    winnerLocation = new Location(i, j);
                }
                if(cnt > maxCombo){
                    maxCombo = cnt;
                }
            }
        }
        return maxCombo;
    }

    public Space getSpace(int i, int j){
        return board[i][j];
    }

    public void setSpace(int i, int j, Space space) {
        board[i][j] = space;
    }
}
