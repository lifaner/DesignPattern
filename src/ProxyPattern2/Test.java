package ProxyPattern2;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class Test {

    public static void main(String[] args) {
        try {
            Car car = new Car();
            InvocationHandler h = new TimeHandler(car);
            Moveable x = (Moveable) Proxy.newInstance(Moveable.class, h);
            x.move();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
