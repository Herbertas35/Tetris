package application.view;

import application.controller.KeyboardHandler;
import application.form.Form;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class GameWindow {
    private static Pane group;
    public static GameField gameField;
    private static Line line;
    private static  Scene scene;
    private Text scoreText = new Text();
    private Text lines = new Text();

    public GameWindow(){
        init();
    }

    private void init(){
        group = new Pane();
        scene = new Scene(group, GameField.XMAX + 150, GameField.YMAX);
        gameField = new GameField();
        line = new Line(GameField.XMAX, 0, GameField.XMAX, GameField.YMAX);
        Text scoretext = new Text("Score: ");
        scoretext.setStyle("-fx-font: 20 arial;");
        scoretext.setY(50);
        scoretext.setX(GameField.XMAX + 5);
        Text level = new Text("Lines: ");
        level.setStyle("-fx-font: 20 arial;");
        level.setY(100);
        level.setX(GameField.XMAX + 5);
        level.setFill(Color.GREEN);
        group.getChildren().addAll(scoretext, line, level);

    }

    public void setGameOverText(){
        Text over = new Text("GAME OVER");
        over.setFill(Color.RED);
        over.setStyle("-fx-font: 70 arial;");
        over.setY(250);
        over.setX(10);
        group.getChildren().add(over);

    }

    public void addForm(Form newForm){
        group.getChildren().add(newForm.getFormRect(Form.RectEnum.a));
        group.getChildren().add(newForm.getFormRect(Form.RectEnum.b));
        group.getChildren().add(newForm.getFormRect(Form.RectEnum.c));
        group.getChildren().add(newForm.getFormRect(Form.RectEnum.d));

    }

    public void show(Stage stage){
        stage.setScene(scene);
        stage.setTitle("T E T R I S");
        stage.show();
    }

    public void moveOnKeyPress(){
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {

            }
        });
    }

    public Scene getScene(){return scene;}

    public GameField getGameField() { return gameField;}

    public Pane getPane() { return group;}

    public void setScore(int score){
        scoreText.setText("Score: " + score);
    }

    public void setLines(int level){
        lines.setText("Lines: " + level);
    }

}
