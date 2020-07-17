package com.treasureisland.rumrummersisle;
import com.treasureisland.TreasureIslandGameScanner;



public class RumDistillery implements Location{
    private TreasureIslandGameScanner player = TreasureIslandGameScanner.getInstance();


    @Override
    public String getLocationName() {
        return "Rum Distillery";
    }

    @Override
    public void talkToNPC() {
        System.out.println("You're talking to npc in rum distillery");
    }

    @Override
    public void lookAroundLocation() {
        System.out.println("making vodka, weird");
        System.out.println(player.getName());
    }

    @Override
    public void investigateArea() {
        System.out.println("look, there is something here");
    }


}
