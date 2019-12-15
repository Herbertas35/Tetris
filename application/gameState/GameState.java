package application.gameState;

public class GameState {

    public enum GameStateEnum{
        GAME,
        GAME_OVER
    }

    private static boolean needNewForm = false;

    private static GameStateEnum gameState = GameStateEnum.GAME;

    public GameState(){};

    public void setGameState(GameStateEnum state){
        gameState = state;
    }

    public GameStateEnum getGameState(){
        return gameState;
    }

    public void setNeedForm(){
        needNewForm = true;
    }
}

