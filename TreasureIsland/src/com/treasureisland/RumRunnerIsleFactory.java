package com.treasureisland;

import com.treasureisland.rumrummersisle.*;

public class RumRunnerIsleFactory {
    private RumRunnerIsleFactory(){

    }


    public static Location islandLocationFactory(String direction){
        Location location = null;
        switch(direction.toLowerCase()){
            case "n":
                location = new RumDistillary();
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
        }
        return location;
    }
}
