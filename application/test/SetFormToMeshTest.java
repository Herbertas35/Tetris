package application.test;

import application.Random.RandomFormGenerator;
import application.form.Form;
import application.form.FormFactory;
import application.form.FormJ;
import application.view.GameField;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;

public class SetFormToMeshTest {

    public SetFormToMeshTest(){};

    public boolean checkMesh(){
        Form form = new RandomFormGenerator().getRandomForm();
        GameField gameField = new GameField();
        ArrayList<Rectangle> rectangles = form.getAllRects();

        gameField.setFormToMesh(form);
        for (Rectangle rectangle : rectangles) {
            int x = (int) rectangle.getX();
            int y = (int) rectangle.getX();
            if (!gameField.getMeshCoordinateState(x, y))
                return false;
        }

        return true;
    }







}
