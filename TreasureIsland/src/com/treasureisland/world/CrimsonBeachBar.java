package com.treasureisland.world;

import com.treasureisland.TreasureIslandGameScanner;

import java.io.IOException;


public class CrimsonBeachBar implements Location{
    private final TreasureIslandGameScanner player = TreasureIslandGameScanner.getInstance();


    @Override
    public String getLocationName() {
        return "Crimson Beach Bar";
    }

    @Override
    public void talkToNPC() throws IOException, InterruptedException {
        player.storylineProgression("CrimsonBeachBarJojo.txt");
        //TODO another clue added 9999 in RumDistillery.java. hash out which clue added.
        player.playerClues.add("999");
    }

    @Override
    public void lookAroundLocation() throws IOException, InterruptedException {
        player.storylineProgression("CrimsonBeachBarBartender.txt");
    }

    @Override
    public void investigateArea() throws IOException, InterruptedException {
        player.storylineProgression("CrimsonBeachBarPalmTrees.txt");

    }

}
