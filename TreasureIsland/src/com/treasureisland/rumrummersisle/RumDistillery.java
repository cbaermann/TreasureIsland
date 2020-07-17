package com.treasureisland.rumrummersisle;
import com.treasureisland.TreasureIslandGameScanner;

import java.io.IOException;


public class RumDistillery implements Location{
    private TreasureIslandGameScanner player = TreasureIslandGameScanner.getInstance();


    @Override
    public String getLocationName() {
        return "Rum Distillery";
    }

    @Override
    public void talkToNPC() throws IOException, InterruptedException {
        System.out.println("You're talking to npc in rum distillery");
        player.storylineProgression("MasterBrewer.txt");
        player.playerClues.add("For the last occurance, look under drum that gives men courage");
    }

    @Override
    public void lookAroundLocation() throws IOException, InterruptedException {
        System.out.println("making vodka, weird");
        System.out.println("Hello " + player.getName());
    }

    @Override
    public void investigateArea() {
        System.out.println("look, there is something here");

    }


}
