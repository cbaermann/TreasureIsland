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

    //Rum Distillary
    //Master Brewers House
    //Cask Room
    //Docks
    private String locationName = "Rum Distillary";


    public void rumDistillary(){
        System.out.println("hello from rum distillary in .world");
    }



}
