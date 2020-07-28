package com.treasureisland.world;
import com.treasureisland.TreasureIslandGameplay;
import com.treasureisland.player.Color;
import com.treasureisland.player.Player;
import java.io.IOException;
import java.util.Scanner;

public class TikkiLounge implements Location{

    private final TreasureIslandGameplay game = TreasureIslandGameplay.getInstance();
    private final Player player = Player.getInstance();

    @Override
    public String getLocationName() {
        return "Tikki Lounge";
    }

    @Override
    public void talkToNPC() {
        System.out.println("Talking to a npc Tikki lounge");
        System.out.println("I wont talk without the code");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        if(input.equalsIgnoreCase("High Tide")) {
            System.out.println(Color.ANSI_BOLD.getValue()+"DING DING DING"+Color.ANSI_RESET.getValue()+
                            "\n You have unlocked your second treasure piece.");
            player.haveIslandItem = true;
//        game.storylineProgression("TI.txt", getLocationName(), "SOStart", "SOStop");
        }
        else {
            System.out.println("To get the code, you must do side quest talk to npc in \"Ship Graveyard\"");
        }
    }

    @Override
    public void lookAroundLocation() {
        System.out.println("Looking around Tikki lounge, I ran into Callie ");
        game.storylineProgression("TI.txt", getLocationName(), "CAStart", "CAStop");

    }

    @Override
    public void investigateArea()  {
        System.out.println("Investigating Tikki lounge, I ran into Sam.");
        game.storylineProgression("TI.txt", getLocationName(), "SAMStart", "SAMStop");
        System.out.println("You got one of the keys needed for the Treasure Island");
        player.playerCoinGenerator();
        player.haveIslandItem = true;


    }

    @Override
    public void vendor() {
        player.playerVisitsVendor();
    }
}
