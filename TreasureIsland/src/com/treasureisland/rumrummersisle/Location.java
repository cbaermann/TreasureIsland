package com.treasureisland.rumrummersisle;

import java.io.IOException;

public interface Location {
    public String locationName = null;

    public String getLocationName();
    public void talkToNPC();
    public void lookAroundLocation();
    public void investigateArea();


}
