package application.controller;

import application.form.Form;
import application.gameState.GameStateHandler;
import application.view.GameField;
import javafx.scene.input.KeyEvent;

public class KeyboardHandler {

    private CommandHandler commandHandler = new CommandHandler();

    public KeyboardHandler(){};

    public void handle(KeyEvent event, Form form, GameField gameField, GameStateHandler gameStateHandler){

        switch (event.getCode()){
            case D:
            case RIGHT:
                commandHandler.setCommand(new CommandMoveRight(form, gameField));
                break;

            case A:
            case LEFT:
                commandHandler.setCommand(new CommandMoveLeft(form, gameField));
                break;

            case W:
            case UP:
                commandHandler.setCommand(new CommandMoveUp(form, gameField, gameStateHandler));
                break;

            case S:
            case DOWN:
                commandHandler.setCommand(new CommandRotateForm(form, gameField));
                break;

        }

        if(!commandHandler.isCommandNull()) {
            commandHandler.executeCommand();
;
        }
    }

}
