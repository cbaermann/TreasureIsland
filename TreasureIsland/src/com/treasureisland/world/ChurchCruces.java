package com.treasureisland.world;

import com.treasureisland.TreasureIslandGameplay;
import com.treasureisland.player.Player;

import java.io.IOException;

public class ChurchCruces implements Location{

    private final TreasureIslandGameplay game = TreasureIslandGameplay.getInstance();
    private final Player player = Player.getInstance();

    @Override
    public String getLocationName() {
        return "Church";
    }

    @Override
    public void talkToNPC() {
        System.out.println("Talking to a npc in church");
        game.storylineProgression("TI.txt", getLocationName(), "FJStart", "FJStop");
        System.out.println(" You found one of the treasures needed to access the Island ");
        player.haveIslandItem = true;



    }

    @Override
    public void lookAroundLocation() {
        System.out.println("looking around church");
        game.storylineProgression("TI.txt", getLocationName(), "CStart", "CStop");

    }

    @Override
    public void investigateArea() {
        System.out.println("Investigating church");
        game.storylineProgression("TI.txt", getLocationName(), "AStart", "AStop");

    }

    @Override
    public void vendor() {

    }
}
