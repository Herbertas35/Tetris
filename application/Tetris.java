package application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Timer;
import java.util.TimerTask;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Tetris extends Application {
    // The variables
    public static final int MOVE = 25;
    public static final int SIZE = 25;
    public static int XMAX = SIZE * 12;
    public static int YMAX = SIZE * 24;
    public static int[][] MESH = new int[XMAX / SIZE][YMAX / SIZE];
    private static Pane group = new Pane();
    private static formmm object;
    private static Scene scene = new Scene(group, XMAX + 150, YMAX);
    public static int score = 0;
    private static int bot = 0; // todo change name from top to bottom (DONE)
    private static boolean game = true;
    private static formmm nextObj = Controller.makeRect();
    private static int linesNo = 0;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        for (int[] a : MESH) {
            Arrays.fill(a, 0);
        }
        // Creating field objects
        Line line = new Line(XMAX, 0, XMAX, YMAX);
        Text scoretext = new Text("Score: ");
        scoretext.setStyle("-fx-font: 20 arial;");
        scoretext.setY(50);
        scoretext.setX(XMAX + 5);
        Text level = new Text("Lines: ");
        level.setStyle("-fx-font: 20 arial;");
        level.setY(100);
        level.setX(XMAX + 5);
        level.setFill(Color.GREEN);
        group.getChildren().addAll(scoretext, line, level);

        formmm a = nextObj;
        group.getChildren().addAll(a.a, a.b, a.c, a.d);
        moveOnKeyPress(a);
        object = a;
        nextObj = Controller.makeRect();
        stage.setScene(scene);
        stage.setTitle("T E T R I S");
        stage.show();

        Timer fall = new Timer();
        TimerTask task = new TimerTask() {
            public void run() {
                Platform.runLater(() -> {
                    // todo change 0 to YMAX - SIZE (Done)
                    if (object.a.getY() == YMAX - SIZE || object.b.getY() == YMAX - SIZE || object.c.getY() == YMAX - SIZE
                            || object.d.getY() == YMAX - SIZE)
                        bot++;
                    else
                        bot = 0;

                    if (bot == 2) {
                        // GAME OVER
                        Text over = new Text("GAME OVER");
                        over.setFill(Color.RED);
                        over.setStyle("-fx-font: 70 arial;");
                        over.setY(250);
                        over.setX(10);
                        group.getChildren().add(over);
                        game = false;
                    }
                    // Exit after waiting
                    if (bot == 15) {
                        System.exit(0);

                    }

                    if (game) {
                        MoveUp(object); // todo must be move up  (DONE)
                        scoretext.setText("Score: " + score);
                        level.setText("Lines: " + linesNo);
                    }
                });
            }
        };
        fall.schedule(task, 0, 400);
    }

    private void moveOnKeyPress(formmm form) {
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                switch (event.getCode()) {
                    case D:
                    case RIGHT:
                        Controller.MoveRight(form);
                        break;
                    case S:
                    case DOWN:
                        MoveTurn(form); // todo after changes S meaning should be rotate form /Turn form (DONE)
                        break;
                    case A:
                    case LEFT:
                        Controller.MoveLeft(form);
                        break;
                    case W:
                    case UP:
                        MoveUp(form); // todo after changes W or UP meaning should be MoveUp (DONE)
                        break;
                    case ESCAPE:
                        game = false;
                        System.exit(0);
                }
            }
        });
    }

    // todo Implemented with strategyContext (DONE)
    private void MoveTurn(formmm form) {
        int f = form.form;
        Rectangle a = form.a;
        Rectangle b = form.b;
        Rectangle c = form.c;
        Rectangle d = form.d;
        // todo update new algorithm for rotation of forms
        switch (form.getName()) {
            case "j":
                if (f == 1 && cB(a, 1, 0) && cB(d, -1, -2)) {
                    MoveRight(form.a);
                    MoveDown(form.b);
                    MoveLeft(form.c);
                    MoveUp(form.d);
                    MoveLeft(form.d);
                    MoveLeft(form.d);

                    form.changeForm();
                    break;
                }
                if (f == 2 && cB(a, 1, -1) && cB(b, 2, 0)) {
                    MoveRight(form.a);
                    MoveUp(form.a);
                    MoveRight(form.b);
                    MoveRight(form.b);
                    MoveRight(form.c);
                    MoveDown(form.c);
                    MoveDown(form.d);
                    MoveDown(form.d);

                    form.changeForm();
                    break;
                }
                if (f == 3 && cB(a, -1, -1) && cB(b, 0, -2)) {
                    MoveUp(form.a);
                    MoveLeft(form.a);
                    MoveUp(form.b);
                    MoveUp(form.b);
                    MoveRight(form.c);
                    MoveUp(form.c);
                    MoveRight(form.d);
                    MoveRight(form.d);

                    form.changeForm();
                    break;
                }
                if (f == 4 && cB(a, -1, 2) && cB(b, -2, 1) && cB(c, -1, 0)) {
                    MoveDown(form.a);
                    MoveDown(form.a);
                    MoveLeft(form.a);
                    MoveLeft(form.b);
                    MoveLeft(form.b);
                    MoveDown(form.b);
                    MoveLeft(form.c);
                    MoveUp(form.d);

                    form.changeForm();
                    break;
                }
                break;
            case "l":
                if (f == 1 && cB(a, 0, 1) && cB(c, -2, -1) && cB(d, -1, -2)) {
                    MoveDown(form.a);
                    MoveLeft(form.b);
                    MoveLeft(form.c);
                    MoveLeft(form.c);
                    MoveUp(form.c);
                    MoveUp(form.d);
                    MoveUp(form.d);
                    MoveLeft(form.d);

                    form.changeForm();
                    break;
                }
                if (f == 2 && cB(a, 2, 0) && cB(b, 1, 1)) {
                    MoveRight(form.a);
                    MoveRight(form.a);
                    MoveRight(form.b);
                    MoveDown(form.b);
                    MoveDown(form.c);
                    MoveDown(form.c);
                    MoveLeft(form.d);
                    MoveDown(form.d);

                    form.changeForm();
                    break;
                }
                if (f == 3 && cB(a, -2, 0) && cB(b, 1, -1)) {
                    MoveUp(form.a);
                    MoveUp(form.a);
                    MoveRight(form.b);
                    MoveUp(form.b);
                    MoveRight(form.c);
                    MoveRight(form.c);
                    MoveDown(form.d);
                    MoveRight(form.d);

                    form.changeForm();
                    break;
                }
                if (f == 4 && cB(a, -2, 1) && cB(b, -1, 0)) {
                    MoveLeft(form.a);
                    MoveLeft(form.a);
                    MoveDown(form.a);
                    MoveLeft(form.b);
                    MoveUp(form.c);
                    MoveRight(form.d);

                    form.changeForm();
                    break;
                }
                break;
            case "o":
                if( f == 1 && cB(b, 1, 0) && cB(d, 1, 0)){
                    MoveRight(form.a);
                    MoveRight(form.b);
                    MoveRight(form.c);
                    MoveRight(form.d);

                    form.changeForm();
                    break;
                }
                if( f == 2 && cB(a, 0,  -1) && cB(b, 0, -1)){
                    MoveUp(form.a);
                    MoveUp(form.b);
                    MoveUp(form.c);
                    MoveUp(form.d);

                    form.changeForm();
                    break;
                }
                if( f == 3 && cB(a, -1, 0) && cB(c, -1, 0)){
                    MoveLeft(form.a);
                    MoveLeft(form.b);
                    MoveLeft(form.c);
                    MoveLeft(form.d);

                    form.changeForm();
                    break;
                }
                if( f == 4 && cB(c, 0, 1) && cB(d, 0, 1) ){
                    MoveDown(form.a);
                    MoveDown(form.b);
                    MoveDown(form.c);
                    MoveDown(form.d);

                    form.changeForm();
                    break;
                }

                break;
            case "s":
                if (f == 1 && cB(c, -1, 0) && cB(d, -2, -1)) {
                    MoveRight(form.a);
                    MoveUp(form.b);
                    MoveLeft(form.c);
                    MoveUp(form.d);
                    MoveLeft(form.d);
                    MoveLeft(form.d);

                    form.changeForm();
                    break;
                }
                if (f == 2 && cB(a, 1, -2) && cB(b, 0, -1)) {
                    MoveRight(form.a);
                    MoveUp(form.a);
                    MoveUp(form.a);
                    MoveUp(form.b);
                    MoveRight(form.c);
                    MoveDown(form.d);

                    form.changeForm();
                    break;
                }
                if (f == 3 && cB(c, 1, 0) && cB(d, 2, 1)) {
                    MoveLeft(form.a);
                    MoveDown(form.b);
                    MoveRight(form.c);
                    MoveDown(form.d);
                    MoveRight(form.d);
                    MoveRight(form.d);

                    form.changeForm();
                    break;
                }
                if (f == 4 && cB(a, -1, 2) && cB(b, 0, 1)) {
                    MoveDown(form.a);
                    MoveDown(form.a);
                    MoveLeft(form.a);
                    MoveDown(form.b);
                    MoveLeft(form.c);
                    MoveUp(form.d);

                    form.changeForm();
                    break;
                }
                break;
            case "t":
                if (f == 1 && cB(b, 2, 0) && cB(c, 1, 0) && cB(d, 0, -2)) {
                    MoveRight(form.b);
                    MoveRight(form.b);
                    MoveRight(form.c);
                    MoveUp(form.c);
                    MoveUp(form.d);
                    MoveUp(form.d);

                    form.changeForm();
                    break;
                }
                if (f == 2 && cB(b, 0, -2) && cB(c, -1, -1) && cB(d, -2, 0)) {
                    MoveUp(form.b);
                    MoveUp(form.b);
                    MoveUp(form.c);
                    MoveLeft(form.c);
                    MoveLeft(form.d);
                    MoveLeft(form.d);

                    form.changeForm();
                    break;
                }
                if (f == 3 && cB(b, -2, 0) && cB(c, -1, 1) && cB(d, 0, 2)) {
                    MoveLeft(form.b);
                    MoveLeft(form.b);
                    MoveLeft(form.c);
                    MoveDown(form.c);
                    MoveDown(form.d);
                    MoveDown(form.d);

                    form.changeForm();
                    break;
                }
                if (f == 4 && cB(b, 0, -2) && cB(c, 1, 1) && cB(d, 2, 0)) {
                    MoveDown(form.b);
                    MoveDown(form.b);
                    MoveDown(form.c);
                    MoveRight(form.c);
                    MoveRight(form.d);
                    MoveRight(form.d);

                    form.changeForm();
                    break;
                }
                break;
            case "z":
                if (f == 1 && cB(c, 1, -1) && cB(d, 0, -2)) {
                    MoveDown(form.a);
                    MoveRight(form.a);
                    MoveRight(form.c);
                    MoveUp(form.c);
                    MoveUp(form.d);
                    MoveUp(form.d);

                    form.changeForm();
                    break;
                }
                if (f == 2 && cB(c, -1, -1) && cB(d, -2, 0)) {
                    MoveRight(form.a);
                    MoveUp(form.a);
                    MoveLeft(form.c);
                    MoveUp(form.c);
                    MoveLeft(form.d);
                    MoveLeft(form.d);

                    form.changeForm();
                    break;
                }
                if (f == 3 && cB(a, -1, -1) && cB(d, 0, 2)) {
                    MoveUp(form.a);
                    MoveLeft(form.a);
                    MoveDown(form.c);
                    MoveLeft(form.c);
                    MoveDown(form.d);
                    MoveDown(form.d);

                    form.changeForm();
                    break;
                }
                if (f == 4 && cB(c, 1, 1) && cB(d, 2, 0)) {
                    MoveLeft(form.a);
                    MoveDown(form.a);
                    MoveDown(form.c);
                    MoveRight(form.c);
                    MoveRight(form.d);
                    MoveRight(form.d);

                    form.changeForm();
                    break;
                }
                break;
            case "i":
                if (f == 1 && cB(a, 1, 3) && cB(c, -1, 1) && cB(d, -2, 0)) {
                    MoveRight(form.a);
                    MoveDown(form.a);
                    MoveDown(form.a);
                    MoveDown(form.a);
                    MoveDown(form.b);
                    MoveDown(form.b);
                    MoveLeft(form.c);
                    MoveDown(form.c);
                    MoveLeft(form.d);
                    MoveLeft(form.d);

                    form.changeForm();
                    break;
                }
                if (f == 2 && cB(b, 0, -1) && cB(c, 1, -2) && cB(d, 2, -3)) {
                    MoveLeft(form.a);
                    MoveUp(form.b);
                    MoveUp(form.c);
                    MoveUp(form.c);
                    MoveRight(form.c);
                    MoveUp(form.d);
                    MoveUp(form.d);
                    MoveUp(form.d);
                    MoveRight(form.d);
                    MoveRight(form.d);

                    form.changeForm();
                    break;
                }
                if (f == 3 && cB(a, -1, 0) && cB(c, 1, -2) && cB(d, 2, -3)) {
                    MoveLeft(form.a);
                    MoveDown(form.b);
                    MoveRight(form.c);
                    MoveDown(form.c);
                    MoveDown(form.c);
                    MoveRight(form.d);
                    MoveRight(form.d);
                    MoveDown(form.d);
                    MoveDown(form.d);
                    MoveDown(form.d);

                    form.changeForm();
                    break;
                }
                if (f == 4 && cB(a, 1, -3) && cB(b, 0, -2) && cB(c, -1, -1)) {
                    MoveUp(form.a);
                    MoveUp(form.a);
                    MoveUp(form.a);
                    MoveRight(form.a);
                    MoveUp(form.b);
                    MoveUp(form.b);
                    MoveUp(form.c);
                    MoveLeft(form.c);
                    MoveLeft(form.d);
                    MoveLeft(form.d);
                    form.changeForm();
                    break;
                }
                break;
        }
    }

    // todo Implemented in Rotator Strategy (DONE)
    private boolean cB(Rectangle rect, int x, int y) {
        boolean xb = false;
        boolean yb = false;
        if (x >= 0)
            xb = rect.getX() + x * MOVE <= XMAX - SIZE;
        if (x < 0)
            xb = rect.getX() + x * MOVE >= 0;
        if (y >= 0)
            yb = rect.getY() - y * MOVE > 0;
        if (y < 0)
            yb = rect.getY() + y * MOVE < YMAX;
        return xb && yb && MESH[((int) rect.getX() / SIZE) + x][((int) rect.getY() / SIZE) + y] == 0;
    }



    private void RemoveRows(Pane pane) {
        ArrayList<Node> rects = new ArrayList<Node>();
        ArrayList<Integer> lines = new ArrayList<Integer>();
        ArrayList<Node> newrects = new ArrayList<Node>();
        int full = 0;

        // checking full lines
        for (int i = 0; i < MESH[0].length; i++) {
            for (int j = 0; j < MESH.length; j++) {
                if (MESH[j][i] == 1)
                    full++;
            }
            if (full == MESH.length)
                lines.add(i + lines.size());
            full = 0;
        }
        if (lines.size() > 0)
            do {
                // getting all rectangles of pane
                for (Node node : pane.getChildren()) {
                    if (node instanceof Rectangle)
                        rects.add(node);
                }
                score += 50;
                linesNo++;

                // removing all cleared line rectangles
                for (Node node : rects) {
                    Rectangle a = (Rectangle) node;
                    if (a.getY() == lines.get(0) * SIZE) {
                        MESH[(int) a.getX() / SIZE][(int) a.getY() / SIZE] = 0;
                        pane.getChildren().remove(node);
                    } else
                        newrects.add(node);
                }

                // clearing full line rects
                for (Node node : newrects) {
                    Rectangle a = (Rectangle) node;
                    if (a.getY() > lines.get(0) * SIZE) {
                        MESH[(int) a.getX() / SIZE][(int) a.getY() / SIZE] = 0;
                        a.setY(a.getY() - SIZE);
                    }
                }
                lines.remove(0);
                rects.clear();
                newrects.clear();
                // adding rects from pane
                for (Node node : pane.getChildren()) {
                    if (node instanceof Rectangle)
                        rects.add(node);
                }
                // updating mesh
                for (Node node : rects) {
                    Rectangle a = (Rectangle) node;
                    try {
                        MESH[(int) a.getX() / SIZE][(int) a.getY() / SIZE] = 1;
                    } catch (ArrayIndexOutOfBoundsException e) {
                    }
                }
                rects.clear();
            } while (lines.size() > 0);
    }
    // todo implememnted in rotator Strategy (DONE)
    private void MoveDown(Rectangle rect) {
        if (rect.getY() + MOVE < YMAX)
            rect.setY(rect.getY() + MOVE);

    }

    private void MoveRight(Rectangle rect) {
        if (rect.getX() + MOVE <= XMAX - SIZE)
            rect.setX(rect.getX() + MOVE);
    }

    private void MoveLeft(Rectangle rect) {
        if (rect.getX() - MOVE >= 0)
            rect.setX(rect.getX() - MOVE);
    }

    private void MoveUp(Rectangle rect) {
        if (rect.getY() - MOVE > 0)
            rect.setY(rect.getY() - MOVE);
    }

    private void MoveUp(formmm form) {

        if (form.a.getY() ==  0 || form.b.getY() ==  0 || form.c.getY() ==  0
                || form.d.getY() == 0 || moveA(form) || moveB(form) || moveC(form) || moveD(form)) {
            MESH[(int) form.a.getX() / SIZE][(int) form.a.getY() / SIZE] = 1;
            MESH[(int) form.b.getX() / SIZE][(int) form.b.getY() / SIZE] = 1;
            MESH[(int) form.c.getX() / SIZE][(int) form.c.getY() / SIZE] = 1;
            MESH[(int) form.d.getX() / SIZE][(int) form.d.getY() / SIZE] = 1;
            RemoveRows(group);

            formmm a = nextObj;
            nextObj = Controller.makeRect();
            object = a;
            group.getChildren().addAll(a.a, a.b, a.c, a.d);
            moveOnKeyPress(a);
        }

        if (form.a.getY() - MOVE >= 0 && form.b.getY() - MOVE >= 0 && form.c.getY() - MOVE >= 0
                && form.d.getY() - MOVE >= 0) {
            int movea = MESH[(int) form.a.getX() / SIZE][((int) form.a.getY() / SIZE) - 1];
            int moveb = MESH[(int) form.b.getX() / SIZE][((int) form.b.getY() / SIZE) - 1];
            int movec = MESH[(int) form.c.getX() / SIZE][((int) form.c.getY() / SIZE) - 1];
            int moved = MESH[(int) form.d.getX() / SIZE][((int) form.d.getY() / SIZE) - 1];
            if (movea == 0 && movea == moveb && moveb == movec && movec == moved) {
                form.a.setY(form.a.getY() - MOVE);
                form.b.setY(form.b.getY() - MOVE);
                form.c.setY(form.c.getY() - MOVE);
                form.d.setY(form.d.getY() - MOVE);
            }
        }
    }


    private boolean moveA(formmm form) {
        return (MESH[(int) form.a.getX() / SIZE][((int) form.a.getY() / SIZE) - 1] == 1);
    }

    private boolean moveB(formmm form) {
        return (MESH[(int) form.b.getX() / SIZE][((int) form.b.getY() / SIZE) - 1] == 1);
    }

    private boolean moveC(formmm form) {
        return (MESH[(int) form.c.getX() / SIZE][((int) form.c.getY() / SIZE) - 1] == 1);
    }


    private boolean moveD(formmm form) {
        return (MESH[(int) form.d.getX() / SIZE][((int) form.d.getY() / SIZE) - 1] == 1);
    }



}


