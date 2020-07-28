package com.treasureisland.world;

import com.treasureisland.TreasureIslandGameplay;
import com.treasureisland.player.Player;

import java.util.Scanner;

public class SouthendBeachCruces implements Location{
    private final TreasureIslandGameplay game = TreasureIslandGameplay.getInstance();
    private final Player player = Player.getInstance();


    @Override
    public String getLocationName() {
        return "Southend Beach";
    }

    @Override
    public void talkToNPC() {
        System.out.println("Talking to a npc Southend Beach");
        System.out.println("To unlock the lockpin you need to surrender the stolen item");
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        if(input.equalsIgnoreCase("goblet")) {
            System.out.println("DING DING DING \n You have unlocked your third treasure piece.");
            player.haveIslandItem = true;
            game.storylineProgression("TI.txt", getLocationName(), "FStart", "FStop");
        }


    }

    @Override
    public void lookAroundLocation()  {
        System.out.println("Looking around Southend Beach");
        game.storylineProgression("TI.txt", getLocationName(), "SHStart", "SHStop");

    }

    @Override
    public void investigateArea() {
        System.out.println("Investigating Southend beach");
        game.storylineProgression("TI.txt", getLocationName(), "GHStart", "GHStop");

    }

    @Override
    public void vendor() {

    }
}
