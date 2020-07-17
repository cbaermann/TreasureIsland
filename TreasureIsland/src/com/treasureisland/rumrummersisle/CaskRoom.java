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

    @Override
    public void lookAroundLocation() {
        System.out.println("there is no rum here");
    }

    @Override
    public void investigateArea() {
        System.out.println("looking under cask");
    }

}
