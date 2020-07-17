package com.treasureisland.rumrummersisle;

public class RumDistillary implements Location{
    @Override
    public String getLocationName() {
        return locationName;
    }

    @Override
    public void talkToNPC() {
        System.out.println("youre talking to npc in rum distillary");
    }

    @Override
    public void lookAroundLocation() {
        System.out.println("making vodka, weird");
    }

    @Override
    public void investigateArea() {
        System.out.println("look, there is something here");
    }

    //Rum Distillary
    //Master Brewers House
    //Cask Room
    //Docks
    private String locationName = "Rum Distillary";


    public void rumDistillary(){
        System.out.println("hello from rum distillary in .world");
    }



}
