package com.treasureisland.world;

import com.treasureisland.TreasureIslandGameplay;
import com.treasureisland.player.Player;

import java.io.IOException;
import java.util.Scanner;

public class SaintsLodgeCruces implements Location{
    private final TreasureIslandGameplay game = TreasureIslandGameplay.getInstance();
    private final Player player = Player.getInstance();

    @Override
    public String getLocationName() {
        return "Saints Lodge";
    }

    @Override
    public void talkToNPC() {
        System.out.println("Talking to npc at Saints Lodge");

        game.storylineProgression("TI.txt", getLocationName(), "SLStart", "SLStop");
        player.setPlayerHealth(player.getPlayerHealth() - 30);

    }

    @Override
    public void lookAroundLocation()  {
        System.out.println("Looking around Saints Lodge");
        game.storylineProgression("TI.txt", getLocationName(), "MRStart", "MRStop");
        player.setPlayerHealth(player.getPlayerHealth() - 20);
    }

    @Override
    public void investigateArea()  {
        System.out.println("Investigating Saints Lodge");
        game.storylineProgression("TI.txt", getLocationName(), "PAStart", "PAStop");
        player.setPlayerHealth(player.getPlayerHealth() - 15);
    }

    @Override
    public void vendor() {

    }
}
