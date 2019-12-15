package application.controller;

import application.form.Form;
import application.form.FormFactory;
import application.view.GameField;
import application.view.GameWindow;

public class CommandMoveRight implements Command {
    private GameField gameField;
    private Form form;
    private final int move = GameField.MOVE;
    private final int size = GameField.SIZE;
    private final int rightBorderCoordinate = GameField.XMAX - GameField.SIZE;



    public CommandMoveRight(Form form, GameField gameField){
        this.gameField = gameField;
        this.form = form;
    }

    @Override
    public void execute(){
        moveRight();
    };

    public void moveRight(){
        if(checkFieldBorder() && checkFieldRightPosition()){
            form.moveFormRight();
        }
    }

    private boolean checkFieldBorder(){
        return (form.getFormRect(Form.RectEnum.a).getX() + move <= rightBorderCoordinate) &&
                (form.getFormRect(Form.RectEnum.a).getX() + move <= rightBorderCoordinate) &&
                (form.getFormRect(Form.RectEnum.a).getX() + move <= rightBorderCoordinate) &&
                (form.getFormRect(Form.RectEnum.a).getX() + move <= rightBorderCoordinate);
    }

    private boolean checkFieldRightPosition(){
        return !((gameField.getMeshCoordinateState((int)(form.getFormRect(Form.RectEnum.a).getX() + move) / move,(int)(form.getFormRect(Form.RectEnum.a).getY() / move))) ||
                (gameField.getMeshCoordinateState((int)(form.getFormRect(Form.RectEnum.b).getX() + move) / move,(int)(form.getFormRect(Form.RectEnum.b).getY() / move))) ||
                (gameField.getMeshCoordinateState((int)(form.getFormRect(Form.RectEnum.c).getX() + move) / move,(int)(form.getFormRect(Form.RectEnum.c).getY() / move))) ||
                       ((gameField.getMeshCoordinateState((int)(form.getFormRect(Form.RectEnum.a).getX() + move) / move, (int)(form.getFormRect(Form.RectEnum.a).getY() / move)))));


    }


}
