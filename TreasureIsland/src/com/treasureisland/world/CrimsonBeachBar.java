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
        game.storylineProgression("CrimsonBeachBarJojo.txt");
        //TODO another clue added 9999 in RumDistillery.java. hash out which clue added.
        player.playerClues.add("999");
    }

    @Override
    public void lookAroundLocation(){
        game.storylineProgression("CrimsonBeachBarBartender.txt");
    }

    @Override
    public void investigateArea(){
        game.storylineProgression("CrimsonBeachBarPalmTrees.txt");

    }

}
