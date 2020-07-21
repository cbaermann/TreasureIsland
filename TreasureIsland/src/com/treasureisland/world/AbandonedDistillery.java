package com.treasureisland.world;

import com.treasureisland.TreasureIslandGameplay;



public class AbandonedDistillery implements Location{
    private final TreasureIslandGameplay player = TreasureIslandGameplay.getInstance();


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
