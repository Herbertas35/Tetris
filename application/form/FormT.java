package application.form;


import application.view.GameField;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class FormT extends Form {

    protected FormT(){
        super.name = "t";
        super.color = Color.CADETBLUE;
        super.fillRects(super.color);
        setRectsSize();
        setCoordinates();

    }

    protected void setCoordinates(){
        super.a.setX(GameField.XMAX / 2);
        super.a.setY(GameField.YMAX - (2 * GameField.SIZE));
        super.b.setX(GameField.XMAX / 2 - GameField.SIZE);
        super.b.setY(GameField.YMAX - GameField.SIZE);
        super.c.setX(GameField.XMAX / 2);
        super.c.setY(GameField.YMAX - GameField.SIZE);
        super.d.setX(GameField.XMAX / 2 + GameField.SIZE);
        super.d.setY(GameField.YMAX - GameField.SIZE);
    }
}
