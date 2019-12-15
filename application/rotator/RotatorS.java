package application.rotator;

import application.form.Form;
import application.form.FormJ;
import application.form.FormS;
import application.view.GameField;

public class RotatorS extends RotatorStrategy {

    public RotatorS(GameField gameField, FormS form) {
        super(gameField, form);
    }

    @Override
    public void rotate() {

        switch(form.getFormRotationLevel()){
            case(1):

                if (checkNextPosition(form.getFormRect(Form.RectEnum.c), -1, 0) && checkNextPosition(form.getFormRect(Form.RectEnum.d), -2, -1)){
                    MoveRight(form.getFormRect(Form.RectEnum.a));
                    MoveUp(form.getFormRect(Form.RectEnum.b));
                    MoveLeft(form.getFormRect(Form.RectEnum.c));
                    MoveUp(form.getFormRect(Form.RectEnum.d));
                    MoveLeft(form.getFormRect(Form.RectEnum.d));
                    MoveLeft(form.getFormRect(Form.RectEnum.d));
                    form.changeForm();
                }

                break;

            case(2):
                if (checkNextPosition(form.getFormRect(Form.RectEnum.a), 1, -2) && checkNextPosition(form.getFormRect(Form.RectEnum.b), 0, -1)) {
                    MoveRight(form.getFormRect(Form.RectEnum.a));
                    MoveUp(form.getFormRect(Form.RectEnum.a));
                    MoveUp(form.getFormRect(Form.RectEnum.a));
                    MoveUp(form.getFormRect(Form.RectEnum.b));
                    MoveRight(form.getFormRect(Form.RectEnum.c));
                    MoveDown(form.getFormRect(Form.RectEnum.d));

                    form.changeForm();
                }
                break;

            case(3):
                if (checkNextPosition(form.getFormRect(Form.RectEnum.c), 1, 0 ) && checkNextPosition(form.getFormRect(Form.RectEnum.d), 2, 1)) {
                    MoveLeft(form.getFormRect(Form.RectEnum.a));
                    MoveDown(form.getFormRect(Form.RectEnum.b));
                    MoveRight(form.getFormRect(Form.RectEnum.c));
                    MoveDown(form.getFormRect(Form.RectEnum.d));
                    MoveRight(form.getFormRect(Form.RectEnum.d));
                    MoveRight(form.getFormRect(Form.RectEnum.d));

                    form.changeForm();
                }
                break;

            case(4):
                if (checkNextPosition(form.getFormRect(Form.RectEnum.a), -1, 2) && checkNextPosition(form.getFormRect(Form.RectEnum.b), 0, 1)) {
                    MoveDown(form.getFormRect(Form.RectEnum.a));
                    MoveDown(form.getFormRect(Form.RectEnum.a));
                    MoveLeft(form.getFormRect(Form.RectEnum.a));
                    MoveDown(form.getFormRect(Form.RectEnum.b));
                    MoveLeft(form.getFormRect(Form.RectEnum.c));
                    MoveUp(form.getFormRect(Form.RectEnum.d));

                    form.changeForm();
                }
                break;

        }

    }
}
