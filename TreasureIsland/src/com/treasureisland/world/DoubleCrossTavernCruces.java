package com.treasureisland.world;

import java.io.IOException;

public class DoubleCrossTavernCruces implements Location {
    @Override
    public String getLocationName() {
        return "Double Cross Tavern";
    }

    @Override
    public void talkToNPC() throws IOException, InterruptedException {
        System.out.println("talking to npc in dct");
    }

    @Override
    public void lookAroundLocation() throws IOException, InterruptedException {
        System.out.println("looking around dct");
    }

    @Override
    public void investigateArea() throws IOException, InterruptedException {
        System.out.println("investigating dct");
    }
}
