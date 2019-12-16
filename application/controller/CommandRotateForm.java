package application.controller;

import application.form.*;
import application.rotator.*;
import application.view.GameField;

public class CommandRotateForm implements Command {

    private GameField gameField;
    private Form form;

    public CommandRotateForm (Form form, GameField gameField){
        this.form = form;
        this.gameField = gameField;
    }
    @Override
    public void execute(){
        RotatorContext rotatorContext;

        switch (form.getName()){
            case "j":
                rotatorContext = new RotatorContext(new RotatorJ(gameField, (FormJ) form));
                rotatorContext.executeRotation();
                break;

            case "i":
                rotatorContext = new RotatorContext(new RotatorI(gameField, (FormI) form));
                rotatorContext.executeRotation();
                break;

            case "l":
                rotatorContext = new RotatorContext(new RotatorL(gameField, (FormL) form));
                rotatorContext.executeRotation();
                break;

            case "o":
                rotatorContext = new RotatorContext(new RotatorO(gameField, (FormO) form));
                rotatorContext.executeRotation();
                break;

            case "s":
                rotatorContext = new RotatorContext(new RotatorS(gameField, (FormS) form));
                rotatorContext.executeRotation();
                break;

            case "t":
                rotatorContext = new RotatorContext(new RotatorT(gameField, (FormT) form));
                rotatorContext.executeRotation();
                break;

            case "z":
                rotatorContext = new RotatorContext(new RotatorZ(gameField, (FormZ) form));
                rotatorContext.executeRotation();
                break;


        }

    }


}

