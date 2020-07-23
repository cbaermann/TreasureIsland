package com.treasureisland.world;

import com.treasureisland.TreasureIslandGameplay;

import com.treasureisland.player.Player;


public class CrimsonBeachBar implements Location{

    private final TreasureIslandGameplay game = TreasureIslandGameplay.getInstance();
    private Player player = Player.getInstance();

    @Override
    public String getLocationName() {
        return "Crimson Beach Bar";
    }

    @Override
    public void talkToNPC(){
        game.storylineProgression("TI.txt", getLocationName(), "JStart", "JEnd");
        //TODO another clue added 9999 in RumDistillery.java. hash out which clue added.
        player.playerClues.add("999");
    }

    @Override
    public void lookAroundLocation(){
        game.storylineProgression("TI.txt", getLocationName(), "CStart", "CEnd");
    }

    @Override
    public void investigateArea(){
        game.storylineProgression("TI.txt", getLocationName(), "PTStart", "PTEnd");

    }

}
