package com.treasureisland.player;

import com.treasureisland.IsleFactory;
import com.treasureisland.world.Location;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Player {
    private String playerName;
    public ArrayList<String> playerClues = new ArrayList<>();
    public Location location;
    public boolean haveIslandItem = false;
    Scanner scanner = new Scanner(System.in);


    private static final Player player = new Player();
    private Player(){

    }


    public static Player getInstance(){
        return player;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }


    //Helper methods below

    public void processMovement(String islandDestination){
        try {
            while (!player.haveIslandItem) {
                System.out.println("Where would you like to go. N/S/E/W");
                String input = scanner.nextLine();
                player.location = IsleFactory.islandLocationFactory(input, islandDestination);
                System.out.println("You are now at the " + player.location.getLocationName());
                playerInteractionOptions();
            }
        }
        catch (IOException | InterruptedException e){
            e.printStackTrace();
        }
    }

    public void iterateThroughPlayerClues(){
        if(playerClues.size() == 0){
            System.out.println("You have found no clues");
        }
        for(String clue : playerClues){
            System.out.println(clue);
        }
    }
    //TODO great example for input.isValid implementation. current !input.equals(z) logically makes no sense.
    public void playerInteractionOptions() throws IOException, InterruptedException {
        String input = "";
        while(!input.equalsIgnoreCase("e")) {
            System.out.println("What actions would you like to make? Talk(t)/ Look(l)/ Investigate(i)/ Clues(c)/ Exit(e)");
            input = scanner.nextLine();
            switch (input.toLowerCase()) {
                case "talk":
                case "t":
                    location.talkToNPC();
                    break;
                case "look":
                case "l":
                    location.lookAroundLocation();
                    break;
                case "investigate":
                case "i":
                    location.investigateArea();
                    break;
                case "clues":
                case "c":
                    iterateThroughPlayerClues();
                    break;
                case "exit":
                case "e":
                    break;
                default:
                    System.out.println("Invalid input, please try again.");
                    playerInteractionOptions();
                    break;
            }
        }
    }



}
