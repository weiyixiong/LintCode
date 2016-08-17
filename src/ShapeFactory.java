/**
 * Created by winney on 16/8/17.
 */
public class ShapeFactory {

    public Shape getShape(String shapeType) {
        if (shapeType.equals("Square")) {
            return new Square();
        } else if (shapeType.equals("Rectangle")) {
            return new Rectangle();
        } else {
            return new Triangle();
        }
    }

    interface Shape {
        void draw();
    }

    public static void O(String log) {
        System.out.println(log);
    }

    class Rectangle implements Shape {
        @Override
        public void draw() {
            O(" ---- ");
            O("|     |");
            O(" ---- ");

        }
    }

    class Square implements Shape {
        @Override
        public void draw() {
            O(" ---- ");
            O("|     |");
            O("|     |");
            O(" ---- ");
        }
    }

    class Triangle implements Shape {
        @Override
        public void draw() {
            O("  /\\ ");
            O(" /  \\ ");
            O("/____\\ ");
        }
    }

}
