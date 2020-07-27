package com.treasureisland.island;

import com.treasureisland.world.*;

public class RumRunnerIsle implements IslandSelector{
    Location location;
//    DirectionEnum direction;

    @Override
    public Location islandLocationSelector(IslandSelector rumRunnerIsle, DirectionEnum direction) {
        location = null;
        if(direction.equals(DirectionEnum.N)){
            location = new RumDistillery();
        }
        if(direction.equals(DirectionEnum.S)){
            location = new CrimsonBeachBar();
        }
        if(direction.equals(DirectionEnum.E)){
            location = new AbandonedDistillery();
        }
        if(direction.equals(DirectionEnum.W)){
            location = new SugarCaneField();
        }
        return location;
    }

//    public Location getLocation() {
//        location = null;
//        if(location.equals(DirectionEnum.N)){
//            location = new RumDistillery();
//        }
//        if(location.equals(DirectionEnum.S)){
//            location = new CrimsonBeachBar();
//        }
//        if(location.equals(DirectionEnum.E)){
//            location = new AbandonedDistillery();
//        }
//        if(location.equals(DirectionEnum.W)){
//            location = new SugarCaneField();
//        }
//
//        return location;
//
//    }


}
