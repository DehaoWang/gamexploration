package games.model;

/**
 * Created by wangdehao on 18/1/16.
 */
public class Game {
    private Board board;
    Player player0;
    Player player1;

    int movePlayerId = 0;
    Player movePlayer;
    private int stepNum = 1;
    private int roundNum = 1;
    private boolean onGoing = true;
    private Player winnerPlayer = null;
    private boolean printInfo = true;
    private int cntOfWin = 0;

    public Game(Player player0, Player player1, int boardSize, int cntOfWin, boolean printInfo) {
        this.player0 = player0;
        this.player1 = player1;
        movePlayer = player0;
        board = new Board();
        board.init(boardSize, cntOfWin, printInfo);
        this.printInfo = printInfo;
        this.cntOfWin = cntOfWin;
    }


    public void roundStep(Location location){
        boolean successPut = board.putPiece(location.getX(), location.getY(), movePlayer.getName(), roundNum);
        if(!successPut){
            return;
        }
        if(stepNum % 2 == 0){
            roundNum++;
        }
        if(printInfo){
            board.printBoard();
        }
        validateBoard(player0, player1);

        // switch player
        movePlayerId = 1 - movePlayerId;
        if(movePlayerId == 0){
            movePlayer = player0;
        }
        else {
            movePlayer = player1;
        }
        stepNum++;
    }

    public String validateBoard(Player p0, Player p1){
        if(validate(p0)){
            if(printInfo){
                System.out.print("The winner is " + p0.getName() + ".");
            }
            onGoing = false;
            winnerPlayer = p0;
        }
        if(validate(p1)){
            if(printInfo) {
                System.out.print("The winner is " + p1.getName() + ".");
            }
            onGoing = false;
            winnerPlayer = p1;
        }
        if(!onGoing){
            if(printInfo){
                System.out.println(" The evaluate move is " + board.getWinnerLocation().toString());
            }
        }
        return "noBody";
    }

    public boolean validate(Player p) {
        if(board.validateDegree0(p) >= cntOfWin){
            return true;
        }
        if(board.validateDegree45(p) >= cntOfWin){
            return true;
        }
        if(board.validateDegree90(p) >= cntOfWin){
            return true;
        }
        if(board.validateDegree135(p) >= cntOfWin){
            return true;
        }
        return false;
    }

    public boolean isOnGoing() {
        return onGoing;
    }

    public Player getMovePlayer() {
        return movePlayer;
    }

    public Board getBoard() {
        return board;
    }

    public Player getWinnerPlayer() {
        return winnerPlayer;
    }

    public Player getPlayer0() {
        return player0;
    }

    public Player getPlayer1() {
        return player1;
    }

    public void makeMove(Location location, Player player){
        board.putPiece(location.getX(), location.getY(), player.getName(), 0);
    }

    public void resetMove(Location location) {
        board.setSpace(location.getX(), location.getY(), new Space());
    }
}
