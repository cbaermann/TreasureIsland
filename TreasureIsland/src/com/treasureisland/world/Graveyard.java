package com.treasureisland.world;

import com.treasureisland.TreasureIslandGameplay;
import com.treasureisland.player.Player;

import java.io.IOException;

public class Graveyard implements Location {
    private final TreasureIslandGameplay game = TreasureIslandGameplay.getInstance();
    private final Player player = Player.getInstance();

    @Override
    public String getLocationName() {
        return "Graveyard";
    }

    @Override
    public void talkToNPC()  {
        System.out.println("After some persuasion my acquaintance took me to the graveyard.");
        game.storylineProgression("TI.txt", getLocationName(), "CQStart", "CQStop");
        player.setPlayerHealth(player.getPlayerHealth() - 5);

    }

    @Override
    public void lookAroundLocation()  {
        game.storylineProgression("TI.txt", getLocationName(),"STStart", "STStop");

    }

    @Override
    public void investigateArea()  {
        game.storylineProgression("TI.txt", getLocationName(), "BTStart", "BTStop");
        player.playerCoinGenerator();

    }
}
