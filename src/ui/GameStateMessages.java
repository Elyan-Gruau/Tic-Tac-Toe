package ui;

import gameEngine.EGameStates;

import java.util.HashMap;
import java.util.Map;

public final class GameStateMessages {
    private static Map<EGameStates,String> messages = new HashMap<EGameStates,String>();


    public GameStateMessages(){
        messages.put(EGameStates.startingGame,"The game is starting");
        messages.put(EGameStates.endGame,"The game is finished");
        messages.put(EGameStates.p1Choosed,"P1 à choisis");
        messages.put(EGameStates.p2Choosed,"P2 à choisis");
        messages.put(EGameStates.p1Choosing,"P1 choisis");
        messages.put(EGameStates.p2Choosing,"P2 choisis");
    }

    public static String get(EGameStates m){
        return messages.get(m);
    }
}
