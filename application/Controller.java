//package application;
//
//
//import application.form.Form;
//import application.form.FormFactory;
//import application.form.FormI;
//import javafx.scene.shape.Rectangle;
//
//public class Controller {
//    // Getting the numbers and the MESH from Tetris
//    public static final int MOVE = Tetris.MOVE;
//    public static final int SIZE = Tetris.SIZE;
//    public static int XMAX = Tetris.XMAX;
//    public static int YMAX = Tetris.YMAX;
//    public static int[][] MESH = Tetris.MESH;
//
//    // todo form movement implemented in form class
//    public static void MoveRight(formmm form) {
//        if (form.a.getX() + MOVE <= XMAX - SIZE && form.b.getX() + MOVE <= XMAX - SIZE
//                && form.c.getX() + MOVE <= XMAX - SIZE && form.d.getX() + MOVE <= XMAX - SIZE) {
//            int movea = MESH[((int) form.a.getX() / SIZE) + 1][((int) form.a.getY() / SIZE)];
//            int moveb = MESH[((int) form.b.getX() / SIZE) + 1][((int) form.b.getY() / SIZE)];
//            int movec = MESH[((int) form.c.getX() / SIZE) + 1][((int) form.c.getY() / SIZE)];
//            int moved = MESH[((int) form.d.getX() / SIZE) + 1][((int) form.d.getY() / SIZE)];
//            if (movea == 0 && movea == moveb && moveb == movec && movec == moved) {
//                form.a.setX(form.a.getX() + MOVE);
//                form.b.setX(form.b.getX() + MOVE);
//                form.c.setX(form.c.getX() + MOVE);
//                form.d.setX(form.d.getX() + MOVE);
//            }
//        }
//    }
//
//    public static void MoveLeft(formmm form) {
//        if (form.a.getX() - MOVE >= 0 && form.b.getX() - MOVE >= 0 && form.c.getX() - MOVE >= 0
//                && form.d.getX() - MOVE >= 0) {
//            int movea = MESH[((int) form.a.getX() / SIZE) - 1][((int) form.a.getY() / SIZE)];
//            int moveb = MESH[((int) form.b.getX() / SIZE) - 1][((int) form.b.getY() / SIZE)];
//            int movec = MESH[((int) form.c.getX() / SIZE) - 1][((int) form.c.getY() / SIZE)];
//            int moved = MESH[((int) form.d.getX() / SIZE) - 1][((int) form.d.getY() / SIZE)];
//            if (movea == 0 && movea == moveb && moveb == movec && movec == moved) {
//                form.a.setX(form.a.getX() - MOVE);
//                form.b.setX(form.b.getX() - MOVE);
//                form.c.setX(form.c.getX() - MOVE);
//                form.d.setX(form.d.getX() - MOVE);
//            }
//        }
//    }
//
//    // todo Change new forms coordinates from top to bottom (Done)
//    public static formmm makeRect() {
//        int block = (int) (Math.random() * 100);
//        String name;
//        Rectangle a = new Rectangle(SIZE-1, SIZE-1), b = new Rectangle(SIZE-1, SIZE-1), c = new Rectangle(SIZE-1, SIZE-1),
//                d = new Rectangle(SIZE-1, SIZE-1);
//        if (block < 15) {
//            a.setX (XMAX / 2 - SIZE);
//            a.setY(YMAX - SIZE);
//            b.setX(XMAX / 2 - SIZE);
//            b.setY(YMAX - SIZE - SIZE);
//            c.setX(XMAX / 2);
//            c.setY(YMAX - SIZE - SIZE);
//            d.setX(XMAX / 2 + SIZE);
//            d.setY(YMAX - SIZE - SIZE);
//            name = "j";
//        } else if (block < 30) {
//            a.setX(XMAX / 2 - SIZE);
//            a.setY(YMAX - SIZE - SIZE);
//            b.setX(XMAX / 2);
//            b.setY(YMAX - SIZE - SIZE);
//            c.setX(XMAX / 2 + SIZE);
//            c.setY(YMAX - SIZE - SIZE);
//            d.setX(XMAX / 2 + SIZE);
//            d.setY(YMAX - SIZE);
//            name = "l";
//        } else if (block < 45) {
//            a.setX(XMAX / 2 - SIZE);
//            a.setY(YMAX - SIZE - SIZE);
//            b.setX(XMAX / 2);
//            b.setY(YMAX - SIZE - SIZE);
//            c.setX(XMAX / 2 - SIZE);
//            c.setY(YMAX - SIZE);
//            d.setX(XMAX / 2);
//            d.setY(YMAX - SIZE);
//            name = "o";
//        } else if (block < 60) {
//            a.setX(XMAX / 2 - SIZE);
//            a.setY(YMAX - SIZE);
//            b.setX(XMAX / 2);
//            b.setY(YMAX - SIZE);
//            c.setX(XMAX / 2);
//            c.setY(YMAX - SIZE - SIZE);
//            d.setX(XMAX / 2 + SIZE);
//            d.setY(YMAX - SIZE - SIZE);
//            name = "s";
//        } else if (block < 75) {
//            a.setX(XMAX / 2);
//            a.setY(YMAX - SIZE - SIZE);
//            b.setX(XMAX / 2 - SIZE);
//            b.setY(YMAX - SIZE);
//            c.setX(XMAX / 2);
//            c.setY(YMAX - SIZE);
//            d.setX(XMAX / 2 + SIZE);
//            d.setY(YMAX - SIZE);
//            name = "t";
//        } else if (block < 90) {
//            a.setX(XMAX / 2 - SIZE);
//            a.setY(YMAX - SIZE - SIZE);
//            b.setX(XMAX / 2);
//            b.setY(YMAX - SIZE - SIZE);
//            c.setX(XMAX / 2);
//            c.setY(YMAX - SIZE);
//            d.setX(XMAX / 2 + SIZE);
//            d.setY(YMAX - SIZE);
//            name = "z";
//        } else {
//            a.setX(XMAX / 2);
//            a.setY(YMAX - SIZE - SIZE - SIZE - SIZE);
//            b.setX(XMAX / 2);
//            b.setY(YMAX - SIZE - SIZE - SIZE);
//            c.setX(XMAX / 2);
//            c.setY(YMAX - SIZE - SIZE);
//            d.setX(XMAX / 2);
//            d.setY(YMAX - SIZE);
//
//            name = "i";
//        }
//        return new formmm(a, b, c, d, name);
//    }
//}
