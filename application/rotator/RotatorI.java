package application.rotator;

import application.form.Form;
import application.form.FormJ;
import application.view.GameField;

public class RotatorI extends RotatorStrategy {

    public RotatorI(GameField gameField, FormJ form) {
        super(gameField, form);
    }

    @Override
    public void rotate() {

        switch(form.getFormRotationLevel()){
            case(1):

                if (checkNextPosition(form.getFormRect(Form.RectEnum.a), 1, 3) && checkNextPosition(form.getFormRect(Form.RectEnum.c), -1, 1) && checkNextPosition(form.getFormRect(Form.RectEnum.d), -2, 0)){
                    MoveRight(form.getFormRect(Form.RectEnum.a));
                    MoveDown(form.getFormRect(Form.RectEnum.a));
                    MoveDown(form.getFormRect(Form.RectEnum.a));
                    MoveDown(form.getFormRect(Form.RectEnum.a));
                    MoveDown(form.getFormRect(Form.RectEnum.b));
                    MoveDown(form.getFormRect(Form.RectEnum.b));
                    MoveLeft(form.getFormRect(Form.RectEnum.c));
                    MoveDown(form.getFormRect(Form.RectEnum.c));
                    MoveLeft(form.getFormRect(Form.RectEnum.d));
                    MoveLeft(form.getFormRect(Form.RectEnum.d));

                    form.changeForm();
                }

                break;

            case(2):
                if (checkNextPosition(form.getFormRect(Form.RectEnum.b), 0, -1) && checkNextPosition(form.getFormRect(Form.RectEnum.c), 1, -2) && checkNextPosition(form.getFormRect(Form.RectEnum.d), 2, -3) ) {
                    MoveLeft(form.getFormRect(Form.RectEnum.a));
                    MoveUp(form.getFormRect(Form.RectEnum.b));
                    MoveUp(form.getFormRect(Form.RectEnum.c));
                    MoveUp(form.getFormRect(Form.RectEnum.c));
                    MoveRight(form.getFormRect(Form.RectEnum.c));
                    MoveUp(form.getFormRect(Form.RectEnum.d));
                    MoveUp(form.getFormRect(Form.RectEnum.d));
                    MoveUp(form.getFormRect(Form.RectEnum.d));
                    MoveRight(form.getFormRect(Form.RectEnum.d));
                    MoveRight(form.getFormRect(Form.RectEnum.d));

                    form.changeForm();
                }
                break;

            case(3):
                if (checkNextPosition(form.getFormRect(Form.RectEnum.a), -1, 0 ) && checkNextPosition(form.getFormRect(Form.RectEnum.c), 1, -2) && checkNextPosition(form.getFormRect(Form.RectEnum.d), 2, -3) ) {
                    MoveLeft(form.getFormRect(Form.RectEnum.a));
                    MoveDown(form.getFormRect(Form.RectEnum.b));
                    MoveRight(form.getFormRect(Form.RectEnum.c));
                    MoveDown(form.getFormRect(Form.RectEnum.c));
                    MoveDown(form.getFormRect(Form.RectEnum.c));
                    MoveRight(form.getFormRect(Form.RectEnum.d));
                    MoveRight(form.getFormRect(Form.RectEnum.d));
                    MoveDown(form.getFormRect(Form.RectEnum.d));
                    MoveDown(form.getFormRect(Form.RectEnum.d));
                    MoveDown(form.getFormRect(Form.RectEnum.d));

                    form.changeForm();
                }
                break;

            case(4):
                if (checkNextPosition(form.getFormRect(Form.RectEnum.a), 1, -3) && checkNextPosition(form.getFormRect(Form.RectEnum.b), 0, -2) && checkNextPosition(form.getFormRect(Form.RectEnum.c), -1, -1)) {
                    MoveUp(form.getFormRect(Form.RectEnum.a));
                    MoveUp(form.getFormRect(Form.RectEnum.a));
                    MoveUp(form.getFormRect(Form.RectEnum.a));
                    MoveRight(form.getFormRect(Form.RectEnum.a));
                    MoveUp(form.getFormRect(Form.RectEnum.b));
                    MoveUp(form.getFormRect(Form.RectEnum.b));
                    MoveUp(form.getFormRect(Form.RectEnum.c));
                    MoveLeft(form.getFormRect(Form.RectEnum.c));
                    MoveLeft(form.getFormRect(Form.RectEnum.d));
                    MoveLeft(form.getFormRect(Form.RectEnum.d));

                    form.changeForm();
                }
                break;

        }

    }
}
