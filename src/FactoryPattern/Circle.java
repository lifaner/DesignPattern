package FactoryPattern;

/**
 * 2.Shape的子产品
 */
public class Circle implements Shape{
    @Override
    public void draw() {
        System.out.println("This is circle!");
    }
}

/**
 * 2.Shape的子产品
 */
class Square implements Shape {
    @Override
    public void draw() {
        System.out.println("This is square!");
    }
}
