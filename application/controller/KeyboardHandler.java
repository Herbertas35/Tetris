package application.controller;

import application.form.Form;
import application.view.GameField;
import javafx.application.Application;
import javafx.scene.input.KeyEvent;

public class KeyboardHandler {

    public KeyboardHandler(){};



    public void handle(KeyEvent event, Form form, GameField gameField){
        Command command = null;

        switch (event.getCode()){
            case D:
            case RIGHT:
                command = new CommandMoveRight(form, gameField);
                break;

            case A:
            case LEFT:
                command = new CommandMoveLeft(form, gameField);
                break;

            case W:
            case UP:
                command = new CommandMoveUp(form, gameField);
                break;

            case S:
            case DOWN:
                command = new CommandRotateForm(form, gameField);
                break;

        }

        if(command != null) {
            CommandHandler commandHandler = new CommandHandler(command);
            commandHandler.executeCommand();
;
        }
    }

}
