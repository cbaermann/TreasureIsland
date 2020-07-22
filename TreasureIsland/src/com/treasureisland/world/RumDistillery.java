package com.treasureisland.world;
import com.treasureisland.TreasureIslandGameplay;
import com.treasureisland.player.Player;


import java.util.Scanner;


public class RumDistillery implements Location{
    private final TreasureIslandGameplay game = TreasureIslandGameplay.getInstance();
    private final Player player = Player.getInstance();
    Scanner scanner = new Scanner(System.in);
    String input;


    @Override
    public String getLocationName() {
        return "Rum Distillery";
    }

    @Override
    public void talkToNPC(){
        System.out.println("You're talking to a npc in rum distillery");
        game.storylineProgression("TI.txt", getLocationName(), "RDStart", "RDEnd");
        player.playerClues.add("For the last occurrence, look under drum that gives men courage." + "\n"
        + "Speak the pirates favorite letter, your reward shall be even better");
    }

    @Override
    public void lookAroundLocation(){
        System.out.println("making vodka, weird");
        System.out.println("Hello " + player.getPlayerName());
        game.storylineProgression("TI.txt", getLocationName(), "UCStart", "UCEnd");
        player.coinManager(20);

    }

    @Override
    public void investigateArea() {
        System.out.println("-- I am sure i will find something interesting here " +
                "\n-- " + player.getPlayerName() + " looked under the cask and found ....");
        System.out.println("Speak the answer");
        input = scanner.nextLine();
        if(input.equalsIgnoreCase("sea")){
            System.out.println("\n--- Numbers start to appear and........I see 9999 etched on the bottom.");
            player.playerClues.add("9999");
        }
        else{
            System.out.println("Nothing of interest here");
        }


    }


}
