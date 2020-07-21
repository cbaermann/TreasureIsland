package com.treasureisland.world;

import com.treasureisland.TreasureIslandGameScanner;
import org.junit.Assert;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

import static org.junit.Assert.*;

public class RumDistilleryTest {

    @org.junit.Test
    public void getLocationName() {
        RumDistillery test1 = new RumDistillery();
        String expected = "Rum Distillery";
       var actual = test1.getLocationName();
        assertEquals(expected, actual);
    }

    @org.junit.Test
    public void talkToNPC() throws IOException, InterruptedException {
        // Arrange
        RumDistillery test2 = new RumDistillery();

        // Act
        test2.talkToNPC();
        int expected = 12;

        // Assert

    }

    @org.junit.Test
    //_Scenario_ExpectedBehavior
    public void lookAroundLocation() throws IOException, InterruptedException {
        //Arrange
        RumDistillery rumdistillery = new RumDistillery();

        //Act
        rumdistillery.lookAroundLocation();

        // Assert

    }

    @org.junit.Test
    public void investigateArea() {

        //Arrange
        RumDistillery rumdistillery = new RumDistillery();

        //Act
        rumdistillery.investigateArea();

        // Assert
    }
}