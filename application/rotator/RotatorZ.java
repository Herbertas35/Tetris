package application.rotator;

import application.form.Form;
import application.form.FormJ;
import application.form.FormZ;
import application.view.GameField;

public class RotatorZ extends RotatorStrategy {

    public RotatorZ(GameField gameField, FormZ form) {
        super(gameField, form);
    }

    @Override
    public void rotate() {

        switch(form.getFormRotationLevel()){
            case(1):

                if (checkNextPosition(form.getFormRect(Form.RectEnum.c), 1, -1) && checkNextPosition(form.getFormRect(Form.RectEnum.d), 0, -2)){
                    MoveDown(form.getFormRect(Form.RectEnum.a));
                    MoveRight(form.getFormRect(Form.RectEnum.a));
                    MoveRight(form.getFormRect(Form.RectEnum.c));
                    MoveUp(form.getFormRect(Form.RectEnum.c));
                    MoveUp(form.getFormRect(Form.RectEnum.d));
                    MoveUp(form.getFormRect(Form.RectEnum.d));
                    form.changeForm();
                }

                break;

            case(2):
                if (checkNextPosition(form.getFormRect(Form.RectEnum.c), -1, -1) && checkNextPosition(form.getFormRect(Form.RectEnum.d), -2, 0)) {
                    MoveRight(form.getFormRect(Form.RectEnum.a));
                    MoveUp(form.getFormRect(Form.RectEnum.a));
                    MoveLeft(form.getFormRect(Form.RectEnum.c));
                    MoveUp(form.getFormRect(Form.RectEnum.c));
                    MoveLeft(form.getFormRect(Form.RectEnum.d));
                    MoveLeft(form.getFormRect(Form.RectEnum.d));

                    form.changeForm();
                }
                break;

            case(3):
                if (checkNextPosition(form.getFormRect(Form.RectEnum.a), -1, -1 ) && checkNextPosition(form.getFormRect(Form.RectEnum.d), 0, 2)) {
                    MoveUp(form.getFormRect(Form.RectEnum.a));
                    MoveLeft(form.getFormRect(Form.RectEnum.a));
                    MoveDown(form.getFormRect(Form.RectEnum.c));
                    MoveLeft(form.getFormRect(Form.RectEnum.c));
                    MoveDown(form.getFormRect(Form.RectEnum.d));
                    MoveDown(form.getFormRect(Form.RectEnum.d));

                    form.changeForm();
                }
                break;

            case(4):
                if (checkNextPosition(form.getFormRect(Form.RectEnum.c), 1, 1) && checkNextPosition(form.getFormRect(Form.RectEnum.d), 2, 0)) {
                    MoveLeft(form.getFormRect(Form.RectEnum.a));
                    MoveDown(form.getFormRect(Form.RectEnum.a));
                    MoveDown(form.getFormRect(Form.RectEnum.c));
                    MoveRight(form.getFormRect(Form.RectEnum.c));
                    MoveRight(form.getFormRect(Form.RectEnum.d));
                    MoveRight(form.getFormRect(Form.RectEnum.d));

                    form.changeForm();
                }
                break;

        }

    }
}
