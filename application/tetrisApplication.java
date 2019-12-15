package application;

import application.Random.RandomFormGenerator;
import application.controller.KeyboardHandler;
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
    private static KeyboardHandler keyBoardHandler;
    private static RandomFormGenerator formGenerator;
    Timer timer = new Timer();
    private static TimerTask task;
    private static GameStateHandler gameState;

    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage stage){
        gameWindow = new GameWindow();
        Form form = formGenerator.getRandomForm();
        gameWindow.addForm(form);
        gameWindow.show(stage);
        task = new TimerTask() {
            public void run() {
                Platform.runLater(() -> {

                    if(form.isObjectInBot())
                        gameState.countdown();
                    else
                        gameState.resetStateCounter();

                    if (!gameState.isGame()){
                        gameWindow.setGameOverText();
                        return;
                    }



                });
            }

        };
        timer.schedule(task, 0, 400);

    }
}
