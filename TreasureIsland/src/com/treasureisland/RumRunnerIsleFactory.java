package com.treasureisland;

import com.treasureisland.world.*;

import java.io.IOException;

public class RumRunnerIsleFactory {


    private RumRunnerIsleFactory(){

    }
    private static final TreasureIslandGameScanner player = TreasureIslandGameScanner.getInstance();



    public static Location islandLocationFactory(String direction) throws IOException, InterruptedException {
        Location location = null;
        switch(direction.toLowerCase()){
            case "n":
                location = new RumDistillery();
                break;
            case "s":
                location = new CrimsonBeachBar();
                break;

            case "e":
                location = new AbandonedDistillery();
                break;

            case "w":
                location = new SugarCaneField();
                break;

            default:
                System.out.println("Error, please select correct input");
                player.rumDistillery();
                break;
        }
        return location;
    }
}
