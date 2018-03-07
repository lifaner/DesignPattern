package FactoryPattern;

/**
 * 4.测试
 */
public class FactoryPatternTest {

    public static void main(String[] args) {
        Shape s1 = ShapeFactory.getShape("circle");
        s1.draw();
        Shape s2 = ShapeFactory.getShape("square");
        s2.draw();

        Circle c = ShapeFactory.getShape(Circle.class);
        c.draw();

        Shape s3 = ShapeFactory.getShape(Square.class);
        s3.draw();
    }
}
