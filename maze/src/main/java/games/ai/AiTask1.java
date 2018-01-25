package games.ai;

import games.model.Direction;
import games.model.Location;

/**
 * Created by wangdehao on 18/1/25.
 */
public interface AiTask1 {
    public Location submitLocationOnExplorations(int numOfExp, int maxStepsForEachExp);

    Direction submitPotentialMove() throws InterruptedException;
}
