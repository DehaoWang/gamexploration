package games.ai;

import games.model.Board;
import games.model.Game;
import games.model.Location;
import games.model.Player;

import java.util.*;

/**
 * Created by wangdehao on 18/1/19.
 */
public class Lv2StrategyMoveAI extends AI{
    private double aggressiveRate = 0.5;
    private int typeOfEvaluator = 2;

    private final int NUM_OF_DIRECTIONS = 4;
    private final int CENTER_THRES = 1;
    private final String ONE_MOVE = "1C";
    private final int SMALL_NUM_FOR_SCORE = -10000000;

    private static final Map<String, Integer> COMBO_2_VALUE;
    static {
        // A: closed
        // B: half-closed, half-open
        // C: open
        COMBO_2_VALUE = new HashMap<String, Integer>();
        COMBO_2_VALUE.put("0A", 0);
        COMBO_2_VALUE.put("0B", 0);
        COMBO_2_VALUE.put("0C", 0);
        COMBO_2_VALUE.put("1A", 0);
        COMBO_2_VALUE.put("1B", 1);
        COMBO_2_VALUE.put("1C", 10);
        COMBO_2_VALUE.put("2A", 0);
        COMBO_2_VALUE.put("2B", 10);
        COMBO_2_VALUE.put("2C", 100);
        COMBO_2_VALUE.put("3A", 0);
        COMBO_2_VALUE.put("3B", 100);
        COMBO_2_VALUE.put("3C", 1000);
        COMBO_2_VALUE.put("4A", 0);
        COMBO_2_VALUE.put("4B", 1000);
        COMBO_2_VALUE.put("4C", 10000);
        COMBO_2_VALUE.put("5A", 100000);
        COMBO_2_VALUE.put("5B", 100000);
        COMBO_2_VALUE.put("5C", 100000);
    }

    public Lv2StrategyMoveAI(int sleepTime, int playId, double aggressiveRate, int typeOfEvaluator) {
        this.sleepTime = sleepTime;
        this.playId = playId;
        this.aggressiveRate = aggressiveRate;
        this.typeOfEvaluator = typeOfEvaluator;
    }

    @Override
    public Location getLocationBasedOnBoard(Game game, Player movePlayer) throws InterruptedException {
        Player selfPlayer = movePlayer;
        Player oppoPlayer = game.getPlayer0();
        if(game.getPlayer0() == movePlayer){
            oppoPlayer = game.getPlayer1();
        }
        System.out.println("selfPlayer: "+selfPlayer.getName());
        System.out.println("oppoPlayer: "+oppoPlayer.getName());

        List<Location> possibleMoves = moveGenerator(game.getBoard());
        Board board = game.getBoard();
        Location bestMove = getInitMove(board);

        double bestScore = COMBO_2_VALUE.get(ONE_MOVE) * NUM_OF_DIRECTIONS;
        System.out.println("possible move count = " + possibleMoves.size());

        for(Location possibleMove: possibleMoves){
            // move
            game.makeMove(possibleMove, movePlayer);
            System.out.println("************************************************** possibleMove="+possibleMove.toString());

            // evaluation
            int selfScore = 0;
            int oppoScore = 0;
            if(typeOfEvaluator == 1){
                selfScore = evaluateGameForPlayer(game.getBoard(), selfPlayer);
                oppoScore = evaluateGameForPlayer(game.getBoard(), oppoPlayer);
            }
            else if(typeOfEvaluator == 2){
                selfScore = evaluateGameForPlayerV2(game.getBoard(), movePlayer);
                oppoScore = evaluateGameForPlayerV2(game.getBoard(), oppoPlayer);
            }

            System.out.println("player="+selfPlayer.getName()+";self score="+selfScore);
            System.out.println("player="+oppoPlayer.getName()+";oppo score="+oppoScore);

            // maximize self: generate possible moves, select one that maximizes self
            // minimize oppo: generate possible moves, select one that minimizes oppo

            double finalScore = aggressiveRate * selfScore - (1-aggressiveRate) * oppoScore;
            System.out.println("final score="+finalScore);

            if(finalScore > bestScore){
                bestScore = finalScore;
                bestMove = possibleMove;
            }

            // reset
            game.resetMove(possibleMove);
        }
        System.out.println("bestMove:"+bestMove.toString());

        // TODO: 18/1/19  

        return bestMove;
    }


    public int evaluateGameForPlayer(Board board, Player player){
        // max
        int maxP0 = board.validateDegree0(player);
        int maxP45 = board.validateDegree45(player);
        int maxP90 = board.validateDegree90(player);
        int maxP135 = board.validateDegree135(player);

        int total =
                COMBO_2_VALUE.get(maxP0+"C")+
                COMBO_2_VALUE.get(maxP45+"C")+
                COMBO_2_VALUE.get(maxP90+"C")+
                COMBO_2_VALUE.get(maxP135+"C");

        return total;
    }

    public int evaluateGameForPlayerV2(Board board, Player player){
        // max
        Map<String, Integer> mapA0 = board.validateDegree0v2(player);
        Map<String, Integer> mapA45 = board.validateDegree45v2(player);
        Map<String, Integer> mapA90 = board.validateDegree90v2(player);
        Map<String, Integer> mapA135 = board.validateDegree135v2(player);

        System.out.println("player="+player.getName()+"; a0="+mapA0);
        System.out.println("player="+player.getName()+"; a45="+mapA45);
        System.out.println("player="+player.getName()+"; a90="+mapA90);
        System.out.println("player="+player.getName()+"; a135="+mapA135);

        int total =
                calScoreByMap(mapA0)
                +calScoreByMap(mapA45)
                +calScoreByMap(mapA90)
                +calScoreByMap(mapA135);

        return total;
    }

    public int calScoreByMap(Map<String, Integer> map){
        int total = 0;
        for(String key: map.keySet()){
            int val = map.get(key);
//            System.out.println(key);
            total += val * COMBO_2_VALUE.get(key);
        }
        return total;
    }

    public List<Location> moveGenerator(Board board){
        List<Location> possibleMoves = new ArrayList<>();

        for(int i = 0; i < board.getBoardSize(); i++){
            for(int j = 0; j < board.getBoardSize(); j++){
                if(board.getSpace(i,j).isAvailable()){
                    possibleMoves.add(new Location(i, j));
                }
            }
        }
        return possibleMoves;
    }

    private Location getInitMove(Board board){
        int center = (board.getBoardSize() - 1) / 2;
        // init bestMove in center 3*3
        Location bestMove;
        if(board.getSpace(center, center).isAvailable()){
            bestMove = new Location(center,center);
        }
        else {
            Random random = new Random();
            int x = center - CENTER_THRES + Math.abs(random.nextInt()) % (1 + 2*CENTER_THRES);
            int y = center - CENTER_THRES + Math.abs(random.nextInt()) % (1 + 2*CENTER_THRES);
            bestMove = new Location(x, y);
        }
        return bestMove;
    }
}
