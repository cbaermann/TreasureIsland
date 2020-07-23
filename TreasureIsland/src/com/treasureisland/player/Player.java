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
    private int playerHealth = 50;
    public ArrayList<String> playerClues = new ArrayList<>();
    public Location location;
    public boolean haveIslandItem = false;
    Scanner scanner = new Scanner(System.in);
    String input;


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

    public Integer getPlayerHealth(){ return playerHealth;}

    public void setPlayerHealth(Integer playerHealth){
        this.playerHealth = playerHealth;
    }


    //Helper methods below
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
            System.out.println("Nothing was found CM");
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

     
        if(coins <0){
            System.out.println("Nothing was found ");
            return 0;
        }

        return coinManager(coins);
    }

    //TODO figure out why this is throwing NPE. Do not get NPE on any other class that imports
    //TODO TreasureIslandGameScanner other than this one.
    //NOT IMPLEMENTED UNTIL NPE IS SOLVED
    public void playerHealthCheck(){
        if(player.getPlayerHealth() < 0){
            player.playerDeathArt();
            System.out.println("Would you like to play again? Y/N");
            input = scanner.nextLine();
            //TODO NO IMPLEMENTATION YET FOR INVALID INPUT HANDLING
            if("y".equalsIgnoreCase(input)){
                treasureIslandGameplay.chosePlayerName();
            }
            if("n".equalsIgnoreCase(input)){
                System.out.println("Thank you for playing");
                System.exit(0);
            }
        }
    }

    public void processMovement(String islandDestination) {
        try {
            while (!player.haveIslandItem) {
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

    //TODO great example for input.isValid implementation. current !input.equals(z) logically makes no sense.
    public void playerInteractionOptions() throws IOException, InterruptedException {
        String input = "";
        playerInfoConsoleOutput();
        while (!input.equalsIgnoreCase("e")) {
//            playerHealthCheck();
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

    public void playerDeathArt(){
        System.out.println("\n" +
                "▓██   ██▓ ▒█████   █    ██    ▓█████▄  ██▓▓█████ ▓█████▄ \n" +
                " ▒██  ██▒▒██▒  ██▒ ██  ▓██▒   ▒██▀ ██▌▓██▒▓█   ▀ ▒██▀ ██▌\n" +
                "  ▒██ ██░▒██░  ██▒▓██  ▒██░   ░██   █▌▒██▒▒███   ░██   █▌\n" +
                "  ░ ▐██▓░▒██   ██░▓▓█  ░██░   ░▓█▄   ▌░██░▒▓█  ▄ ░▓█▄   ▌\n" +
                "  ░ ██▒▓░░ ████▓▒░▒▒█████▓    ░▒████▓ ░██░░▒████▒░▒████▓ \n" +
                "   ██▒▒▒ ░ ▒░▒░▒░ ░▒▓▒ ▒ ▒     ▒▒▓  ▒ ░▓  ░░ ▒░ ░ ▒▒▓  ▒ \n" +
                " ▓██ ░▒░   ░ ▒ ▒░ ░░▒░ ░ ░     ░ ▒  ▒  ▒ ░ ░ ░  ░ ░ ▒  ▒ \n" +
                " ▒ ▒ ░░  ░ ░ ░ ▒   ░░░ ░ ░     ░ ░  ░  ▒ ░   ░    ░ ░  ░ \n" +
                " ░ ░         ░ ░     ░           ░     ░     ░  ░   ░    \n" +
                " ░ ░                           ░                  ░      \n");
    }

    public void playerInfoConsoleOutput(){
        System.out.println(
                "\n\n"+
                        "-----------------------------------------------------------" + "\n" +
                        "                 Treasure Island                           " + "\n" +
                        "     Player: " + player.getPlayerName() +                "\n" +
                        "     Player: " + player.getPlayerHealth() +              "\n" +
                        "     Current Location: "  + location.getLocationName() +  "\n" +
                        "     Coins: " + player.getPlayerCoins() +               "\n" +
                        "                                                           " + "\n" +
                        "___________________________________________________________"
        );
    }
}
