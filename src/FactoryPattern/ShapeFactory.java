package FactoryPattern;

/**
 * 3.生产Shape的工场
 */
public class ShapeFactory {

    /**
     * 只生产Shape下的子产品
     * @param shapeType
     * @return
     */
    public static Shape getShape(String shapeType) {
        if (shapeType == null){
            return null;
        }
        if(shapeType.toLowerCase().equals("circle")){
            return new Circle();
        }else if(shapeType.toLowerCase().equals("square")){
            return new Square();
        }else{
            return null;
        }
    }

    /**
     * 只生产Shape下的子产品
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T extends Shape> T getShape(Class<? extends Shape> clazz) {
        T obj = null;
        try {
            obj = (T) Class.forName(clazz.getName()).newInstance();
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
