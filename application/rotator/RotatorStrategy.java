package application.rotator;

import application.form.Form;
import application.view.GameField;
import javafx.scene.shape.Rectangle;

public abstract class RotatorStrategy {
    protected GameField gameField;
    protected Form form;
    protected int rightBorderCoordinatesX = GameField.XMAX - GameField.SIZE;
    protected int leftBorderCoordinatesX = 0;
    protected int bottomBorderCoordinates = GameField.YMAX;
    protected int topBorderCoordinates = 0;
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
        if (rect.getY() + move < bottomBorderCoordinates)
            rect.setY(rect.getY() + move);

    }

    protected void MoveLeft(Rectangle rect) {
        if (rect.getX() - move >= leftBorderCoordinatesX)
            rect.setX(rect.getX() - move);
    }

    protected void MoveUp(Rectangle rect) {
        if (rect.getY() - move > bottomBorderCoordinates)
            rect.setY(rect.getY() - move);
    }


    protected boolean checkNextPosition(Rectangle rect, int x, int y){
        boolean xb = false;
        boolean yb = false;
        if (x >= 0)
            xb = rect.getX() + x * move <= rightBorderCoordinatesX;
        if (x < 0)
            xb = rect.getX() + x * move >= leftBorderCoordinatesX;
        if (y >= 0)
            yb = rect.getY() - y * move > topBorderCoordinates;
        if (y < 0)
            yb = rect.getY() + y * move < bottomBorderCoordinates;

        boolean nextPosition = gameField.getMeshCoordinateState((int)(rect.getX()/size) + x, (int)(rect.getY()/size) + y);
        return xb && yb && !nextPosition;
    }
}

