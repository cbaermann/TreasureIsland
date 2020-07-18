package com.treasureisland.rumrummersisle;

import com.treasureisland.TreasureIslandGameScanner;

import java.io.IOException;

    public interface Location {
    String locationName = null;

    String getLocationName();
    void talkToNPC() throws IOException, InterruptedException;
    void lookAroundLocation() throws IOException, InterruptedException;
    void investigateArea() throws IOException, InterruptedException;


}
