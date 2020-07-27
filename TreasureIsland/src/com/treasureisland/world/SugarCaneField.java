package com.treasureisland.world;

import com.treasureisland.TreasureIslandGameplay;

import com.treasureisland.items.Vendor;
import com.treasureisland.player.Player;

import java.util.Scanner;
//TODO "complete" besides deciding if we need a key array, also potentialy adding coins
//TODO decide if there is a vendor or something that coins can be spent. also potential health implementation
public class SugarCaneField implements Location{
    private final TreasureIslandGameplay game = TreasureIslandGameplay.getInstance();
    private final Player player = Player.getInstance();
    private final Vendor vendorItems = Vendor.getInstance();

    Scanner scanner = new Scanner(System.in);
    String input;

    @Override
    public String getLocationName() {
        return "Sugar cane field";
    }

    @Override
    public void talkToNPC() throws InterruptedException {
        System.out.println("I wont talk without the code");
        input = scanner.nextLine();
        if(input.equalsIgnoreCase("9999")){
            System.out.println("DING DING DING \n You have unlocked your first treasure piece. \n awarded the cane shard");
            player.haveIslandItem = true;

            //Testing ship battle.
            TreasureIslandGameplay.getInstance().sBattle();
        }
        else {
            System.out.println("Go away");
        }

    }

    @Override
    public void lookAroundLocation(){
        game.storylineProgression("TI.txt", getLocationName(), "WWStart", "WWEnd");
        player.playerCoinGenerator();


    }

    @Override
    public void investigateArea(){
        game.storylineProgression("TI.txt", getLocationName(), "SStart", "SEnd");
        //TODO decide what we want to do for the key. Will we need an object ArrayList to hold items?
        player.playerClues.add("some placeholder for the key");

    }

    @Override
    public void vendor() {
        System.out.println("\nWelcome to my shop! Please browse my collection \n");
        vendorItems.getAll();
    }

    /*
    public void vendor(){
        sout welcome to my shop
        vendorItems.getAll();
        input selector for vendor items.
        include method to grab item and increase health by amount
        reduce player coins by amount
        possibly include quantity that reduces by one every purchase
    }
     */




}
