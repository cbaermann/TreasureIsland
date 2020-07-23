package com.treasureisland.items;

import java.util.ArrayList;
import java.util.Arrays;

public class Vendor{

    ArrayList<Items> vendorItems = new ArrayList(Arrays.asList(
            new Items("Banana", 5, 40),
            new Items("Apple", 3, 35),
            new Items("Rum", 0, 55),
            new Items("Salted meat", 10, 50),
            new Items("Sea biscuits", 2, 35),
            new Items("Ale", 1, 30)
    )) ;



}
