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

    @Override
    public void lookAroundLocation() {
        System.out.println("I see a strange crack in the wall");
    }

    @Override
    public void investigateArea() {
        System.out.println("there is a locked box on the porch");
    }


}
