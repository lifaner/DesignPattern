package AbstractFactoryPattern;

/**
 * 3.Shape产品的子产品
 */
public class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("This is circle!");
    }
}

/**
 * 4.Shape产品的子产品
 */
class Square implements Shape {
    @Override
    public void draw() {
        System.out.println("This is square!");
    }
}
