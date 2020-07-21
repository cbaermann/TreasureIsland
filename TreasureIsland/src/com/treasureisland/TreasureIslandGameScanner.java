package com.treasureisland;

import com.treasureisland.world.Location;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class TreasureIslandGameScanner{
    private Location location;
    private String playerName;
    private Scanner scanner = new Scanner(System.in);
    private String input;
    public boolean haveAmazingItem = false;
    public ArrayList<String> playerClues = new ArrayList<>();
    private static TreasureIslandGameScanner scan = new TreasureIslandGameScanner();
    private TreasureIslandGameScanner(){
        
    }
    //TODO maybe create an input.isValid that accepts specific inputs. Would make validation easier and code cleaner.

    public static TreasureIslandGameScanner getInstance(){
        return scan;
    }

    public String getPlayerName() {
        return playerName;
    }


    public void chosePlayerName() {
            welcomeToTreasureIsland();
            System.out.println("Please enter your name");
            playerName = scanner.nextLine();
            System.out.println("\nWelcome, " + playerName + "\n \n");
            storylineProgression("GameIntroText.txt");
            rumDistillery();
    }

    void rumDistillery(){
        try {
            while (!haveAmazingItem) {
                System.out.println("Where would you like to go. N/S/E/W");
                input = scanner.nextLine();
                location = IsleFactory.rumRunnerIslandLocationFactory(input);
                System.out.println("You are now at the " + location.getLocationName());
                playerInteractionOptions();
            }
            System.out.println("Leaving Rum Runners Isle");
            portRoyal();
        }
        catch (IOException | InterruptedException e){
            e.printStackTrace();
        }
    }

    public void portRoyal(){
        System.out.println("You made it to Port Royal");
    }






//HELPER METHODS BELLOW

    private void iterateThroughPlayerClues(){
        if(playerClues.size() == 0){
            System.out.println("You have found no clues");
        }
        for(String clue : playerClues){
            System.out.println(clue);
        }
    }


    public void playerInteractionOptions() throws IOException, InterruptedException {
        //TODO great example for input.isValid implementation. current !input.equals(z) logically makes no sense.
        //TODO make Switch, potential easier handeling of inputs.
        while(!input.equals("z")) {
        System.out.println("What actions would you like to make? Talk(t)/ Look(l)/ Investigate(i)/ Clues(c)/ Exit(e)");
        input = scanner.nextLine();
        if (input.equalsIgnoreCase("talk") || input.equalsIgnoreCase("t")) {
            location.talkToNPC();
        }
        if (input.equalsIgnoreCase("look") || input.equalsIgnoreCase("l")) {
            location.lookAroundLocation();
        }
        if(input.equalsIgnoreCase("Investigate") || input.equalsIgnoreCase("i")){
            location.investigateArea();
        }
        if(input.equalsIgnoreCase("clues") || input.equalsIgnoreCase("c")){
            iterateThroughPlayerClues();
        }
        if(input.equalsIgnoreCase("exit") || input.equalsIgnoreCase("e")){
            break;
        }

    }}

    //File reads txt file that it's passed and prints to terminal.
    public void storylineProgression(String fileName){
        try {
            BufferedReader br = new BufferedReader(new FileReader("/Users/codybaermann/Documents/Capstone/TreasureIsland/src/com/treasureisland/text/" + fileName));
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
                Thread.sleep(1000);
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
        //TODO finish boat design for added effect leaving island to new one.
        System.out.println("\n" +
                "                  /|                           " + "\n" +
                "                 / |                           " + "\n" +
                "                /__|                           " + "\n" +
                "                   |                           " + "\n" +
                "            [______|______]                    " + "\n" + "\n"
                );

    }

}
