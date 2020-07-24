package com.treasureisland.world;
import com.treasureisland.TreasureIslandGameplay;

import com.treasureisland.player.Player;


public class RoyalLodge implements Location{
    private final TreasureIslandGameplay game = TreasureIslandGameplay.getInstance();
    private Player player = Player.getInstance();

    @Override
    public String getLocationName() {
        return "Royal Lodge";
    }

    @Override
    public void talkToNPC() {
        System.out.println("Talking to a npc Royal lodge, I found out about room 101");
        game.storylineProgression("TI.txt", getLocationName(), "R1Start", "R1Stop");

    }

    @Override
    public void lookAroundLocation(){
        System.out.println("Looking around royal lodge");
        game.storylineProgression("TI.txt", getLocationName(), "SRStart", "SRStop");

    }

    @Override
    public void investigateArea(){
        System.out.println("Investigating royal lodge");
        game.storylineProgression("TI.txt", getLocationName(), "BRStart", "BRStop");

    }

    @Override
    public void vendor() {

    }
}
