package com.treasureisland.rumrummersisle;

public class CaskRoom implements Location{
    private String locationName = "Cask Room";

    @Override
    public String getLocationName() {
        return locationName;
    }

    @Override
    public void talkToNPC() {
        System.out.println("youre talking to npc in cask room");
    }

}
