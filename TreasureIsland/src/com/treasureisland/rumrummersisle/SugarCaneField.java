package com.treasureisland.rumrummersisle;

import com.treasureisland.TreasureIslandGameScanner;

import java.io.IOException;
import java.util.Scanner;

public class SugarCaneField implements Location{
    private TreasureIslandGameScanner player = TreasureIslandGameScanner.getInstance();
    Scanner scanner = new Scanner(System.in);
    String input;

    @Override
    public String getLocationName() {
        String locationName = "Sugar cane field";
        return locationName;
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
