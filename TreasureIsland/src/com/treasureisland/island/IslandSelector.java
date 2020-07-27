package com.treasureisland.island;

import com.treasureisland.world.Location;

public interface IslandSelector {

    public Location islandLocationSelector(IslandSelector island, DirectionEnum direction);
}
