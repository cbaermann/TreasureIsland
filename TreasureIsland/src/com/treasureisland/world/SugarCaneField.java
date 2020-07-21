package com.treasureisland.world;

import com.treasureisland.TreasureIslandGameScanner;

import java.io.IOException;
import java.util.Scanner;
//TODO "complete" besides deciding if we need a key array, also potentialy adding coins
//TODO decide if there is a vendor or something that coins can be spent. also potential health implementation
public class SugarCaneField implements Location{
    private final TreasureIslandGameScanner player = TreasureIslandGameScanner.getInstance();
    Scanner scanner = new Scanner(System.in);
    String input;

    @Override
    public String getLocationName() {
        return "Sugar cane field";
    }

    @Override
    public void talkToNPC() {
        System.out.println("I wont talk without the code");
        input = scanner.nextLine();
        if(input.equalsIgnoreCase("9999")){
            System.out.println("DING DING DING \n You have unlocked your first treasure piece. \n awarded the cane shard");
            player.haveAmazingItem = true;
        }
        else {
            System.out.println("Go away");
        }

    }

    @Override
    public void lookAroundLocation() throws IOException, InterruptedException {
        player.storylineProgression("RumIsleCaneFieldRock.txt");
    }

    @Override
    public void investigateArea() throws IOException, InterruptedException {
        player.storylineProgression("RumIsleCaneField.txt");
        //TODO decide what we want to do for the key. Will we need an object ArrayList to hold items?
        player.playerClues.add("some placeholder for the key");
    }


}