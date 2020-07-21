package com.treasureisland.world;

import org.junit.Test;

import static org.junit.Assert.*;

public class SugarCaneFieldTest {

    @Test
    public void getLocationName() {


        // Arrange
        var sugarCaneField = new SugarCaneField();

        // Act
        var expected = "Sugar cane field";
        var actual = sugarCaneField.getLocationName();

        // Assert
        assertEquals(expected, actual);
    }
}