package com.treasureisland.player;

import java.util.ArrayList;

public class Player {
    String playerName;
    public ArrayList<String> playerClues = new ArrayList<>();
    public boolean haveIslandItem = false;


    private static final Player player = new Player();
    private Player(){

    }

    public static Player getInstance(){
        return player;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public void iterateThroughPlayerClues(){
        if(playerClues.size() == 0){
            System.out.println("You have found no clues");
        }
        for(String clue : playerClues){
            System.out.println(clue);
        }
    }



}
