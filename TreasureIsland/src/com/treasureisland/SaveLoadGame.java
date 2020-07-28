package com.treasureisland;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;

public class SaveLoadGame {
    static TreasureIslandGameplay treasureIslandGameplay = TreasureIslandGameplay.getInstance();

    public static void saveGame(){
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("TreasureIsland.sav");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(treasureIslandGameplay);
            objectOutputStream.flush();
            objectOutputStream.close();
            System.out.println("Game saved\n");
        }
        catch(Exception e){
            System.out.println(Arrays.toString(e.getStackTrace()));
        }
    }

    static void loadGame(){
        try{
            FileInputStream fileInputStream = new FileInputStream("TreasureIsland.sav");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            treasureIslandGameplay = (TreasureIslandGameplay) objectInputStream.readObject();
            objectInputStream.close();
            System.out.println("Game loaded");
        }
        catch(Exception e){
            System.out.println(Arrays.toString(e.getStackTrace()));
        }

    }
}
