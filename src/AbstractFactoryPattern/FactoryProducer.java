package AbstractFactoryPattern;

/**
 * 9.创建工厂
 * 工厂实例化 根据抽象工厂的子类确定范围
 */
public class FactoryProducer {

    public static AbstractFactory getFactory(String choice){
        if(choice.equalsIgnoreCase("shape")){
            return new ShapeFactory();
        }else if (choice.equalsIgnoreCase("color")){
            return new ColorFactory();
        }
        return null;
    }

    //限制边界为AbstractFactory
    public static <T extends AbstractFactory> T getFactory(Class<? extends AbstractFactory> clazz){
        T obj = null;
        try {
            obj = (T)Class.forName(clazz.getName()).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return obj;
    }
}
