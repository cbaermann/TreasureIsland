package com.treasureisland.world;

import java.io.IOException;

public class SunsetRestaurant implements Location{
    @Override
    public String getLocationName() {
        return "Sunset Restaurant";
    }

    @Override
    public void talkToNPC() throws IOException, InterruptedException {
        System.out.println("talking to npc sunset restaurant");
    }

    @Override
    public void lookAroundLocation() throws IOException, InterruptedException {
        System.out.println("looking around sunset restaurant");
    }

    @Override
    public void investigateArea() throws IOException, InterruptedException {
        System.out.println("investigating sunset restaurant");
    }
}
