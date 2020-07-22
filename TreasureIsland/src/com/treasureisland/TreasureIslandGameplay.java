package com.treasureisland;

import com.treasureisland.player.Player;
import com.treasureisland.world.Location;

import java.io.*;
import java.util.Scanner;

public class TreasureIslandGameplay {
    private final Player player =  Player.getInstance();
    private final Scanner scanner = new Scanner(System.in);
    private static final TreasureIslandGameplay scan = new TreasureIslandGameplay();
    private TreasureIslandGameplay(){
        
    }
    //TODO maybe create an input.isValid that accepts specific inputs. Would make validation easier and code cleaner.

    public static TreasureIslandGameplay getInstance(){
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
            storylineProgression("GameIntroText.txt","","", "");
            rumRunnerIsle();
    }
    //loop continues until they find the islands special item
    //allows user to chose N/S/E/W from IsleFactory
    //playerInteractionOptions allows for player to talk, look around, investigate or leave
    public void rumRunnerIsle(){
        try {
            //process player movement and takes in current island as parameter so factory knows where to delegate
            player.processMovement("rumRunnerisle");
            System.out.println("Leaving Rum Runners Isle \n \n");
            leavingIslandShipPrint();
            Thread.sleep(5000);
            player.haveIslandItem = false;
            portRoyal();
        }
        catch (InterruptedException e){
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
        islaCruces();


    }

    public void islaCruces() throws InterruptedException {
        System.out.println("At Isla Cruces");
        player.processMovement("islaCruces");
        System.out.println("Leaving Isla Cruces \n \n");
        leavingIslandShipPrint();
        Thread.sleep(5000);
        player.haveIslandItem = false;
//        islaDeMuerta();
    }
//
//    public void islaDeMuerta(){
//        System.out.println("At Isla de Muerta");
//    }




//HELPER METHODS BELLOW




    //File reads txt file that it's passed and prints to terminal.
    public void storylineProgression(String fileName, String location, String start, String stop){
        try {
            File myObj = new File(".\\TreasureIsland\\src\\com\\treasureisland\\text\\" + fileName);
            System.out.println(location);
            Scanner myReader = new Scanner(myObj);
            boolean tokenFound = false;
//            String start = "";
//            String stop = "";
//
//            if (location.equals("Rum Distillery")) {
//                start = "RDStart";
//                stop = "RDEnd";
//            } else if (location.equals("Rum DistilleryNPC")) {
//                start = "UCStart";
//                stop = "UCEnd";
//            }
//
//            System.out.println(start);

            while (myReader.hasNextLine()) {
                String data = myReader.nextLine().trim();
                if (data.equals(start)) //tag in the txt to locate position
                {
                    //System.out.println(start);
                    tokenFound = true;
                } else if (data.equals(stop)) { //tag to end reading he file.
                    tokenFound = false;
                }

                if ((tokenFound) && (!data.equals(start))) {

                    System.out.println(data);
                    Thread.sleep(1000);


                }
            }
        }
        catch(IOException | InterruptedException e){
            e.printStackTrace();
        }

    }


    public void welcomeToTreasureIsland(){
        System.out.println("\n" +
                " █     █░▓█████  ██▓     ▄████▄   ▒█████   ███▄ ▄███▓▓█████    ▄▄▄█████▓ ▒█████     ▄▄▄█████▓ ██▀███  ▓█████ ▄▄▄        ██████  █    ██  ██▀███  ▓█████     ██▓  ██████  ██▓    ▄▄▄       ███▄    █ ▓█████▄ \n" +
                "▓█░ █ ░█░▓█   ▀ ▓██▒    ▒██▀ ▀█  ▒██▒  ██▒▓██▒▀█▀ ██▒▓█   ▀    ▓  ██▒ ▓▒▒██▒  ██▒   ▓  ██▒ ▓▒▓██ ▒ ██▒▓█   ▀▒████▄    ▒██    ▒  ██  ▓██▒▓██ ▒ ██▒▓█   ▀    ▓██▒▒██    ▒ ▓██▒   ▒████▄     ██ ▀█   █ ▒██▀ ██▌\n" +
                "▒█░ █ ░█ ▒███   ▒██░    ▒▓█    ▄ ▒██░  ██▒▓██    ▓██░▒███      ▒ ▓██░ ▒░▒██░  ██▒   ▒ ▓██░ ▒░▓██ ░▄█ ▒▒███  ▒██  ▀█▄  ░ ▓██▄   ▓██  ▒██░▓██ ░▄█ ▒▒███      ▒██▒░ ▓██▄   ▒██░   ▒██  ▀█▄  ▓██  ▀█ ██▒░██   █▌\n" +
                "░█░ █ ░█ ▒▓█  ▄ ▒██░    ▒▓▓▄ ▄██▒▒██   ██░▒██    ▒██ ▒▓█  ▄    ░ ▓██▓ ░ ▒██   ██░   ░ ▓██▓ ░ ▒██▀▀█▄  ▒▓█  ▄░██▄▄▄▄██   ▒   ██▒▓▓█  ░██░▒██▀▀█▄  ▒▓█  ▄    ░██░  ▒   ██▒▒██░   ░██▄▄▄▄██ ▓██▒  ▐▌██▒░▓█▄   ▌\n" +
                "░░██▒██▓ ░▒████▒░██████▒▒ ▓███▀ ░░ ████▓▒░▒██▒   ░██▒░▒████▒     ▒██▒ ░ ░ ████▓▒░     ▒██▒ ░ ░██▓ ▒██▒░▒████▒▓█   ▓██▒▒██████▒▒▒▒█████▓ ░██▓ ▒██▒░▒████▒   ░██░▒██████▒▒░██████▒▓█   ▓██▒▒██░   ▓██░░▒████▓ \n" +
                "░ ▓░▒ ▒  ░░ ▒░ ░░ ▒░▓  ░░ ░▒ ▒  ░░ ▒░▒░▒░ ░ ▒░   ░  ░░░ ▒░ ░     ▒ ░░   ░ ▒░▒░▒░      ▒ ░░   ░ ▒▓ ░▒▓░░░ ▒░ ░▒▒   ▓▒█░▒ ▒▓▒ ▒ ░░▒▓▒ ▒ ▒ ░ ▒▓ ░▒▓░░░ ▒░ ░   ░▓  ▒ ▒▓▒ ▒ ░░ ▒░▓  ░▒▒   ▓▒█░░ ▒░   ▒ ▒  ▒▒▓  ▒ \n" +
                "  ▒ ░ ░   ░ ░  ░░ ░ ▒  ░  ░  ▒     ░ ▒ ▒░ ░  ░      ░ ░ ░  ░       ░      ░ ▒ ▒░        ░      ░▒ ░ ▒░ ░ ░  ░ ▒   ▒▒ ░░ ░▒  ░ ░░░▒░ ░ ░   ░▒ ░ ▒░ ░ ░  ░    ▒ ░░ ░▒  ░ ░░ ░ ▒  ░ ▒   ▒▒ ░░ ░░   ░ ▒░ ░ ▒  ▒ \n" +
                "  ░   ░     ░     ░ ░   ░        ░ ░ ░ ▒  ░      ░      ░        ░      ░ ░ ░ ▒       ░        ░░   ░    ░    ░   ▒   ░  ░  ░   ░░░ ░ ░   ░░   ░    ░       ▒ ░░  ░  ░    ░ ░    ░   ▒      ░   ░ ░  ░ ░  ░ \n" +
                "    ░       ░  ░    ░  ░░ ░          ░ ░         ░      ░  ░                ░ ░                 ░        ░  ░     ░  ░      ░     ░        ░        ░  ░    ░        ░      ░  ░     ░  ░         ░    ░    \n" +
                "                        ░                                                                                                                                                                            ░      \n");
    }

    public void leavingIslandShipPrint(){

        System.out.println(" " +
                "               __|__ |___| |\\\n" +
                "                |o__| |___| | \\\n" +
                "                |___| |___| |o \\\n" +
                "               _|___| |___| |__o\\\n" +
                "              /...\\_____|___|____\\_/\n" +
                "              \\   o * o * * o o  /\n" +
                "            ~~~~~~~~~~~~~~~~~~~~~~~~~~");

    }

}
