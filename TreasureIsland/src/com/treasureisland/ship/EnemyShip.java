package com.treasureisland.ship;

import com.treasureisland.player.Player;

import java.sql.PseudoColumnUsage;
import java.util.Random;

public class EnemyShip {
    public Player player = Player.getInstance();
    public final String enemyShipName = " An Unidentified Ship";
    public   Integer enemyShipHealth = 100;
    public Integer enemyAttackStrength = new Random().nextInt(100);
    private static final EnemyShip enemyShip = new EnemyShip();



    private EnemyShip(){

    }

    public static EnemyShip getInstance(){
        return enemyShip;
    }




    public String getEnemyShipName() {
        return enemyShipName;
    }

    public Integer getEnemyShipHealth() {
        return enemyShipHealth;
    }

    public void setEnemyShipHealth(Integer enemyShipHealth) {
        this.enemyShipHealth = enemyShipHealth;
    }

    public void attackPlayerShip(PlayerShip playerShip){
        Integer enemyAttackStrength = new Random().nextInt(100);
        System.out.println(enemyShipName + " attacked " + playerShip.getPlayerShipName() + " for " + enemyAttackStrength + " damage.");
        playerShip.setPlayerShipHealth(playerShip.getPlayerShipHealth() - enemyAttackStrength);

        if(playerShip.getPlayerShipHealth() <= 0){
            System.out.println("You died");
            player.playerDeathArt();
            player.playerDeathOptions();
        }
    }

    public void defendEnemyShip(PlayerShip playerShip){
        int result = playerShip.playerAttackStrength - getEnemyShipHealth();
        if(result <= 0){
            System.out.println(getEnemyShipName() + " did no damage.");
        }
        else{
            setEnemyShipHealth(getEnemyShipHealth() - result);
            System.out.println(playerShip.getPlayerShipName() + " did " + result + " damage");
        }
    }

}
