package application.form;


import application.view.GameField;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class FormZ extends Form {

    protected FormZ(){
        super.name = "z";
        super.color = Color.HOTPINK;
        super.fillRects(super.color);
        setRectsSize();
        setCoordinates();
    }

    protected void setCoordinates(){
        super.a.setX(GameField.XMAX / 2 - GameField.SIZE);
        super.a.setY(GameField.YMAX - (2 * GameField.SIZE));
        super.b.setX(GameField.XMAX / 2);
        super.b.setY(GameField.YMAX - (2 * GameField.SIZE));
        super.c.setX(GameField.XMAX / 2);
        super.c.setY(GameField.YMAX - GameField.SIZE);
        super.d.setX(GameField.XMAX / 2 + GameField.SIZE);
        super.d.setY(GameField.YMAX - GameField.SIZE);
    }
}
