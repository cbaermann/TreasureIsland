package com.treasureisland.world;
import com.treasureisland.TreasureIslandGameScanner;

import java.io.IOException;


public class RumDistillery implements Location{
    private final TreasureIslandGameScanner player = TreasureIslandGameScanner.getInstance();


    @Override
    public String getLocationName() {
        return "Rum Distillery";
    }

    @Override
    public void talkToNPC() throws IOException, InterruptedException {
        System.out.println("You're talking to npc in rum distillery");
        player.storylineProgression("MasterBrewer.txt");
        player.playerClues.add("For the last occurrence, look under drum that gives men courage");
    }

    @Override
    public void lookAroundLocation() throws IOException, InterruptedException {
        System.out.println("making vodka, weird");
        System.out.println("Hello " + player.getPlayerName());
        player.storylineProgression("RumDistilleryOpenCask.txt");
    }

    @Override
    public void investigateArea() {
        System.out.println("-- I am sure i will find something interesting here " +
                "\n-- " + player.getPlayerName() + " looked under the cask and found ...."
                + "\n-- 9999 etched on the bottom.....nothing of interest");
        player.playerClues.add("9999");


    }


}
