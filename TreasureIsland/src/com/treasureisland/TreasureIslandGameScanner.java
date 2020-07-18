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

    public static TreasureIslandGameScanner getInstance(){
        return scan;
    }

    public String getPlayerName() {
        return playerName;
    }


    public void chosePlayerName() {
        try {
            welcomeToTreasureIsland();
            System.out.println("Please enter your name");
            playerName = scanner.nextLine();
            System.out.println("\nWelcome, " + playerName + "\n \n");
            storylineProgression("GameIntroText.txt");
            rumDistillery();
        } catch(InterruptedException | IOException e){
            e.printStackTrace();
        }

    }

    public void rumDistillery() throws IOException, InterruptedException {
        while(!haveAmazingItem) {
            System.out.println("Where would you like to go. N/S/E/W");
            input = scanner.nextLine();
            location = RumRunnerIsleFactory.islandLocationFactory(input);
            System.out.println("You are now at the " + location.getLocationName());
            playerInteractionOptions();
        }
        System.out.println("Leaving Rum Runners Isle");
        isleDeMuerta();
    }

    public void isleDeMuerta(){
        System.out.println("You made it to Isle De Muerta");
    }






//HELPER METHODS BELLOW

    public void iterateThroughPlayerClues(){
        for(String clue : playerClues){
            System.out.println(clue);
        }
    }


    public void playerInteractionOptions() throws IOException, InterruptedException {
        while(input != "e") {
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
    public void storylineProgression(String fileName) throws IOException, InterruptedException {
        BufferedReader br = new BufferedReader(new FileReader("/Users/codybaermann/Documents/Capstone/TreasureIsland/src/com/treasureisland/text/" + fileName));
        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
            Thread.sleep(1000);
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

}
