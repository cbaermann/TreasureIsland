package com.treasureisland;

import com.treasureisland.player.Player;

import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class TreasureIslandGameplay {
    private final Player player = Player.getInstance();
    private final Scanner scanner = new Scanner(System.in);
    private static final TreasureIslandGameplay scan = new TreasureIslandGameplay();

    private TreasureIslandGameplay() {

    }
    //TODO maybe create an input.isValid that accepts specific inputs. Would make validation easier and code cleaner.

    public static TreasureIslandGameplay getInstance() {
        return scan;
    }


    //Player chooses name and is stored into playerName variable
    //calls first storyline txt file then puts player into rumDistillery()
    public void chosePlayerName() {
        welcomeToTreasureIsland();
        System.out.println("Please enter your name");
        String input = scanner.nextLine();
        player.setPlayerName(input);
        System.out.println("\nWelcome, " + player.getPlayerName() + "\n \n");
        storylineProgression("GameIntroText.txt", "", "start", "stop");
        rumRunnerIsle();


    }

    //loop continues until they find the islands special item
    //allows user to chose N/S/E/W from IsleFactory
    //playerInteractionOptions allows for player to talk, look around, investigate or leave
    public void rumRunnerIsle() {
        try {
            //process player movement and takes in current island as parameter so factory knows where to delegate
            player.processMovement("rumRunnerisle");
            System.out.println("Leaving Rum Runners Isle \n \n");
            leavingIslandShipPrint();
            Thread.sleep(5000);
            sBattle();
            player.haveIslandItem = false;
            portRoyal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


    public void portRoyal() throws InterruptedException {
        System.out.println("You made it to Port Royal");
        player.processMovement("portRoyal");
        System.out.println("Leaving Port Royal Isle \n \n");
        leavingIslandShipPrint();
        Thread.sleep(5000);
        player.haveIslandItem = false;
        islaCruces();


    }

    public void islaCruces() throws InterruptedException {
        System.out.println("At Isla Cruces");
        player.processMovement("islaCruces");
        System.out.println("Leaving Isla Cruces \n \n");
        leavingIslandShipPrint();
        Thread.sleep(5000);
        player.haveIslandItem = false;
//        islaDeMuerta();
    }
//
//    public void islaDeMuerta(){
//        System.out.println("At Isla de Muerta");
//    }


//HELPER METHODS BELLOW


    //USER NEEDS TO INPUT THEIR SPECIFIC FILE PATH TO THE TEXT FOLDER
    //STILL WORKING ON HOW TO GET A CONSISTENT PATH FOR EVERY USER
    //File reads txt file that it's passed and prints to terminal.
    public void storylineProgression(String fileName, String location, String start, String stop) {
        try {
            File myObj = new File(".\\TreasureIsland\\src\\com\\treasureisland\\text\\" + fileName);
            System.out.println(location);
            Scanner myReader = new Scanner(myObj);
            boolean tokenFound = false;

            while (myReader.hasNextLine()) {
                String data = myReader.nextLine().trim();
                if (data.equals(start)) //tag in the txt to locate starting position
                {
                    //System.out.println(start);
                    tokenFound = true;
                } else if (data.equals(stop)) { //tag to end reading the file.
                    tokenFound = false;
                }

                if ((tokenFound) && (!data.equals(start))) {

                    System.out.println(data);
                    Thread.sleep(1000);


                }
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

    }

    // Need to add exception handling - Guru
    public void sBattle() throws InterruptedException {
        int enemyShip = 100;
        int playerShip = 100;
        System.out.println("Where would you like attack (a) or defend (d)");
        String input = scanner.nextLine();
        if ("a".equalsIgnoreCase(input)) {
            while (playerShip >= 0 || enemyShip >= 0) {
                //System.out.println("phealth"+ playerShip +"\n eHealth" + enemyShip);
                int attackEnemy = new Random().nextInt(100);
                int enemyAttack = new Random().nextInt(100);

                if (enemyShip > 0 && playerShip > 0) {
                    System.out.println("You attacked enemy for damage " + attackEnemy);
                    Thread.sleep(1000);
                    int remainingEnemyShealth = enemyShip - attackEnemy;
                    enemyShip = remainingEnemyShealth;
                    System.out.println(" Enemy health " + enemyShip);
                }

                if (enemyShip > 0 && playerShip > 0) {
                    System.out.println("Enemy attacked you for " + enemyAttack);
                    Thread.sleep(1000);
                    int remainingPlayerShealth = playerShip - enemyAttack;
                    playerShip = remainingPlayerShealth;
                    System.out.println("Player Health " + playerShip);
                }
                if (enemyShip <= 0) {
                    //System.out.println("phealth"+ playerShip +"\n eHealth" + enemyShip);
                    System.out.println("You killed the enemy ");
                    break;
                } else if (playerShip <= 0) {
                    System.out.println("You Died");
                    player.playerDeathArt();
                    System.out.println("Would you like to play again? Y/N");
                    input = scanner.nextLine();

                    if("y".equalsIgnoreCase(input)){
                        TreasureIslandGameplay.getInstance().chosePlayerName();            }
                    if("n".equalsIgnoreCase(input)){
                        System.out.println("Thank you for playing");
                        System.exit(0);
                    }

                }
            }

        } else if ("d".equalsIgnoreCase(input)) {
            while (playerShip >= 0 || enemyShip >= 0) {
                //System.out.println("phealth"+ playerShip +"\n eHealth" + enemyShip);
                int attackEnemy = new Random().nextInt(100);
                int enemyAttack = new Random().nextInt(100);
                int playerDefence = new Random().nextInt(20);

                if (enemyShip > 0 && playerShip > 0) {
                    System.out.println("Enemy attacked you " + enemyAttack + " You defended " + playerDefence);
                    System.out.println("Total damage " + ((playerShip + playerDefence)- enemyAttack));
                    Thread.sleep(1000);
                    int remainingPlayerShealth = playerShip - enemyAttack;
                    playerShip = remainingPlayerShealth;
                    System.out.println("Player Health " + playerShip);
                }

                if (enemyShip > 0 && playerShip > 0) {
                    System.out.println("You attacked enemy for " + attackEnemy);
                    Thread.sleep(1000);
                    int remainingEnemyShealth = enemyShip - attackEnemy;
                    enemyShip = remainingEnemyShealth;
                    System.out.println("Enemy health " + enemyShip);
                }
                if (enemyShip <= 0) {
                    //System.out.println("phealth"+ playerShip +"\n eHealth" + enemyShip);
                    System.out.println("You killed the enemy ");
                    break;
                } else if (playerShip <= 0) {
                    System.out.println("You Died");
                    player.playerDeathArt();
                    System.out.println("Would you like to play again? Y/N");
                    input = scanner.nextLine();

                    if("y".equalsIgnoreCase(input)){
                        TreasureIslandGameplay.getInstance().chosePlayerName();            }
                    if("n".equalsIgnoreCase(input)){
                        System.out.println("Thank you for playing");
                        System.exit(0);
                    }


                }
            }
        }

    }

    public void welcomeToTreasureIsland() {
        System.out.println("\n" +
                " █     █░▓█████  ██▓     ▄████▄   ▒█████   ███▄ ▄███▓▓█████    ▄▄▄█████▓ ▒█████     ▄▄▄█████▓ ██▀███  ▓█████ ▄▄▄        ██████  █    ██  ██▀███  ▓█████     ██▓  ██████  ██▓    ▄▄▄       ███▄    █ ▓█████▄ \n" +
                "▓█░ █ ░█░▓█   ▀ ▓██▒    ▒██▀ ▀█  ▒██▒  ██▒▓██▒▀█▀ ██▒▓█   ▀    ▓  ██▒ ▓▒▒██▒  ██▒   ▓  ██▒ ▓▒▓██ ▒ ██▒▓█   ▀▒████▄    ▒██    ▒  ██  ▓██▒▓██ ▒ ██▒▓█   ▀    ▓██▒▒██    ▒ ▓██▒   ▒████▄     ██ ▀█   █ ▒██▀ ██▌\n" +
                "▒█░ █ ░█ ▒███   ▒██░    ▒▓█    ▄ ▒██░  ██▒▓██    ▓██░▒███      ▒ ▓██░ ▒░▒██░  ██▒   ▒ ▓██░ ▒░▓██ ░▄█ ▒▒███  ▒██  ▀█▄  ░ ▓██▄   ▓██  ▒██░▓██ ░▄█ ▒▒███      ▒██▒░ ▓██▄   ▒██░   ▒██  ▀█▄  ▓██  ▀█ ██▒░██   █▌\n" +
                "░█░ █ ░█ ▒▓█  ▄ ▒██░    ▒▓▓▄ ▄██▒▒██   ██░▒██    ▒██ ▒▓█  ▄    ░ ▓██▓ ░ ▒██   ██░   ░ ▓██▓ ░ ▒██▀▀█▄  ▒▓█  ▄░██▄▄▄▄██   ▒   ██▒▓▓█  ░██░▒██▀▀█▄  ▒▓█  ▄    ░██░  ▒   ██▒▒██░   ░██▄▄▄▄██ ▓██▒  ▐▌██▒░▓█▄   ▌\n" +
                "░░██▒██▓ ░▒████▒░██████▒▒ ▓███▀ ░░ ████▓▒░▒██▒   ░██▒░▒████▒     ▒██▒ ░ ░ ████▓▒░     ▒██▒ ░ ░██▓ ▒██▒░▒████▒▓█   ▓██▒▒██████▒▒▒▒█████▓ ░██▓ ▒██▒░▒████▒   ░██░▒██████▒▒░██████▒▓█   ▓██▒▒██░   ▓██░░▒████▓ \n" +
                "░ ▓░▒ ▒  ░░ ▒░ ░░ ▒░▓  ░░ ░▒ ▒  ░░ ▒░▒░▒░ ░ ▒░   ░  ░░░ ▒░ ░     ▒ ░░   ░ ▒░▒░▒░      ▒ ░░   ░ ▒▓ ░▒▓░░░ ▒░ ░▒▒   ▓▒█░▒ ▒▓▒ ▒ ░░▒▓▒ ▒ ▒ ░ ▒▓ ░▒▓░░░ ▒░ ░   ░▓  ▒ ▒▓▒ ▒ ░░ ▒░▓  ░▒▒   ▓▒█░░ ▒░   ▒ ▒  ▒▒▓  ▒ \n" +
                "  ▒ ░ ░   ░ ░  ░░ ░ ▒  ░  ░  ▒     ░ ▒ ▒░ ░  ░      ░ ░ ░  ░       ░      ░ ▒ ▒░        ░      ░▒ ░ ▒░ ░ ░  ░ ▒   ▒▒ ░░ ░▒  ░ ░░░▒░ ░ ░   ░▒ ░ ▒░ ░ ░  ░    ▒ ░░ ░▒  ░ ░░ ░ ▒  ░ ▒   ▒▒ ░░ ░░   ░ ▒░ ░ ▒  ▒ \n" +
                "  ░   ░     ░     ░ ░   ░        ░ ░ ░ ▒  ░      ░      ░        ░      ░ ░ ░ ▒       ░        ░░   ░    ░    ░   ▒   ░  ░  ░   ░░░ ░ ░   ░░   ░    ░       ▒ ░░  ░  ░    ░ ░    ░   ▒      ░   ░ ░  ░ ░  ░ \n" +
                "    ░       ░  ░    ░  ░░ ░          ░ ░         ░      ░  ░                ░ ░                 ░        ░  ░     ░  ░      ░     ░        ░        ░  ░    ░        ░      ░  ░     ░  ░         ░    ░    \n" +
                "                        ░                                                                                                                                                                            ░      \n");
    }

    public void leavingIslandShipPrint() {

        System.out.println(" " +
                "               __|__ |___| |\\\n" +
                "                |o__| |___| | \\\n" +
                "                |___| |___| |o \\\n" +
                "               _|___| |___| |__o\\\n" +
                "              /...\\_____|___|____\\_/\n" +
                "              \\   o * o * * o o  /\n" +
                "            ~~~~~~~~~~~~~~~~~~~~~~~~~~");

    }


}
