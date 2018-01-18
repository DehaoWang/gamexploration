package games.entrance;

import games.ai.AI;
import games.ai.AreaStraAI;
import games.ai.SimpleAI;
import games.model.*;


/**
 * Created by wangdehao on 18/1/15.
 */
public class Gmain {

    public static void main(String[] args) throws InterruptedException {
        Config config = new Config();
        config.setSleepTimeForSingleStep(100);

        AI aiA = new SimpleAI(config.getSleepTimeForSingleStep());
        AI aiB = new AreaStraAI(config.getSleepTimeForSingleStep());
        Player playerA = new Player("A", aiA);
        Player playerB = new Player("B", aiB);
        Series.playSeries(playerA, playerB, config);
    }
}
