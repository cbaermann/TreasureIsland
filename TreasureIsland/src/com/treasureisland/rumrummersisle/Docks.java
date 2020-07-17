package com.treasureisland.rumrummersisle;

import com.treasureisland.TreasureIslandGameScanner;


public class Docks implements Location{
    TreasureIslandGameScanner treasureIslandGameScanner;
    private String locationName = "Docks";

    @Override
    public String getLocationName() {
        return locationName;
    }

    @Override
    public void talkToNPC() {
        System.out.println("youre talking to npc in docks");
    }

    @Override
    public void lookAroundLocation() {
        System.out.println("I see a boat, who would think i'd see that here");
    }

    @Override
    public void investigateArea(){
        System.out.println("being nosey in the Docks");
//        treasureIslandGameScanner.haveAmazingItem = true;

    }

}
