package com.treasureisland.world;

import com.treasureisland.TreasureIslandGameplay;
import com.treasureisland.player.Player;

public class DoubleCrossTavernCruces implements Location {
    private final TreasureIslandGameplay game = TreasureIslandGameplay.getInstance();
    private final Player player = Player.getInstance();

    @Override
    public String getLocationName() {
        return "Double Cross Tavern";
    }

    @Override
    public void talkToNPC()  {
        System.out.println("Talking to a npc at Double Cross Tavern");
        game.storylineProgression("TI.txt", getLocationName(), "TCStart", "TCStop");

    }

    @Override
    public void lookAroundLocation()  {
        game.storylineProgression("TI.txt", getLocationName(), "BAStart", "BAStop");

    }

    @Override
    public void investigateArea() {
        game.storylineProgression("TI.txt", getLocationName(), "DStart", "DStop");
        player.playerCoinGenerator();

    }

    @Override
    public void vendor() {

    }
}
