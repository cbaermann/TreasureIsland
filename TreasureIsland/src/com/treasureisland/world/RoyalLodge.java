package com.treasureisland.world;



public class RoyalLodge implements Location{
    @Override
    public String getLocationName() {
        return "Royal Lodge";
    }

    @Override
    public void talkToNPC() {
        System.out.println("talking to npc royal lodge");
    }

    @Override
    public void lookAroundLocation(){
        System.out.println("looking around royal lodge");
    }

    @Override
    public void investigateArea(){
        System.out.println("investigating royal lodge");
    }
}
