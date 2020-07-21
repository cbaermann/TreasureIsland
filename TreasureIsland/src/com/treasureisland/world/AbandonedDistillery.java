package com.treasureisland.world;

import com.treasureisland.TreasureIslandGameScanner;



public class AbandonedDistillery implements Location{
    private final TreasureIslandGameScanner player = TreasureIslandGameScanner.getInstance();


    @Override
    public String getLocationName() {
        return "Abandoned distillery";
    }

    @Override
    public void talkToNPC(){
//        System.out.println("youre talking to npc in the abandoned distillery");
        player.storylineProgression("AbandonedDistilleryGhost.txt");
    }

    @Override
    public void lookAroundLocation(){
        player.storylineProgression("AbandonedDistilleryStills.txt");
    }

    @Override
    public void investigateArea(){
//        System.out.println("looking under cask");
        player.storylineProgression("AbandonedDistilleryRumCrate.txt");
    }

}
