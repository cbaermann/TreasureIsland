package com.treasureisland.world;

import static org.junit.Assert.*;

public class RumDistilleryTest {

    @org.junit.Test
    public void testGetLocationName() {
        // Arrange

        var test1 = new RumDistillery();
//        System.out.println(test1.getLocationName());
//        OUTPUT: Rum Distillery
//        // Act
        var expected = test1.getLocationName();
        var actual = "Rum Distillery";
//        // Assert
        assertEquals(expected, actual);
    }
}