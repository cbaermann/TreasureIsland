package com.treasureisland;

import com.treasureisland.island.IslandSelector;
import com.treasureisland.player.Color;
import com.treasureisland.player.Player;
import com.treasureisland.ship.ShipBattleSequence;


import java.io.*;
import java.util.Scanner;


public class TreasureIslandGameplay implements java.io.Serializable {
    private final Player player = Player.getInstance();
    private final ShipBattleSequence shipBattleSequence = ShipBattleSequence.getInstance();
    private IslandSelector island;
    private final Scanner scanner = new Scanner(System.in);
    String input;
    private static final TreasureIslandGameplay scan = new TreasureIslandGameplay();
    private SaveLoadGame saveLoadGame;


    private TreasureIslandGameplay() {

    }
    //TODO maybe create an input.isValid that accepts specific inputs. Would make validation easier and code cleaner.

    public static TreasureIslandGameplay getInstance() {
        return scan;
    }


    //Player chooses name and is stored into playerName variable
    //calls first storyline txt file then puts player into rumDistillery()
    public void chosePlayerName() {
        welcomeToTreasureIsland();
        System.out.println("Please enter your name");
        String input = scanner.nextLine();
        player.setPlayerName(input);
        System.out.println("\nWelcome, " + player.getPlayerName() + "\n \n");
        storylineProgression("GameIntroText.txt", "", "start", "stop");
        rumRunnerIsle();


    }

    //loop continues until they find the islands special item
    //allows user to chose N/S/E/W from IsleFactory
    //playerInteractionOptions allows for player to talk, look around, investigate or leave

    public void rumRunnerIsle() {
        try {
            //process player movement and takes in current island as parameter so factory knows where to delegate
            player.processMovement("rumRunnerisle");
            System.out.println("Leaving Rum Runners Isle \n \n");
            leavingIslandShipPrint();
            Thread.sleep(5000);
            player.haveIslandItem = false;
            ShipBattleSequence.getInstance().shipBattleafterLeavingIsland();
            portRoyal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


    public void portRoyal() throws InterruptedException {
        System.out.println("You made it to Port Royal");
        player.processMovement("portRoyal");
        System.out.println("Leaving Port Royal Isle \n \n");
        leavingIslandShipPrint();
        Thread.sleep(5000);
        player.haveIslandItem = false;
        ShipBattleSequence.getInstance().shipBattleafterLeavingIsland();
        islaCruces();


    }

    public void islaCruces() throws InterruptedException {
        System.out.println("At Isla Cruces");
        player.processMovement("islaCruces");
        System.out.println("Leaving Isla Cruces \n \n");
        leavingIslandShipPrint();
        Thread.sleep(5000);
        player.haveIslandItem = false;
        ShipBattleSequence.getInstance().shipBattleafterLeavingIsland();

        islaDeMuerta();
    }

    public void islaDeMuerta() throws InterruptedException {
        System.out.println("At Isla de Muerta");
        player.processMovement("islademuerta");
        System.out.println("Leaving Isla De Muerta \n \n");
        leavingIslandShipPrint();
        Thread.sleep(5000);
        treasureIsland();
    }

    public void treasureIsland(){
        System.out.println("hey you made it");
        TreasureIslandGameplay.getInstance().storylineProgression("TI.txt", "", "TIStart", "TIEnd");
        Scanner scanner = new Scanner(System.in);
//        System.out.println(" Would you like to check your clues/Information  Yes(y)   No(o) \n");
        System.out.println(" Press (e) to exit");
        String input = scanner.nextLine();
        if (input.equalsIgnoreCase("e")) {
            System.exit(0);
        }




    }


//HELPER METHODS BELLOW


    //USER NEEDS TO INPUT THEIR SPECIFIC FILE PATH TO THE TEXT FOLDER
    //STILL WORKING ON HOW TO GET A CONSISTENT PATH FOR EVERY USER
    //File reads txt file that it's passed and prints to terminal.
    public void storylineProgression(String fileName, String location, String start, String stop) {
        try {
            File myObj = new File("/Users/codybaermann/Documents/Capstone/TreasureIsland/src/com/treasureisland/text/" + fileName);            System.out.println(location);
            Scanner myReader = new Scanner(myObj);
            boolean tokenFound = false;

            while (myReader.hasNextLine()) {
                String data = myReader.nextLine().trim();
                if (data.equals(start)) //tag in the txt to locate starting position
                {
                    //System.out.println(start);
                    tokenFound = true;
                } else if (data.equals(stop)) { //tag to end reading the file.
                    tokenFound = false;
                }

                if ((tokenFound) && (!data.equals(start))) {

                    System.out.println(data);
                    Thread.sleep(1000);


                }
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

    }


    public void welcomeToTreasureIsland() {

        System.out.println("\n" + Color.ANSI_BLUE.getValue()+

                " █     █░▓█████  ██▓     ▄████▄   ▒█████   ███▄ ▄███▓▓█████    ▄▄▄█████▓ ▒█████     ▄▄▄█████▓ ██▀███  ▓█████ ▄▄▄        ██████  █    ██  ██▀███  ▓█████     ██▓  ██████  ██▓    ▄▄▄       ███▄    █ ▓█████▄ \n" +
                "▓█░ █ ░█░▓█   ▀ ▓██▒    ▒██▀ ▀█  ▒██▒  ██▒▓██▒▀█▀ ██▒▓█   ▀    ▓  ██▒ ▓▒▒██▒  ██▒   ▓  ██▒ ▓▒▓██ ▒ ██▒▓█   ▀▒████▄    ▒██    ▒  ██  ▓██▒▓██ ▒ ██▒▓█   ▀    ▓██▒▒██    ▒ ▓██▒   ▒████▄     ██ ▀█   █ ▒██▀ ██▌\n" +
                "▒█░ █ ░█ ▒███   ▒██░    ▒▓█    ▄ ▒██░  ██▒▓██    ▓██░▒███      ▒ ▓██░ ▒░▒██░  ██▒   ▒ ▓██░ ▒░▓██ ░▄█ ▒▒███  ▒██  ▀█▄  ░ ▓██▄   ▓██  ▒██░▓██ ░▄█ ▒▒███      ▒██▒░ ▓██▄   ▒██░   ▒██  ▀█▄  ▓██  ▀█ ██▒░██   █▌\n" +
                "░█░ █ ░█ ▒▓█  ▄ ▒██░    ▒▓▓▄ ▄██▒▒██   ██░▒██    ▒██ ▒▓█  ▄    ░ ▓██▓ ░ ▒██   ██░   ░ ▓██▓ ░ ▒██▀▀█▄  ▒▓█  ▄░██▄▄▄▄██   ▒   ██▒▓▓█  ░██░▒██▀▀█▄  ▒▓█  ▄    ░██░  ▒   ██▒▒██░   ░██▄▄▄▄██ ▓██▒  ▐▌██▒░▓█▄   ▌\n" +
                "░░██▒██▓ ░▒████▒░██████▒▒ ▓███▀ ░░ ████▓▒░▒██▒   ░██▒░▒████▒     ▒██▒ ░ ░ ████▓▒░     ▒██▒ ░ ░██▓ ▒██▒░▒████▒▓█   ▓██▒▒██████▒▒▒▒█████▓ ░██▓ ▒██▒░▒████▒   ░██░▒██████▒▒░██████▒▓█   ▓██▒▒██░   ▓██░░▒████▓ \n" +
                "░ ▓░▒ ▒  ░░ ▒░ ░░ ▒░▓  ░░ ░▒ ▒  ░░ ▒░▒░▒░ ░ ▒░   ░  ░░░ ▒░ ░     ▒ ░░   ░ ▒░▒░▒░      ▒ ░░   ░ ▒▓ ░▒▓░░░ ▒░ ░▒▒   ▓▒█░▒ ▒▓▒ ▒ ░░▒▓▒ ▒ ▒ ░ ▒▓ ░▒▓░░░ ▒░ ░   ░▓  ▒ ▒▓▒ ▒ ░░ ▒░▓  ░▒▒   ▓▒█░░ ▒░   ▒ ▒  ▒▒▓  ▒ \n" +
                "  ▒ ░ ░   ░ ░  ░░ ░ ▒  ░  ░  ▒     ░ ▒ ▒░ ░  ░      ░ ░ ░  ░       ░      ░ ▒ ▒░        ░      ░▒ ░ ▒░ ░ ░  ░ ▒   ▒▒ ░░ ░▒  ░ ░░░▒░ ░ ░   ░▒ ░ ▒░ ░ ░  ░    ▒ ░░ ░▒  ░ ░░ ░ ▒  ░ ▒   ▒▒ ░░ ░░   ░ ▒░ ░ ▒  ▒ \n" +
                "  ░   ░     ░     ░ ░   ░        ░ ░ ░ ▒  ░      ░      ░        ░      ░ ░ ░ ▒       ░        ░░   ░    ░    ░   ▒   ░  ░  ░   ░░░ ░ ░   ░░   ░    ░       ▒ ░░  ░  ░    ░ ░    ░   ▒      ░   ░ ░  ░ ░  ░ \n" +
                "    ░       ░  ░    ░  ░░ ░          ░ ░         ░      ░  ░                ░ ░                 ░        ░  ░     ░  ░      ░     ░        ░        ░  ░    ░        ░      ░  ░     ░  ░         ░    ░    \n" +
                "                        ░                                                                                                                                                                            ░      \n" +
                Color.ANSI_RESET.getValue());
    }

    public void leavingIslandShipPrint() {

        System.out.println(" " +
                "               __|__ |___| |\\\n" +
                "                |o__| |___| | \\\n" +
                "                |___| |___| |o \\\n" +
                "               _|___| |___| |__o\\\n" +
                "              /...\\_____|___|____\\_/\n" +
                "              \\   o * o * * o o  /\n" +
                "            ~~~~~~~~~~~~~~~~~~~~~~~~~~");

    }

    public void customGameplayOptions() throws InterruptedException {
        System.out.println("Would you like to Load existing game, play the full game, or play on a sample island? L/F/S");
        input = scanner.nextLine();
        if ("l".equalsIgnoreCase(input)) {
            saveLoadGame.loadGame();
        }
        if ("f".equalsIgnoreCase(input)) {
            chosePlayerName();
        }
        if ("s".equalsIgnoreCase(input)) {
            player.setPlayerName("Test Player");
            testIslandSelector();
        } else {
            customGameplayOptions();
        }
    }

    public void testIslandSelector() throws InterruptedException {
        System.out.println("Which island would you like to play?\n" +
                "1) Rum Runner Isle \n" +
                "2) Port Royal \n" +
                "3) Isla Cruces \n" +
                "4) Isla de Muerta \n" +
                "5) Back to main");
        input = scanner.nextLine();
        if ("1".equals(input)) {
            rumRunnerIsle();
        }
        if ("2".equals(input)) {
            portRoyal();
        }
        if ("3".equals(input)) {
            islaCruces();
        }
        if ("4".equals(input)) {
            islaDeMuerta();
        }
        if ("5".equals(input)) {
            customGameplayOptions();
        } else {
            testIslandSelector();
        }

    }


}

