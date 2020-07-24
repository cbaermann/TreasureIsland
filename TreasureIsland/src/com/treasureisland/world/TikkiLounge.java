package com.treasureisland.world;
import com.treasureisland.TreasureIslandGameplay;
import com.treasureisland.player.Player;
import java.io.IOException;

public class TikkiLounge implements Location{

    private final TreasureIslandGameplay game = TreasureIslandGameplay.getInstance();
    private final Player player = Player.getInstance();

    @Override
    public String getLocationName() {
        return "Tikki Lounge";
    }

    @Override
    public void talkToNPC() {
        System.out.println("Talking to a npc Tikki lounge");
        game.storylineProgression("TI.txt", getLocationName(), "SOStart", "SOStop");

    }

    @Override
    public void lookAroundLocation() {
        System.out.println("Looking around Tikki lounge, I ran into Callie ");
        game.storylineProgression("TI.txt", getLocationName(), "CAStart", "CAStop");

    }

    @Override
    public void investigateArea()  {
        System.out.println("Investigating Tikki lounge, I ran into Sam.");
        game.storylineProgression("TI.txt", getLocationName(), "SAMStart", "SAMStop");

    }

    @Override
    public void vendor() {

    }
}
