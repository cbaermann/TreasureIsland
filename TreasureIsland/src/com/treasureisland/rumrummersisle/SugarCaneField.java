package com.treasureisland.rumrummersisle;

public class SugarCaneField implements Location{
    private String locationName = "Sugar cane field";
    @Override
    public String getLocationName() {
        return locationName;
    }

    @Override
    public void talkToNPC() {
        System.out.println("you're talking to npc in the sugar cane field");
    }

    @Override
    public void lookAroundLocation() {
        System.out.println("I see disturbed earth");
    }

    @Override
    public void investigateArea() {
        System.out.println("there is a locked box hidden under the dirt");
    }


}
