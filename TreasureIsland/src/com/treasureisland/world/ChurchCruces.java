package com.treasureisland.world;

import java.io.IOException;

public class ChurchCruces implements Location{
    @Override
    public String getLocationName() {
        return "Church";
    }

    @Override
    public void talkToNPC() throws IOException, InterruptedException {
        System.out.println("talking to npc in church");

    }

    @Override
    public void lookAroundLocation() throws IOException, InterruptedException {
        System.out.println("looking around church");
    }

    @Override
    public void investigateArea() throws IOException, InterruptedException {
        System.out.println("Investigating church");
    }
}
