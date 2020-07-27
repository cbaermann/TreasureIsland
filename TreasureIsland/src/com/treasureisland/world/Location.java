package com.treasureisland.world;

import com.treasureisland.island.DirectionEnum;

import java.io.IOException;

    public interface Location {
    String locationName = null;
    DirectionEnum direction = null;

    String getLocationName();
    void talkToNPC() throws IOException, InterruptedException;
    void lookAroundLocation() throws IOException, InterruptedException;
    void investigateArea() throws IOException, InterruptedException;
    void vendor();
//    void dig();


}
