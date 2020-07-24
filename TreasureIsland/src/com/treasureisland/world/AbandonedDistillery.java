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
        treasureIslandGameplay.storylineProgression("TI.txt", getLocationName(), "BGStart", "BGEnd");
    }

    @Override
    public void lookAroundLocation(){
        treasureIslandGameplay.storylineProgression("TI.txt", getLocationName(), "DSStart", "DSEnd");
    }

    @Override
    public void investigateArea(){
        treasureIslandGameplay.storylineProgression("TI.txt", getLocationName(), "DRStart", "DREnd");
    }

    @Override
    public void vendor() {

    }

}
