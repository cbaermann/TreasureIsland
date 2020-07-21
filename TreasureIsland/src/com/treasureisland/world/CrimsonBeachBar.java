package com.treasureisland.world;

import com.treasureisland.TreasureIslandGameplay;



public class CrimsonBeachBar implements Location{

    private final TreasureIslandGameplay player = TreasureIslandGameplay.getInstance();


    @Override
    public String getLocationName() {
        return "Crimson Beach Bar";
    }

    @Override
    public void talkToNPC(){
        player.storylineProgression("CrimsonBeachBarJojo.txt");
        //TODO another clue added 9999 in RumDistillery.java. hash out which clue added.
        player.playerClues.add("999");
    }

    @Override
    public void lookAroundLocation(){
        player.storylineProgression("CrimsonBeachBarBartender.txt");
    }

    @Override
    public void investigateArea(){
        player.storylineProgression("CrimsonBeachBarPalmTrees.txt");

    }

}
