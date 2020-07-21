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
        player.storylineProgression("AbandonedDistilleryGhost.txt");
    }

    @Override
    public void lookAroundLocation(){
        player.storylineProgression("AbandonedDistilleryStills.txt");
    }

    @Override
    public void investigateArea(){
        player.storylineProgression("AbandonedDistilleryRumCrate.txt");
    }

}
