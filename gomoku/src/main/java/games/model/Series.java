package games.model;

/**
 * Created by wangdehao on 18/1/18.
 */
public class Series {

    public static void playSeries(Player playerA, Player playerB, Config config) throws InterruptedException {

        int winCntForPlayerA = 0;
        int winCntForPlayerB = 0;

        for(int i = 0; i < config.getNumOfGames(); i++){
            Game gomoku = new Game(playerA, playerB, config.getBoardSize(), config.getCntOfWin(), config.isPrintInfo());

            Engine engine = new Engine(gomoku);
            engine.getLocationOfStep();
            if(gomoku.getWinnerPlayer() == playerA){
                winCntForPlayerA++;
            }
            if(gomoku.getWinnerPlayer() == playerB){
                winCntForPlayerB++;
            }
            if(config.isPrintInfo()){
                System.out.println("Player "+playerA.getName()+" win " + winCntForPlayerA + " times");
                System.out.println("Player "+playerB.getName()+" win " + winCntForPlayerB + " times");
            }
            Thread.sleep(config.getSleepTimeForSingleGame());
        }
        System.out.println("Player "+playerA.getName()+" win " + winCntForPlayerA + " times");
        System.out.println("Player "+playerB.getName()+" win " + winCntForPlayerB + " times");
    }
}
