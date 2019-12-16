package application;

import application.Random.RandomFormGenerator;
import application.controller.KeyboardHandler;
import application.controller.KeyboardListener;
import application.form.Form;
import application.gameState.GameState;
import application.gameState.GameStateHandler;
import application.view.GameWindow;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;

import java.util.Timer;
import java.util.TimerTask;

public class tetrisApplication extends Application {
    private static GameWindow gameWindow;
    private static KeyboardListener keyboardListener = new KeyboardListener();
    private static RandomFormGenerator formGenerator = new RandomFormGenerator();
    private Timer timer = new Timer();
    private static TimerTask task;
    private static GameStateHandler gameStateHandler = new GameStateHandler();
    private static Form object;
    private static Form nextObject = formGenerator.getRandomForm();
    private static Faller faller;
    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage stage){
        gameWindow = new GameWindow();
        Form a = nextObject;
        gameWindow.addForm(a);
        keyboardListener.moveOnKeyPress(gameWindow.getScene(), a, gameWindow.getGameField(), gameStateHandler);
        object = a;
        nextObject = formGenerator.getRandomForm();
        gameWindow.show(stage);
        faller = new Faller(object, gameWindow.getGameField());
        task = new TimerTask() {
            public void run() {
                Platform.runLater(() -> {

                    if(object.isObjectInBot())
                        gameStateHandler.countdown();
                    else
                        gameStateHandler.resetStateCounter();

                    if (!gameStateHandler.isGame()){
                        gameWindow.setGameOverText();
                        return;
                    }

                    if(gameStateHandler.getNeedForm()){
                        gameWindow.getGameField().RemoveRows(gameWindow.getPane());
                        object = nextObject;
                        gameWindow.addForm(object);
                        nextObject = formGenerator.getRandomForm();
                        keyboardListener.moveOnKeyPress(gameWindow.getScene(), object, gameWindow.getGameField(), gameStateHandler);
                    }

                    faller.fall(object, gameWindow.getGameField(), gameStateHandler);

                });
            }

        };
        timer.schedule(task, 0, 400);

    }
}
