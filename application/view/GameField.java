package application.view;

import application.form.Form;
import application.gameState.GameState;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Mesh;
import javafx.scene.shape.Rectangle;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class GameField {
    public static final int MOVE = 25;
    public static final int SIZE = 25;
    public static final int RECT_SIZE = 24;
    public static final int XMAX = SIZE * 12;
    public static int YMAX = SIZE * 24;
    public static int[][] MESH = new int[XMAX / SIZE][YMAX / SIZE];
//    GameState gameState = new Game;

    public GameField(){
        clearMesh();

    };

    private void clearMesh(){
        for (int[] a : MESH){
            Arrays.fill(a, 0);
        }
    }

    private int[][] getMESH(){
        return  MESH;
    }

    public boolean getMeshCoordinateState(int x, int y){
        if ((x >= XMAX/SIZE) || (x < 0)){
            return true;
        }
        if ((y > YMAX/SIZE) || (y < 0)){
            return true;
        }

        return MESH[x][y] != 0;
    }

    private void setMeshCoordinate(int x, int y){
        if ((x >= XMAX/SIZE) || (x < 0)){
            return;
        }
        if ((y >= YMAX/SIZE) || (y < 0)){
            return;
        }

        MESH[x][y] = 1;
    }

    public void setFormToMesh(Form form){
        ArrayList<Rectangle> rectangles = form.getAllRects();
        for(Rectangle rect:rectangles){
            setMeshCoordinate((int)rect.getX()/SIZE, (int)rect.getY()/SIZE);
        }
    }

    public void RemoveRows(Pane pane){
        ArrayList<Node> rects = new ArrayList<Node>();
        ArrayList<Integer> lines = new ArrayList<Integer>();
        ArrayList<Node> newrects = new ArrayList<Node>();

        lines = getFullLines(pane);

        if(lines.size() > 0){
            do{
                rects = getAllPaneRects(pane);
                // score here
                newrects = removeFullLineRects(pane, lines);
                MoveDownInGameRects(rects, lines);
                lines.remove(0);
                rects.clear();
                newrects.clear();
                rects = getAllPaneRects(pane);
                UpdateMeshfromPane(pane, rects);
                rects.clear();
            } while(lines.size() > 0);
        }



    }

    private ArrayList<Integer> getFullLines(Pane pane) {
        int full = 0;
        ArrayList<Integer> lines = new ArrayList<Integer>();

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
        return lines;
    }

    private ArrayList<Node> getAllPaneRects(Pane pane){
        ArrayList<Node> rects = new ArrayList<Node>();
        for(Node node : pane.getChildren()){
            if (node instanceof Rectangle)
                rects.add(node);
        }
        return rects;
    }

    // @return value: Rects which stays in game after line remove
    private ArrayList<Node> removeFullLineRects(Pane pane, ArrayList<Integer> fullLines){
        ArrayList<Node> newRects = new ArrayList<Node>();
        ArrayList<Node> rects = getAllPaneRects(pane);
        for (Node node: rects){
            Rectangle a = (Rectangle) node;
            if(a.getY() == fullLines.get(0) * SIZE){
                MESH[(int) a.getX() / SIZE][(int) a.getY() / SIZE] = 0;
                pane.getChildren().remove(node);

            }
            else{
                newRects.add(node);
            }
        }
        return newRects;
    }

    private void MoveDownInGameRects(ArrayList<Node> rects, ArrayList<Integer> lines){

        for (Node node : rects) {
            Rectangle a = (Rectangle) node;
            if (a.getY() > lines.get(0) * SIZE) {
                MESH[(int) a.getX() / SIZE][(int) a.getY() / SIZE] = 0;
                a.setY(a.getY() - SIZE);
            }
        }
    }

    private void UpdateMeshfromPane(Pane pane, ArrayList<Node> rects){
        for (Node node : rects) {
            Rectangle a = (Rectangle) node;
            try {
                MESH[(int) a.getX() / SIZE][(int) a.getY() / SIZE] = 1;
            } catch (ArrayIndexOutOfBoundsException e) {
            }
        }
    }



}
