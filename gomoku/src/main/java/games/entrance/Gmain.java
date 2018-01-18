package games.entrance;

import games.ai.AI;
import games.ai.AreaStraAI;
import games.ai.SimpleAI;
import games.model.Engine;
import games.model.Game;
import games.model.Player;

/**
 * Created by wangdehao on 18/1/15.
 */
public class Gmain {

    public static void main(String[] args) throws InterruptedException {
        int boardSize = 15;
        int cntOfWin = 5;
        boolean printInfo = true;
        int sleepTimeForSingleStep = 200;
        int sleepTimeForSingleGame = 0;
        int numOfGames = 1;

        int winCntForPlayerA = 0;
        int winCntForPlayerB = 0;

        for(int i = 0; i < numOfGames; i++){
            AI aiA = new SimpleAI(sleepTimeForSingleStep);
            Player playerA = new Player("A", aiA);
//            Player playerA = new Player("A");

            AI aiB = new AreaStraAI(sleepTimeForSingleStep);
            Player playerB = new Player("B", aiB);

            Game gomoku = new Game(playerA, playerB, boardSize, cntOfWin, printInfo);

            Engine engine = new Engine(gomoku);
            engine.getLocationOfStep();
            if(gomoku.getWinnerPlayer() == playerA){
                winCntForPlayerA++;
            }
            if(gomoku.getWinnerPlayer() == playerB){
                winCntForPlayerB++;
            }
            if(printInfo){
                System.out.println("Player A win " + winCntForPlayerA + " times");
                System.out.println("Player B win " + winCntForPlayerB + " times");
            }
            Thread.sleep(sleepTimeForSingleGame);
        }
        System.out.println("Player A win " + winCntForPlayerA + " times");
        System.out.println("Player B win " + winCntForPlayerB + " times");
    }
}
