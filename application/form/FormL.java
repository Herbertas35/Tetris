package application.form;


import application.view.GameField;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class FormL extends Form {

    protected FormL(){
        super.name = "l";
        super.color = Color.DARKGOLDENROD;
        super.fillRects(super.color);
        setRectsSize();
        setCoordinates();

    }

    @Override
    public void setCoordinates(){
        super.a.setX((GameField.XMAX / 2) - GameField.SIZE);
        super.a.setY(GameField.YMAX - (2 * GameField.SIZE));
        super.b.setX(GameField.XMAX / 2);
        super.b.setY(GameField.YMAX - (2 * GameField.SIZE));
        super.c.setX(GameField.XMAX / 2 + GameField.SIZE);
        super.c.setY(GameField.YMAX - (2 * GameField.SIZE));
        super.d.setX(GameField.XMAX / 2 + GameField.SIZE);
        super.d.setY(GameField.YMAX - GameField.SIZE);
    }
}
