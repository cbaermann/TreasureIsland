package com.treasureisland.items;

import java.util.*;

public class Vendor {

    private static final Vendor item = new Vendor();

    public Vendor(){

    }

    public static Vendor getInstance(){ return item;}

    private List<Items> vendorItems = new ArrayList(Arrays.asList(
            new Items("Banana", 5, 40),
            new Items("Apple", 3, 35),
            new Items("Rum", 0, 55),
            new Items("Salted meat", 10, 50),
            new Items("Sea biscuits", 2, 35),
            new Items("Ale", 1, 30)
    ));



    public void getAll(){
        for(Items item : vendorItems){
            System.out.println(item.toString());
        }
    }


    public int size() {
        return vendorItems.size();
    }



    public Items findByName(String name) {
        Items result = null;
        for (Items item : vendorItems) {
            if (item.getItemName().equals(name)) {
                result = item;
                break;
            }
        }
        return result;
    }



}