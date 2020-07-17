package com.treasureisland;

import java.io.IOException;

;

public class Client {
    public static void main(String[] args) {
//        TreasureIslandGameScanner beginGame = new TreasureIslandGameScanner();
        TreasureIslandGameScanner beginGame = TreasureIslandGameScanner.getInstance();
        beginGame.chosePlayerName();


    }
}