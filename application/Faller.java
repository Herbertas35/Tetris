package application;

import application.form.Form;
import application.gameState.GameState;
import application.gameState.GameStateHandler;
import application.view.GameField;

public class Faller {

    private Form form;
    private GameField gameField;
    private int move = GameField.MOVE;

    public  Faller(Form form, GameField gameField){
        this.form = form;
        this.gameField = gameField;
    }
    public void fall(Form form, GameField gameField, GameStateHandler gameStateHandler){
        if (checkEnd()){
            gameField.setMeshCoordinate((int)form.getFormRect(Form.RectEnum.a).getX() / move, (int)form.getFormRect(Form.RectEnum.a).getY() / move);
            gameField.setMeshCoordinate((int)form.getFormRect(Form.RectEnum.b).getX() / move, (int)form.getFormRect(Form.RectEnum.b).getY() / move);
            gameField.setMeshCoordinate((int)form.getFormRect(Form.RectEnum.c).getX() / move, (int)form.getFormRect(Form.RectEnum.c).getY() / move);
            gameField.setMeshCoordinate((int)form.getFormRect(Form.RectEnum.d).getX() / move, (int)form.getFormRect(Form.RectEnum.d).getY() / move);
            gameStateHandler.setNeedForm(true);
        }

        else if (checkFieldBorder() && checkFieldUpPosition()){
            form.moveFormUp();
        }


    }

    private boolean checkFieldBorder() {
        return (form.getFormRect(Form.RectEnum.a).getY() - move >= 0) &&
                (form.getFormRect(Form.RectEnum.a).getY() - move >= 0) &&
                (form.getFormRect(Form.RectEnum.a).getY() - move >= 0) &&
                (form.getFormRect(Form.RectEnum.a).getY() - move >= 0);
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

        private boolean checkFieldUpPosition() {
            return !((gameField.getMeshCoordinateState((int) (form.getFormRect(Form.RectEnum.a).getX()) / move, (int) (form.getFormRect(Form.RectEnum.a).getY() / move) - 1)) ||
                    (gameField.getMeshCoordinateState((int) (form.getFormRect(Form.RectEnum.b).getX()) / move, (int) (form.getFormRect(Form.RectEnum.b).getY() / move) - 1)) ||
                    (gameField.getMeshCoordinateState((int) (form.getFormRect(Form.RectEnum.c).getX()) / move, (int) (form.getFormRect(Form.RectEnum.c).getY() / move) - 1)) ||
                    (gameField.getMeshCoordinateState((int) (form.getFormRect(Form.RectEnum.d).getX()) / move, (int) (form.getFormRect(Form.RectEnum.d).getY() / move) - 1)));

        }
}
