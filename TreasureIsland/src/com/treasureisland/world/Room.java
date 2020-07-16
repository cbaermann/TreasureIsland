package com.treasureisland.world;

public class Room extends RoomConstruction {
    private int n, s, e, w;

    public Room(String name, String description, int n, int s, int w, int e){
        super(name, description);
        this.n = n;
        this.s = s;
        this.e = e;
        this.w = w;
    }
    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public int getS() {
        return s;
    }

    public void setS(int s) {
        this.s = s;
    }

    public int getE() {
        return e;
    }

    public void setE(int e) {
        this.e = e;
    }

    public int getW() {
        return w;
    }

    public void setW(int w) {
        this.w = w;
    }
}
