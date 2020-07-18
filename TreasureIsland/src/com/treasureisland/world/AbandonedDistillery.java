package com.treasureisland.world;

public class AbandonedDistillery implements Location{

    @Override
    public String getLocationName() {
        return "Abandoned distillery";
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
