package AbstractFactoryPattern;

/**
 * Shape工厂 生产shape
 */
public class ShapeFactory extends AbstractFactory {

    public Shape getProduct(String shapeType) {
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
}

/**
 * color工厂 生产color
 */
class ColorFactory extends AbstractFactory{

    public Color getProduct(String color) {
        if(color == null){
            return null;
        }
        if(color.equalsIgnoreCase("RED")){
            return new Red();
        } else if(color.equalsIgnoreCase("GREEN")){
            return new Green();
        } else if(color.equalsIgnoreCase("BLUE")){
            return new Blue();
        }
        return null;
    }

}

class LongFactory {
    public Color getColor(String color) {
        if(color == null){
            return null;
        }
        if(color.equalsIgnoreCase("RED")){
            return new Red();
        } else if(color.equalsIgnoreCase("GREEN")){
            return new Green();
        } else if(color.equalsIgnoreCase("BLUE")){
            return new Blue();
        }
        return null;
    }

}

