package games.model;

import java.util.Scanner;

/**
 * Created by wangdehao on 18/1/16.
 */
public class Engine {
    Game gomokuGame;

    public Engine(Game gomokuGame) {
        this.gomokuGame = gomokuGame;
    }

    public void getLocationOfStep() throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        Location location;
        while(gomokuGame.isOnGoing()){
            Player movePlayer = gomokuGame.getMovePlayer();
            if(movePlayer.hasAi()){
                location = movePlayer.getAi().getLocationBasedOnBoard(gomokuGame, movePlayer);
            }
            else {
                System.out.println("please input the piece location for player: "+movePlayer.getName());
                location = new Location(scanner.next());
            }
            gomokuGame.roundStep(location);
        }
    }
}
