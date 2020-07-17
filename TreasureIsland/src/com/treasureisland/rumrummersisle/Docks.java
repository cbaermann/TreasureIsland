package com.treasureisland.rumrummersisle;

public class Docks implements Location{
    private String locationName = "Docks";

    @Override
    public String getLocationName() {
        return locationName;
    }

    @Override
    public void talkToNPC() {
        System.out.println("youre talking to npc in docks");
    }

}
