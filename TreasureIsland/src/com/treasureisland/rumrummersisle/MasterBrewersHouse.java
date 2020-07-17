package com.treasureisland.rumrummersisle;

public class MasterBrewersHouse implements Location{
    private String locationName = "Master Brewers House";
    @Override
    public String getLocationName() {
        return locationName;
    }

    @Override
    public void talkToNPC() {
        System.out.println("you're talking to npc in master brewers house");
    }


}
