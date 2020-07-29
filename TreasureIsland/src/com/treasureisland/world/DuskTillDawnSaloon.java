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
        System.out.println("You're talking to a npc at Dusk Till Dawn Saloon.");
        game.storylineProgression("TI.txt", getLocationName(), "FIStart", "FIStop");

    }

    @Override
    public void lookAroundLocation(){
        game.storylineProgression("TI.txt", getLocationName(), "WCStart", "WCStop");

    }

    @Override
    public void investigateArea() {
        System.out.println(" Searching the saloon, I found out that John has a key I may need.");
        game.storylineProgression("TI.txt", getLocationName(), "KJStart", "KJStop");
        player.setPlayerHealth(player.getPlayerHealth() - 20);
        System.out.println(" But you also got the key needed for the Treasure Island");
        player.haveIslandItem = true;


    }

    @Override
    public void vendor() {

    }
}
