package application.form;

import application.view.GameField;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public abstract class Form {
    protected Rectangle a, b, c, d;
    protected Color color;
    protected String name;
    private int formRotationLevel = 1;

    public enum RectEnum{
        a,
        b,
        c,
        d
    }
    protected abstract void setCoordinates();

    public void changeForm() {
        if (formRotationLevel != 4) {
            formRotationLevel++;
        } else {
            formRotationLevel = 1;
        }
    }

    public String getName() {
        return name;
    }
    public int getFormRotationLevel() {return formRotationLevel;}

    protected void fillRects(Color color){
        a.setFill(color);
        b.setFill(color);
        c.setFill(color);
        d.setFill(color);

    }


    protected void setRectsSize(){
        a.setWidth(GameField.RECT_SIZE);
        a.setHeight(GameField.RECT_SIZE);
        b.setWidth(GameField.RECT_SIZE);
        b.setHeight(GameField.RECT_SIZE);
        c.setWidth(GameField.RECT_SIZE);
        c.setHeight(GameField.RECT_SIZE);
        d.setWidth(GameField.RECT_SIZE);
        d.setHeight(GameField.RECT_SIZE);

    }

    public Rectangle getFormRect(RectEnum rect){
        switch (rect){
            case a:
                return this.a;
            case b:
                return this.b;
            case c:
                return this.c;
            case d:
                return this.d;

        }
        return null;

    }

    public void moveFormRight(){
        this.a.setX(this.a.getX() + GameField.MOVE);
        this.b.setX(this.a.getX() + GameField.MOVE);
        this.c.setX(this.a.getX() + GameField.MOVE);
        this.d.setX(this.a.getX() + GameField.MOVE);
    }

    public void moveFormLeft(){
        this.a.setX(this.a.getX() - GameField.MOVE);
        this.b.setX(this.a.getX() - GameField.MOVE);
        this.c.setX(this.a.getX() - GameField.MOVE);
        this.d.setX(this.a.getX() - GameField.MOVE);
    }

    public void moveFormUp() {
        this.a.setY(this.a.getY() + GameField.MOVE);
        this.b.setY(this.a.getY() + GameField.MOVE);
        this.c.setY(this.a.getY() + GameField.MOVE);
        this.d.setY(this.a.getY() + GameField.MOVE);
    }

    // possible not needed

    public void moveFormDown() {
        this.a.setY(this.a.getY() - GameField.MOVE);
        this.b.setY(this.a.getY() - GameField.MOVE);
        this.c.setY(this.a.getY() - GameField.MOVE);
        this.d.setY(this.a.getY() - GameField.MOVE);
    }

    public boolean isObjectInBot(){
       return (this.a.getY() == GameField.YMAX - GameField.SIZE ||
               this.b.getY() == GameField.YMAX - GameField.SIZE ||
               this.c.getY() == GameField.YMAX - GameField.SIZE ||
               this.d.getY() == GameField.YMAX - GameField.SIZE);

    }





}