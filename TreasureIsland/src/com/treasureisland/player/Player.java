package com.treasureisland.player;

import com.treasureisland.IsleFactory;
import com.treasureisland.TreasureIslandGameplay;
import com.treasureisland.world.Location;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Player {
    private String playerName;
    private int playerCoins;
    public ArrayList<String> playerClues = new ArrayList<>();
    public Location location;
    public boolean haveIslandItem = false;
    Scanner scanner = new Scanner(System.in);


    private static final Player player = new Player();
    private final TreasureIslandGameplay treasureIslandGameplay = TreasureIslandGameplay.getInstance();

    private Player() {

    }


    public static Player getInstance() {
        return player;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public Integer getPlayerCoins() {
        return playerCoins;
    }


    //Helper methods below

    public void processMovement(String islandDestination) {
        try {
            while (!player.haveIslandItem) {
                System.out.println("\n" + getPlayerName() + " has " + getPlayerCoins() + " coins");
                System.out.println("Where would you like to go. N/S/E/W");
                String input = scanner.nextLine();
                player.location = IsleFactory.islandLocationFactory(input, islandDestination);
                System.out.println("You are now at the " + player.location.getLocationName());
                playerInteractionOptions();
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void iterateThroughPlayerClues() {
        if (playerClues.size() == 0) {
            System.out.println("You have found no clues");
        }
        for (String clue : playerClues) {
            System.out.println(clue);
        }
    }

    public Integer coinManager(Integer coins) {
        if(coins.equals(0)){
            System.out.println("Nothing was found");
        }
        if (coins > 0) {
            playerCoins += coins;
            System.out.println("You found " + coins + " coins. You now have a total of " + getPlayerCoins() + " coins");
        }
        if (coins < 0) {
            playerCoins -= coins;
            System.out.println("Oh no! You lost " + coins + " coins. You now have a total of " + getPlayerCoins() + " coins.");
        }

        return coins;

    }

    public Integer playerCoinGenerator(){
        Random rand = new Random();
        int upperBoundofCoins = 51;
        int coins = rand.nextInt(upperBoundofCoins);
        if(coins >5){
            System.out.println("Nothing was found");
            return 0;
        }

        return coinManager(coins);
    }

    //TODO great example for input.isValid implementation. current !input.equals(z) logically makes no sense.
    public void playerInteractionOptions() throws IOException, InterruptedException {
        String input = "";
        playerInfoConsoleOutput();
        while (!input.equalsIgnoreCase("e")) {
//            playerInfoConsoleOutput();
            System.out.println("\n\n\n");
            System.out.println("What actions would you like to make? Talk(t)/ Look(l)/ Investigate(i)/ Clues(c)/ Exit(e)");
            input = scanner.nextLine();
            switch (input.toLowerCase()) {
                case "talk":
                case "t":
                    playerInfoConsoleOutput();
                    location.talkToNPC();
                    break;
                case "look":
                case "l":
                    playerInfoConsoleOutput();
                    location.lookAroundLocation();
                    break;
                case "investigate":
                case "i":
                    playerInfoConsoleOutput();
                    location.investigateArea();
                    break;
                case "clues":
                case "c":
                    playerInfoConsoleOutput();
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

    public void playerInfoConsoleOutput(){
        System.out.println(
                "\n\n"+
                        "-----------------------------------------------------------" + "\n" +
                        "                 Treasure Island                           " + "\n" +
                        "     Player: " + player.getPlayerName() +                "\n" +
                        "     Current Location: "  + location.getLocationName() +  "\n" +
                        "     Coins: " + player.getPlayerCoins() +               "\n" +
                        "                                                           " + "\n" +
                        "___________________________________________________________"
        );
    }
}
