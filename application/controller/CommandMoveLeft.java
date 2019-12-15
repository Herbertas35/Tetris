package application.controller;

import application.form.Form;
import application.view.GameField;

public class CommandMoveLeft implements Command {

    private GameField gameField;
    private Form form;
    private final int move = GameField.MOVE;

    public CommandMoveLeft(Form form, GameField gameField){
        this.gameField = gameField;
        this.form = form;
    }

    @Override
    public void execute(){
        moveLeft();
    }


    private void  moveLeft(){
        if (checkFieldBorder() && checkFieldLeftPosition()){
            form.moveFormLeft();
        }
    }

    private boolean checkFieldBorder(){
        int leftBorderCoordinate = 0;
        return (form.getFormRect(Form.RectEnum.a).getX() + move >= leftBorderCoordinate) &&
                (form.getFormRect(Form.RectEnum.a).getX() + move >= leftBorderCoordinate) &&
                (form.getFormRect(Form.RectEnum.a).getX() + move >= leftBorderCoordinate) &&
                (form.getFormRect(Form.RectEnum.a).getX() + move >= leftBorderCoordinate);
    }

    private boolean checkFieldLeftPosition() {
        return !((gameField.getMeshCoordinateState((int) (form.getFormRect(Form.RectEnum.a).getX() - move) / move, (int) (form.getFormRect(Form.RectEnum.a).getY() / move))) ||
                (gameField.getMeshCoordinateState((int) (form.getFormRect(Form.RectEnum.b).getX() - move) / move, (int) (form.getFormRect(Form.RectEnum.b).getY() / move))) ||
                (gameField.getMeshCoordinateState((int) (form.getFormRect(Form.RectEnum.c).getX() - move) / move, (int) (form.getFormRect(Form.RectEnum.c).getY() / move))) ||
                ((gameField.getMeshCoordinateState((int) (form.getFormRect(Form.RectEnum.a).getX() - move) / move, (int) (form.getFormRect(Form.RectEnum.a).getY() / move)))));

    }
}
