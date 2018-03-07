package AbstractFactoryPattern;

/**
 * 5.Color产品的子产品
 */
public class Red implements Color {
    @Override
    public void fill() {
        System.out.println("Color is red!");
    }
}

/**
 * 6.Color产品的子产品
 */
class Green implements Color {
    @Override
    public void fill() {
        System.out.println("Color is green!");
    }
}

/**
 * 7.Color产品的子产品
 */
class Blue implements Color {
    @Override
    public void fill() {
        System.out.println("Color is blue!");
    }
}
