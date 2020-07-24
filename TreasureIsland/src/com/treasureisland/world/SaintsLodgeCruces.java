package com.treasureisland.world;

import java.io.IOException;

public class SaintsLodgeCruces implements Location{
    @Override
    public String getLocationName() {
        return "Saints Lodge";
    }

    @Override
    public void talkToNPC() throws IOException, InterruptedException {
        System.out.println("talking to npc in saints lodge");
    }

    @Override
    public void lookAroundLocation() throws IOException, InterruptedException {
        System.out.println("looking around saints lodge");
    }

    @Override
    public void investigateArea() throws IOException, InterruptedException {
        System.out.println("investigating saints lodge");
    }

    @Override
    public void vendor() {

    }
}
