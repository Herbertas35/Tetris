package application.controller;

import application.form.Form;
import application.gameState.GameState;
import application.gameState.GameStateHandler;
import application.view.GameField;

public class CommandMoveUp implements Command {

    private GameField gameField;
    private GameState gameState;
    private int move = GameField.MOVE;
    private Form form;

    public CommandMoveUp(Form form, GameField gameField) {
        this.gameField = gameField;
        this.form = form;
    }

    @Override
    public void execute() {
        moveUp();
    }



    public void moveUp() {

        if (checkEnd()){
            gameState.setNeedForm();
        }
        if (checkFieldBorder() && checkFieldUpPosition()) {
            form.moveFormUp();
        }
    }


    private boolean checkFieldBorder() {
        return (form.getFormRect(Form.RectEnum.a).getY() - move >= 0) &&
                (form.getFormRect(Form.RectEnum.a).getY() - move >= 0) &&
                (form.getFormRect(Form.RectEnum.a).getY() - move >= 0) &&
                (form.getFormRect(Form.RectEnum.a).getY() - move >= 0);
    }

    private boolean checkFieldUpPosition() {
        return !((gameField.getMeshCoordinateState((int) (form.getFormRect(Form.RectEnum.a).getX()) / move, (int) ((form.getFormRect(Form.RectEnum.a).getY() - move) / move))) ||
                (gameField.getMeshCoordinateState((int) (form.getFormRect(Form.RectEnum.b).getX()) / move, (int) ((form.getFormRect(Form.RectEnum.b).getY() - move) / move))) ||
                (gameField.getMeshCoordinateState((int) (form.getFormRect(Form.RectEnum.c).getX()) / move, (int) ((form.getFormRect(Form.RectEnum.c).getY() - move) / move))) ||
                (gameField.getMeshCoordinateState((int) (form.getFormRect(Form.RectEnum.d).getX()) / move, (int) ((form.getFormRect(Form.RectEnum.d).getY() - move) / move))));

    }

    private boolean checkEnd(){

        return  (form.getFormRect(Form.RectEnum.a).getY() ==  0 ||
                form.getFormRect(Form.RectEnum.b).getY() ==  0 ||
                form.getFormRect(Form.RectEnum.c).getY() ==  0 ||
                form.getFormRect(Form.RectEnum.d).getY() ==  0 ||
                gameField.getMeshCoordinateState((int)(form.getFormRect(Form.RectEnum.a).getX()) / move,  (int)(form.getFormRect(Form.RectEnum.a).getX() / move) - 1) ||
                gameField.getMeshCoordinateState((int)(form.getFormRect(Form.RectEnum.b).getX()) / move,  (int)(form.getFormRect(Form.RectEnum.b).getX() / move) - 1) ||
                gameField.getMeshCoordinateState((int)(form.getFormRect(Form.RectEnum.c).getX()) / move,  (int)(form.getFormRect(Form.RectEnum.c).getX() / move) - 1) ||
                gameField.getMeshCoordinateState((int)(form.getFormRect(Form.RectEnum.d).getX()) / move,  (int)(form.getFormRect(Form.RectEnum.d).getX() / move) - 1));

    }

}