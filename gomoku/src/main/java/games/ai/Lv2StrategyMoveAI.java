package games.ai;

import games.model.Board;
import games.model.Game;
import games.model.Location;
import games.model.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wangdehao on 18/1/19.
 */
public class Lv2StrategyMoveAI extends AI{
    private double aggressiveRate = 0.0;

    private static final Map<Integer, Integer> combo2Value;
    static {
        combo2Value = new HashMap<Integer, Integer>();
        combo2Value.put(0, 0);
        combo2Value.put(1, 1);
        combo2Value.put(2, 10);
        combo2Value.put(3, 100);
        combo2Value.put(4, 1000);
        combo2Value.put(5, 10000);
    }

    public Lv2StrategyMoveAI(int sleepTime, int playId, int aggressiveRate) {
        this.sleepTime = sleepTime;
        this.playId = playId;
        this.aggressiveRate = aggressiveRate;
    }

    @Override
    public Location getLocationBasedOnBoard(Game game, Player movePlayer) throws InterruptedException {
        // TODO: 18/1/19 player? 
//        evaluateGameForPlayer(game, movePlayer);

        // maximize oneself:    generate possible moves, select one that maximizes oneself
        List<Location> possibleMoves = moveGenerator(game.getBoard());
        int center = (game.getBoard().getBoardSize() - 1) / 2;
        System.out.println("center="+center);
        Location bestMove = new Location(center,center);
        int bestScore = 4;
        for(Location possibleMove: possibleMoves){
            // move
            
            game.makeMove(possibleMove, movePlayer);
            
            // evaluation
            int score = evaluateGameForPlayer(game.getBoard(), movePlayer);
//            System.out.println("possibleMove="+possibleMove.toString());
//            System.out.println("score="+score);
            if(score > bestScore){
                bestScore = score;
                bestMove = possibleMove;
            }
            
            // reset
            
            game.resetMove(possibleMove);
        }
        System.out.println("bestMove:"+bestMove.toString());

        // TODO: 18/1/19  
        // minimize opponent:   generate possible moves, select one that minimizes opponent

        return bestMove;
    }


    public int evaluateGameForPlayer(Board board, Player player){
        int maxP0 = board.validateDegree0(player);
        int maxP45 = board.validateDegree45(player);
        int maxP90 = board.validateDegree90(player);
        int maxP135 = board.validateDegree135(player);

        int total =
                combo2Value.get(maxP0)+
                combo2Value.get(maxP45)+
                combo2Value.get(maxP90)+
                combo2Value.get(maxP135);

        return total;
    }

    public List<Location> moveGenerator(Board board){
        List<Location> possibleMoves = new ArrayList<Location>();

        for(int i = 0; i < board.getBoardSize(); i++){
            for(int j = 0; j < board.getBoardSize(); j++){
                if(board.getSpace(i,j).isAvailable()){
                    possibleMoves.add(new Location(i, j));
                }
            }
        }

        return possibleMoves;
    }
}
