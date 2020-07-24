package com.treasureisland.world;

import java.io.IOException;

public class SouthendBeachCruces implements Location{
    @Override
    public String getLocationName() {
        return "Southend Beach";
    }

    @Override
    public void talkToNPC() throws IOException, InterruptedException {
        System.out.println("talking to npc southend beach");
    }

    @Override
    public void lookAroundLocation() throws IOException, InterruptedException {
        System.out.println("looking around southend beach");
    }

    @Override
    public void investigateArea() throws IOException, InterruptedException {
        System.out.println("investigating southend beach");
    }

    @Override
    public void vendor() {

    }
}
