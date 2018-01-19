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

    private final int NUM_OF_DIRECTIONS = 4;
    private final int ONE_MOVE = 1;

    private static final Map<Integer, Integer> COMBO_2_VALUE;
    static {
        COMBO_2_VALUE = new HashMap<Integer, Integer>();
        COMBO_2_VALUE.put(0, 0);
        COMBO_2_VALUE.put(1, 1);
        COMBO_2_VALUE.put(2, 10);
        COMBO_2_VALUE.put(3, 100);
        COMBO_2_VALUE.put(4, 1000);
        COMBO_2_VALUE.put(5, 10000);
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
        int bestScore = COMBO_2_VALUE.get(ONE_MOVE) * NUM_OF_DIRECTIONS;
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
                COMBO_2_VALUE.get(maxP0)+
                COMBO_2_VALUE.get(maxP45)+
                COMBO_2_VALUE.get(maxP90)+
                COMBO_2_VALUE.get(maxP135);

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
