//package application;
//
//import javafx.scene.paint.Color;
//import javafx.scene.shape.Rectangle;
//
//public class formmm {
//    Rectangle a;
//    Rectangle b;
//    Rectangle c;
//    Rectangle d;
//    Color color;
//    private String name;
//    public int form = 1;
//
//    public formmm(Rectangle a, Rectangle b, Rectangle c, Rectangle d) {
//        this.a = a;
//        this.b = b;
//        this.c = c;
//        this.d = d;
//    }
//
//    public formmm(Rectangle a, Rectangle b, Rectangle c, Rectangle d, String name) {
//        this.a = a;
//        this.b = b;
//        this.c = c;
//        this.d = d;
//        this.name = name;
//        System.out.println(name);
//        switch (name) {
//            case "j":
//                color = Color.SLATEGRAY;
//                break;
//            case "l":
//                color = Color.DARKGOLDENROD;
//                break;
//            case "o":
//                color = Color.YELLOW;
//                break;
//            case "s":
//                color = Color.FORESTGREEN;
//                break;
//            case "t":
//                color = Color.CADETBLUE;
//                break;
//            case "z":
//                color = Color.HOTPINK;
//                break;
//            case "i":
//                color = Color.CYAN;
//                break;
//
//        }
//        this.a.setFill(color);
//        this.b.setFill(color);
//        this.c.setFill(color);
//        this.d.setFill(color);
//    }
//
//
//    public String getName() {
//        return name;
//    }
//
//
//    public void changeForm() {
//        if (form != 4) {
//            form++;
//        } else {
//            form = 1;
//        }
//    }
//}
