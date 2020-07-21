package com.treasureisland;
import com.treasureisland.world.*;

public class IsleFactory {


    private IsleFactory(){

    }
    private static final TreasureIslandGameplay player = TreasureIslandGameplay.getInstance();



    public static Location rumRunnerIslandLocationFactory(String direction){
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

//    public static Location portRoyalLocationFactory(String direction){
//        Location location = null;
//        switch(direction.toLowerCase()){
//            case "n":
//                location = new RoyalLodge();
//                break;
//            case "s":
//                location = new ShipGraveyard();
//                break;
//
//            case "e":
//                location = new SunsetRestaurant();
//                break;
//
//            case "w":
//                location = new TikkiLounge();
//                break;
//
//            default:
//                System.out.println("Error, please select correct input");
//                player.portRoyal();
//                break;
//        }
//        return location;
//    }


}
