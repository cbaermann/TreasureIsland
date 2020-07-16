package com.treasureisland.world;

import java.util.ArrayList;

public class Game {
    private ArrayList<Room> map;

    public Game(){
        this.map = new ArrayList<Room>();

        map.add(new Room("Rum Distillary", "Loud noises and the smell of booze fills the air", Direction.NOEXIT, 2, Direction.NOEXIT, 1));
        map.add(new Room("Master Brewers House", "Some storyline stuff", Direction.NOEXIT, Direction.NOEXIT, 0, Direction.NOEXIT));
        map.add(new Room("Cask Room", "I feel something here", 0, Direction.NOEXIT, Direction.NOEXIT, 3));
        map.add(new Room("Docks", "Rum is flowing and goods are being traded, everything seems normal here.", Direction.NOEXIT, Direction.NOEXIT, 2, Direction.NOEXIT));

    }
}
