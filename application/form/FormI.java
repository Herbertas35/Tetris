package application.form;


import application.view.GameField;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class FormI extends Form {

    protected FormI(){
        super.name = "i";
        super.color = Color.CYAN;
        super.setRectsSize();
        super.fillRects(super.color);
        setRectsSize();
        setCoordinates();
    }

    @Override
    protected void setCoordinates(){
        super.a.setX(GameField.XMAX / 2);
        super.a.setY(GameField.YMAX - (4 * GameField.SIZE));
        super.b.setX(GameField.XMAX / 2);
        super.b.setY(GameField.YMAX - (3 * GameField.SIZE));
        super.c.setX(GameField.XMAX / 2);
        super.c.setY(GameField.YMAX - (2 * GameField.SIZE));
        super.d.setX(GameField.XMAX / 2);
        super.d.setY(GameField.YMAX - GameField.SIZE);
    }


}
