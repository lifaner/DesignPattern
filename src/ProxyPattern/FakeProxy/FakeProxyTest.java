package ProxyPattern.FakeProxy;

import ProxyPattern.Car;
import ProxyPattern.Moveable;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class FakeProxyTest {

    public static void main(String[] args) throws IOException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {

        Car car = new Car();
        InvocationHandler ih = new TimeHandler(car);
        Moveable m = (Moveable) Proxy.newInstance(Moveable.class,ih);
        m.move();

    }
}
