package com.treasureisland;

import java.io.IOException;

;

public class Client {
    public static void main(String[] args) throws IOException {
        TreasureIslandGameScanner beginGame = new TreasureIslandGameScanner();
        beginGame.chosePlayerName();
    }
}
