package com.treasureisland.world;

import com.treasureisland.TreasureIslandGameScanner;

import java.io.IOException;

public class AbandonedDistillery implements Location{
    private final TreasureIslandGameScanner player = TreasureIslandGameScanner.getInstance();


    @Override
    public String getLocationName() {
        return "Abandoned distillery";
    }

    @Override
    public void talkToNPC() throws IOException, InterruptedException {
//        System.out.println("youre talking to npc in the abandoned distillery");
        player.storylineProgression("AbandonedDistilleryGhost.txt");
    }

    @Override
    public void lookAroundLocation() throws IOException, InterruptedException {
        player.storylineProgression("AbandonedDistilleryStills.txt");
    }

    @Override
    public void investigateArea() throws IOException, InterruptedException {
//        System.out.println("looking under cask");
        player.storylineProgression("AbandonedDistilleryRumCrate.txt");
    }

}
