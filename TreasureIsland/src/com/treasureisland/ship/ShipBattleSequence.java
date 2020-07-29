package com.treasureisland.ship;

import com.treasureisland.player.Player;

import java.util.Random;
import java.util.Scanner;

public class ShipBattleSequence {
    public EnemyShip enemyShip = EnemyShip.getInstance();
    public PlayerShip playerShip = PlayerShip.getInstance();

    public final Scanner scanner = new Scanner(System.in);
    public String input;
    private static final ShipBattleSequence shipBattleSequence = new ShipBattleSequence();

    private  ShipBattleSequence(){

    }

    public static ShipBattleSequence getInstance(){
        return shipBattleSequence;
    }

    public void shipBattleafterLeavingIsland(){
        while(playerShip.getPlayerShipHealth() > 0 && enemyShip.getEnemyShipHealth() > 0){
            System.out.println("You encountered " + enemyShip.getEnemyShipName());
            System.out.println("Would you like to Attack or Defend? A/D");
            input = scanner.nextLine();
            if("a".equalsIgnoreCase(input)){
                playerShip.attackEnemyShip(enemyShip);
                enemyAction();
            }
            if("d".equalsIgnoreCase(input)){
                playerShip.defendPlayerShip(enemyShip);
            }
            System.out.println("\n");
            healthStatus();
            System.out.println("\n");

        }
        System.out.println("You defeated " + enemyShip.getEnemyShipName() + "\n\n");
        playerShip.setPlayerShipHealth(100);
        enemyShip.setEnemyShipHealth(100);
    }



    public void enemyAction(){
        Random rand = new Random();
        int result = rand.nextInt(10 - 1) + 1;
        if(enemyShip.getEnemyShipHealth() > 0){
            if(result > 0 && result <=7){
                enemyShip.attackPlayerShip(playerShip);
            }
            if(result > 7){
                enemyShip.defendEnemyShip(playerShip);
            }
        }
    }

    public void healthStatus(){
        System.out.println("\n"+playerShip.getPlayerShipName() + ": " + playerShip.getPlayerShipHealth());
        System.out.println("\n"+enemyShip.getEnemyShipName() + ": " + enemyShip.getEnemyShipHealth());
    }
}
