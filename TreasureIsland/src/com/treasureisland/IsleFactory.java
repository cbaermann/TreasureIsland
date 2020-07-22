package com.treasureisland;
import com.treasureisland.world.*;


public class IsleFactory {



    private IsleFactory(){

    }
    private static final TreasureIslandGameplay player = TreasureIslandGameplay.getInstance();



    public static Location islandLocationFactory(String direction, String islandFactorySelection) throws InterruptedException {
        Location location = null;
        if("rumrunnerisle".equalsIgnoreCase(islandFactorySelection)) {
           //islandFactorySelection.equalsIgnoreCase("rumRunnerIsle") old implementation
            switch (direction.toLowerCase()) {
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
                    player.rumRunnerIsle();
                    break;
            }
        }
        if(islandFactorySelection.equalsIgnoreCase("portRoyal")){
            switch(direction.toLowerCase()){
                case "n":
                    location = new RoyalLodge();
                    break;
                case "s":
                    location = new ShipGraveyard();
                    break;

                case "e":
                    location = new SunsetRestaurant();
                    break;

                case "w":
                    location = new TikkiLounge();
                    break;

                default:
                    System.out.println("Error, please select correct input");
                    player.portRoyal();
                    break;
            }
        }

        return location;
    }





}
