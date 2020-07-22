package com.treasureisland.world;

import java.io.IOException;

public class ShipGraveyard implements Location{
    @Override
    public String getLocationName() {
        return "Ship Graveyard";
    }

    @Override
    public void talkToNPC(){
        System.out.println("talking to npc ship graveyard");
    }

    @Override
    public void lookAroundLocation(){
        System.out.println("looking around ship graveyard");
    }

    @Override
    public void investigateArea(){
        System.out.println("investigating ship graveyard");
    }
}
