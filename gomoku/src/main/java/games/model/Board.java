package games.model;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wangdehao on 18/1/16.
 */
public class Board {
//    private final String emptyLocation = "+  ";
    private final int HEIGHT = 1;
    private final int WIDTH = 3;
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
        for(int k = -1; k < boardSize; k++){
            System.out.print(String.format("%-3s", k));
        }
        System.out.println();
        for(int i = 0; i < boardSize; i++){
            System.out.print(String.format("%-3s", i));
            for(int j = 0; j < boardSize; j++){
                System.out.print(board[i][j].getFiller());
            }
            for(int k = 0; k < HEIGHT; k++){
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

    public int validateDegree45(Player player) {
        int maxCombo = 0;
        for(int i = 0; i < boardSize; i++){
            for(int j = 0; j < boardSize; j++){
                if(i * j > 0){
                    continue;
                }
                int cnt = 0;
                for(int k = 0; k < boardSize-i-j; k++){
                    if(board[i+k][j+k].getFiller().charAt(0) == player.getName().charAt(0)){
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

    public int validateDegree135(Player player) {
        int maxCombo = 0;
        // j = 0
        for(int i = 0; i < boardSize-1; i++){
            int cnt = 0;
            for(int k = 0; k <= i; k++){
                if(board[i-k][k].getFiller().charAt(0) == player.getName().charAt(0)){
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
                if(board[boardSize-1-k][j+k].getFiller().charAt(0) == player.getName().charAt(0)){
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

    public int validateDegree0(Player player){
        int maxCombo = 0;
        for(int i = 0; i < boardSize; i++){
            int cnt = 0;
            for(int j = 0; j < boardSize; j++){
                if(board[i][j].getFiller().charAt(0) == player.getName().charAt(0)){
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

    public int validateDegree90(Player player){
        int maxCombo = 0;
        for(int j = 0; j < boardSize; j++){
            int cnt = 0;
            for(int i = 0; i < boardSize; i++){
                if(board[i][j].getFiller().charAt(0) == player.getName().charAt(0)){
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


    public Map<Integer,Integer> validateDegree0v2(Player player) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        int maxCombo = 0;
        boolean writeMapFlag = false;
        for(int i = 0; i < boardSize; i++){
            int cnt = 0;
            for(int j = 0; j < boardSize; j++){
                if(board[i][j].getFiller().charAt(0) == player.getName().charAt(0)){
                    writeMapFlag = true;
                    cnt++;
                }else if(writeMapFlag){
                    increaseMapByKey(map, cnt);
                    cnt = 0;
                    writeMapFlag = false;
                }
                if(cnt == cntOfWin){
                    winnerLocation = new Location(i, j);
                }
                if(cnt > maxCombo){
                    maxCombo = cnt;
                }
            }
        }

        return map;
    }


    public Map<Integer,Integer> validateDegree45v2(Player player) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        int maxCombo = 0;
        boolean writeMapFlag = false;
        for(int i = 0; i < boardSize; i++){
            for(int j = 0; j < boardSize; j++){
                if(i * j > 0){
                    continue;
                }
                int cnt = 0;
                for(int k = 0; k < boardSize-i-j; k++){
                    if(board[i+k][j+k].getFiller().charAt(0) == player.getName().charAt(0)){
                        writeMapFlag = true;
                        cnt++;
                    }
                    else if(writeMapFlag){
                        increaseMapByKey(map, cnt);
                        cnt = 0;
                        writeMapFlag = false;
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

        return map;
    }

    public Map<Integer,Integer> validateDegree90v2(Player player) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        int maxCombo = 0;
        boolean writeMapFlag = false;
        for(int j = 0; j < boardSize; j++){
            int cnt = 0;
            for(int i = 0; i < boardSize; i++){
                if(board[i][j].getFiller().charAt(0) == player.getName().charAt(0)){
                    writeMapFlag = true;
                    cnt++;
                }else if(writeMapFlag){
                    increaseMapByKey(map, cnt);
                    cnt = 0;
                    writeMapFlag = false;
                }
                if(cnt == cntOfWin){
                    winnerLocation = new Location(i, j);
                }
                if(cnt > maxCombo){
                    maxCombo = cnt;
                }
            }
        }

        return map;
    }

    public Map<Integer,Integer> validateDegree135v2(Player player) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        int maxCombo = 0;
        // j = 0
        boolean writeMapFlag = false;
        for(int i = 0; i < boardSize-1; i++){
            int cnt = 0;
            for(int k = 0; k <= i; k++){
                if(board[i-k][k].getFiller().charAt(0) == player.getName().charAt(0)){
                    writeMapFlag = true;
                    cnt++;
                }
                else if(writeMapFlag){
                    increaseMapByKey(map, cnt);
                    cnt = 0;
                    writeMapFlag = false;
                }
                if(cnt == cntOfWin){
                    winnerLocation = new Location(i-k, k);
                }
                if(cnt > maxCombo){
                    maxCombo = cnt;
                }
            }
        }

        writeMapFlag = false;
        // i = boardSize-1
        for(int j = 0; j < boardSize; j++){
            int cnt = 0;
            for(int k = 0; k < boardSize-j; k++){
                if(board[boardSize-1-k][j+k].getFiller().charAt(0) == player.getName().charAt(0)){
                    writeMapFlag = true;
                    cnt++;
                }
                else if(writeMapFlag) {
                    increaseMapByKey(map, cnt);
                    cnt = 0;
                    writeMapFlag = false;
                }
                if(cnt == cntOfWin){
                    winnerLocation = new Location(boardSize-1-k, j+k);
                }
                if(cnt > maxCombo){
                    maxCombo = cnt;
                }
            }
        }

        return map;
    }


    private void increaseMapByKey(Map<Integer, Integer> map, int cnt) {
        Integer count = map.get(cnt);
        if(count == null){
            map.put(cnt, 1);
        }
        else {
            map.put(cnt, count + 1);
        }
    }
}
