package com.treasureisland.world;

import com.treasureisland.TreasureIslandGameplay;
import com.treasureisland.player.Player;

public class SunsetRestaurant implements Location{
    @Override
    public String getLocationName() {
        return "Sunset Restaurant";
    }
    private final TreasureIslandGameplay game = TreasureIslandGameplay.getInstance();
    private Player player = Player.getInstance();

    @Override
    public void talkToNPC() {
        System.out.println("Talking to a npc sunset restaurant");
        game.storylineProgression("TI.txt", getLocationName(), "RNDStart", "RNDStop");

    }

    @Override
    public void lookAroundLocation(){
        System.out.println("Looking around sunset restaurant");
        game.storylineProgression("TI.txt", getLocationName(), "PSStart", "PSStop");

    }

    @Override
    public void investigateArea() {
        System.out.println("Investigating sunset restaurant");
        game.storylineProgression("TI.txt", getLocationName(), "SLStart", "SLStop");

    }

    @Override
    public void vendor() {

    }
}
