package com.treasureisland.world;

import com.treasureisland.TreasureIslandGameplay;
import com.treasureisland.player.Player;

import java.io.IOException;

public class PawPawBeach implements Location{
    private final TreasureIslandGameplay game = TreasureIslandGameplay.getInstance();
    private final Player player = Player.getInstance();

    @Override
    public String getLocationName() {
        return "Pawpaw Beach ";
    }

    @Override
    public void talkToNPC() {
        System.out.println("A guy called Slimjaw has some interesting information but he was more interested in having a hot-dog eating competition");
        game.storylineProgression("TI.txt", getLocationName(), "SJStart", "SJStop");

    }

    @Override
    public void lookAroundLocation() {
        game.storylineProgression("TI.txt", getLocationName(), "PMStart", "PMStop");


    }

    @Override
    public void investigateArea() {
        game.storylineProgression("TI.txt", getLocationName(), "CGStart", "CGStop");


    }

    @Override
    public void vendor() {

    }
}
