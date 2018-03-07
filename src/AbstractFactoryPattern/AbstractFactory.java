package AbstractFactoryPattern;

/**
 * 7.抽象工厂->用来生产产品Shape、Color
 * 每个工厂都会成产功能 getProduct
 */
public abstract class AbstractFactory {
    public abstract <E> E  getProduct(String product);
}

