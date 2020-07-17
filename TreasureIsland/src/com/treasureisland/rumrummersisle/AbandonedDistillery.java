package com.treasureisland.rumrummersisle;

public class AbandonedDistillery implements Location{
    private String locationName = "Abandoned distillery";

    @Override
    public String getLocationName() {
        return locationName;
    }

    @Override
    public void talkToNPC() {
        System.out.println("youre talking to npc in the abandoned distillery");
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
