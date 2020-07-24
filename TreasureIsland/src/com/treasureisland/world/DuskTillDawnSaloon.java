package com.treasureisland.world;

import com.treasureisland.TreasureIslandGameplay;
import com.treasureisland.player.Player;

import java.io.IOException;


public class DuskTillDawnSaloon implements Location {
    private final TreasureIslandGameplay game = TreasureIslandGameplay.getInstance();
    private final Player player = Player.getInstance();

    @Override
    public String getLocationName() {
        return "Dusk Till Dawn Saloon ";
    }

    @Override
    public void talkToNPC(){

    }

    @Override
    public void lookAroundLocation(){

    }

    @Override
    public void investigateArea() {

    }

    @Override
    public void vendor() {

    }
}
