package application.rotator;

import application.form.Form;
import application.view.GameField;
import javafx.scene.shape.Rectangle;

public abstract class RotatorStrategy {
    protected GameField gameField;
    protected Form form;
    protected int rightBorderCoordinatesX = GameField.XMAX - GameField.SIZE;
    protected int leftBorderCoordinatesX = 0;
    protected int bottomBoredCoordinatesY = GameField.YMAX;
    protected int TopBorderCoordinatesY = 0;
    protected int move = GameField.MOVE;
    protected int size = GameField.SIZE;

    public RotatorStrategy(GameField gameField, Form form) {
        this.gameField = gameField;
        this.form = form;
    }

    public abstract void rotate();



    // moving rects of forms
    protected void MoveRight(Rectangle rect) {
        if (rect.getX() + move <= rightBorderCoordinatesX)
            rect.setX(rect.getX() + move);
    }

    protected void MoveDown(Rectangle rect) {
        if (rect.getY() + move < bottomBoredCoordinatesY)
            rect.setY(rect.getY() + move);

    }

    protected void MoveLeft(Rectangle rect) {
        if (rect.getX() - move >= leftBorderCoordinatesX)
            rect.setX(rect.getX() - move);
    }

    protected void MoveUp(Rectangle rect) {
        if (rect.getY() - move > bottomBoredCoordinatesY)
            rect.setY(rect.getY() - move);
    }


    protected boolean checkNextPosition(Rectangle rect, int x, int y){
        boolean xb = false;
        boolean yb = false;
        if (x >= 0)
            xb = rect.getX() + x * move <= leftBorderCoordinatesX;
        if (x < 0)
            xb = rect.getX() + x * move >= 0;
        if (y >= 0)
            yb = rect.getY() - y * move > 0;
        if (y < 0)
            yb = rect.getY() + y * move < bottomBoredCoordinatesY;

        boolean nextPosition = gameField.getMeshCoordinateState((int)(rect.getX()/size) + x, (int)(rect.getY()/size) + y);
        return xb && yb && !nextPosition;
    }
}

