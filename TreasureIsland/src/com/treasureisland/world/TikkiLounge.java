package com.treasureisland.world;

import java.io.IOException;

public class TikkiLounge implements Location{
    @Override
    public String getLocationName() {
        return "Tikki Lounge";
    }

    @Override
    public void talkToNPC() throws IOException, InterruptedException {
        System.out.println("talking to npc tikki lounge");
    }

    @Override
    public void lookAroundLocation() throws IOException, InterruptedException {
        System.out.println("looking around tikki lounge");
    }

    @Override
    public void investigateArea() throws IOException, InterruptedException {
        System.out.println("investigating tikki lounge");
    }
}
