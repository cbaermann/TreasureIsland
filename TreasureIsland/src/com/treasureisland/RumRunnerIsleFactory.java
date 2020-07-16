package com.treasureisland;

import com.treasureisland.rumrummersisle.*;

public class RumRunnerIsleFactory {
    private RumRunnerIsleFactory(){

    }


    public static Location islandLocationFactory(String direction){
        Location location = null;
        switch(direction){
            case "n":
                location = new RumDistillary();
                break;
            case "s":
                location = new Docks();
                break;

            case "e":
                location = new CaskRoom();
                break;

            case "w":
                location = new MasterBrewersHouse();
                break;

            default:
                System.out.println("Error, please select correct input");

        }
        return location;
    }
}
