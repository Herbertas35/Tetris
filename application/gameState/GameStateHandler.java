package application.gameState;

public class GameStateHandler {

    private static GameState state = new GameState();
    private static int statecounter = 0;
    private final int gameOverCount = 2;
    private static boolean needNewForm = false;

    public GameStateHandler(){};

    public void countdown(){
        statecounter ++;
        if (statecounter == gameOverCount){
            state.setGameState(GameState.GameStateEnum.GAME_OVER);
            return;
        }
        state.setGameState(GameState.GameStateEnum.GAME);

    }

    public void resetStateCounter(){
        statecounter = 0;
    }

    public boolean isGame(){
        return (state.getGameState() == GameState.GameStateEnum.GAME);
    }

    public void setNeedForm(boolean need){
        needNewForm = need;
    }

    public boolean getNeedForm(){
        return needNewForm;
    }
}
