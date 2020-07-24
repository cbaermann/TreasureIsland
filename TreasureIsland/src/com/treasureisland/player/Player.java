package com.treasureisland.player;

import com.treasureisland.IsleFactory;
import com.treasureisland.TreasureIslandGameplay;
import com.treasureisland.items.Vendor;
import com.treasureisland.world.Location;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Player {
    private String playerName;
    private int playerCoins = 100;
    private int playerHealth = 50;
    public ArrayList<String> playerClues = new ArrayList<>();
    public Location location;
    public boolean haveIslandItem = false;
    Scanner scanner = new Scanner(System.in);
    String input;


    private static final Player player = new Player();
    private final Vendor vendorItems = Vendor.getInstance();

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

    public void setPlayerCoins(int playerCoins) {
        this.playerCoins = playerCoins;
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


    public void coinManager(Integer coins) {
        if(coins.equals(0)){
            System.out.println("Nothing was found CM");
        }
        if (coins > 0) {
            playerCoins += coins;
            System.out.println("You found " + coins + " coins. You now have a total of " + getPlayerCoins() + " coins");
        }
        if (coins < 0) {
            playerCoins -= coins;
            System.out.println("You spent " + coins + " gold. You now have a total of " + getPlayerCoins() + " coins.");
        }

    }

    public void playerVisitsVendor(){
        System.out.println("\nWelcome to my shop! Please browse my collection \n");
        vendorItems.getAll();
        System.out.println("\nWould you like to buy anything? y/n");
        input = scanner.nextLine();
        if("y".equalsIgnoreCase(input)){
            player.playerPurchase();
        }
        if("n".equalsIgnoreCase(input)){
            System.out.println("Bye");
        }
    }

    public void playerPurchase(){
        System.out.println("\nWhat would you like to buy?");
        input = scanner.nextLine();
        switch(input.toLowerCase()){
            case"Banana":
            case "b":
                System.out.println("You bought a banana");
                player.setPlayerHealth(player.getPlayerHealth() + vendorItems.findByName("Banana").healthValue);
                player.itemManager(vendorItems.findByName("Banana").cost);
                break;
            case "Apple":
            case "ap":
                System.out.println("bought apple");
                player.setPlayerHealth(player.getPlayerHealth() + vendorItems.findByName("Apple").healthValue);
                player.itemManager(vendorItems.findByName("Apple").cost);
                break;
            case "Rum":
            case "r":
                System.out.println("bought rum");
                player.setPlayerHealth(player.getPlayerHealth() + vendorItems.findByName("Rum").healthValue);
                player.itemManager(vendorItems.findByName("Rum").cost);
                break;
            case "Salted meat":
            case "sm":
                System.out.println("bought salted meat");
                player.setPlayerHealth(player.getPlayerHealth() + vendorItems.findByName("Salted meat").healthValue);
                player.itemManager(vendorItems.findByName("Salted meat").cost);
                break;
            case "Sea biscuits":
            case "sb":
                System.out.println("bought sea biscuts");
                player.setPlayerHealth(player.getPlayerHealth() + vendorItems.findByName("Sea biscuits").healthValue);
                player.itemManager(vendorItems.findByName("Sea biscuits").cost);
                break;
            case "Ale":
            case "al":
                System.out.println("Bought ale");
                player.setPlayerHealth(player.getPlayerHealth() + vendorItems.findByName("Ale").healthValue);
                player.itemManager(vendorItems.findByName("Ale").cost);
                break;
            default:
                System.out.println("Invalid input");
                playerPurchase();
                break;
        }

    }


    public void itemManager(Integer coins){
        if(getPlayerCoins() - coins < 0){
            System.out.println("You can not afford this item");
        }
        else {
            setPlayerCoins(getPlayerCoins() - coins);
            System.out.println("You spent " + coins + " gold. You now have " + getPlayerCoins() + " gold.");
        }
    }

    public void playerCoinGenerator(){
        Random rand = new Random();
        int upperBoundofCoins = 51;
        int coins = rand.nextInt(upperBoundofCoins);

     
        if(coins <0){
            System.out.println("Nothing was found ");
            return;
        }

        coinManager(coins);
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
                TreasureIslandGameplay.getInstance().chosePlayerName();            }
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
                playerInteractionOptions(input);
            }

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    //TODO great example for input.isValid implementation. current !input.equals(z) logically makes no sense.
    public void playerInteractionOptions(String direction) throws IOException, InterruptedException {
        String input = "";
        playerInfoConsoleOutput();
        while (!input.equalsIgnoreCase("e")) {
            playerHealthCheck();
            System.out.println("\n\n\n");
            if("w".equalsIgnoreCase(direction)){
                System.out.println("What actions would you like to make? Talk(t)/ Look(l)/ Investigate(i)/ Vendor(v)/ Clues(c)/ Exit(e)");
            }
            else {
                System.out.println("What actions would you like to make? Talk(t)/ Look(l)/ Investigate(i)/ Clues(c)/ Exit(e)");
            }
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
                case "vemdpr":
                case "v":
                    playerInfoConsoleOutput();
                    location.vendor();
                    break;
                    //TODO try if statement to catch w direction for vendor.
                    //if player.direction is w then add vendor option as well (v)
                case "exit":
                case "e":
                    break;
                default:
                    System.out.println("Invalid input, please try again.");
                    playerInteractionOptions(input);
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
