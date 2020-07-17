package com.treasureisland.rumrummersisle;

public class RumDistillary implements Location{
    private String locationName = "Rum Distillery";

    @Override
    public String getLocationName() {
        return locationName;
    }

    @Override
    public void talkToNPC() {
        System.out.println("You're talking to npc in rum distillery");
    }

    @Override
    public void lookAroundLocation() {
        System.out.println("making vodka, weird");
    }

    @Override
    public void investigateArea() {
        System.out.println("look, there is something here");
    }




}
