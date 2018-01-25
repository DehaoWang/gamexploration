package games.model;

import games.ai.AiTask1;
import games.ai.Task1Ai;

/**
 * Created by wangdehao on 18/1/25.
 */
public class Game {
    private Player player;
    private Maze maze;
    private int movesRemaining;

    public Game(Maze maze, Player player, int initX, int initY, int movesRemaining) {
        this.maze = maze;
        this.player = player;
        player.initLocation(new Location(initX, initY));
        this.movesRemaining = movesRemaining;
    }

    public void decreaseMR(){
        movesRemaining--;
    }

    public void printState(){
        for(int i = -1; i < maze.getMazeSizeM(); i++){
            System.out.print(String.format("%-3d", i));
        }
        System.out.println();
        for(int i = 0; i < maze.getMazeSizeM(); i++){
            System.out.print(String.format("%-3d", i));
            for(int j = 0; j < maze.getMazeSizeN(); j++){
                if(i == player.getCurrLocation().getX() && j == player.getCurrLocation().getY()){
                    System.out.print(String.format("%-3s", player.getInitial()));
                }
                else {
                    System.out.print(String.format("%-3s", maze.getSpace(i, j).getFiller()));
                }
            }
            System.out.println();
        }
        System.out.println("remaining moves: "+movesRemaining);
    }

    public boolean isOnGoing() {
        if(movesRemaining > 0){
            return true;
        }
        return false;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Maze getMaze() {
        return maze;
    }

    public void setMaze(Maze maze) {
        this.maze = maze;
    }

}
