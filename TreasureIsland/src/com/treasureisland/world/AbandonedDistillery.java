package com.treasureisland.world;

import com.treasureisland.TreasureIslandGameplay;



public class AbandonedDistillery implements Location{
    private final TreasureIslandGameplay treasureIslandGameplay = TreasureIslandGameplay.getInstance();



    @Override
    public String getLocationName() {
        return "Abandoned distillery";
    }

    @Override
    public void talkToNPC(){
        treasureIslandGameplay.storylineProgression("AbandonedDistilleryGhost.txt");
    }

    @Override
    public void lookAroundLocation(){
        treasureIslandGameplay.storylineProgression("AbandonedDistilleryStills.txt");
    }

    @Override
    public void investigateArea(){
        treasureIslandGameplay.storylineProgression("AbandonedDistilleryRumCrate.txt");
    }

}
