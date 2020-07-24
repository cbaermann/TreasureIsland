package com.treasureisland.items;

public class Items {
    public String itemName;
    public Integer healthValue;
    public Integer cost;

    private static final Items item = new Items();

    private Items(){

    }

    public static Items getInstance(){ return item;}

    public Items(String itemName, Integer healthValue, Integer cost){
        setItemName(itemName);
        setHealthValue(healthValue);
        setCost(cost);
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Integer getHealthValue() {
        return healthValue;
    }

    public void setHealthValue(Integer healthValue) {
        this.healthValue = healthValue;
    }

    public Integer getCost(){
        return cost;
    }

    public void setCost(Integer cost){
        this.cost = cost;
    }

    @Override
    public String toString() {
        return " Item = " + itemName + ", Health Gained = " + healthValue + ", cost = " + cost + " gold " +
                "";
    }


}
