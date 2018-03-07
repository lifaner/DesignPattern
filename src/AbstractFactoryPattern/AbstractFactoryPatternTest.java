package AbstractFactoryPattern;


public class AbstractFactoryPatternTest {

    public static void main(String[] args) {

        ColorFactory cf = FactoryProducer.getFactory(ColorFactory.class);
        Color s = cf.getProduct("green");
        s.fill();

        ShapeFactory sf = FactoryProducer.getFactory(ShapeFactory.class);
        Shape circle = sf.getProduct("circle");
        circle.draw();
    }
}
