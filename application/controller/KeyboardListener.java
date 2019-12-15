package application.controller;

import application.form.Form;
import application.gameState.GameStateHandler;
import application.view.GameField;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;

public class KeyboardListener {
    private KeyboardHandler keyboardHandler = new KeyboardHandler();

    public void moveOnKeyPress(Scene scene, Form form, GameField gameField, GameStateHandler gameStateHandler){

        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                keyboardHandler.handle(keyEvent, form, gameField, gameStateHandler);

            }
        });
    }
}
