package ProxyPattern.JDKProxy;

import ProxyPattern.Car;
import ProxyPattern.Moveable;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JDKProxyTest {

    /**
     * 测试类
     * @param args
     */
    public static void main(String[] args) {
        //聚合的方式
//        Car car = new Car();
//        CarLogProxy clp = new CarLogProxy(car);
//        CarTimeProxy ctp = new CarTimeProxy(clp);
//        ctp.move();
//
//        //jdk动态代理方式
//        Car car2 = new Car();
//        Class cls = car2.getClass();
//        /**
//         * 参数：
//         * loader 类加载器
//         * interface 实现接口
//         * h invocationHandler
//         */
//        InvocationHandler h2 = new LogHandler(car2);
//        Moveable m2 = (Moveable) Proxy.newProxyInstance(cls.getClassLoader(),cls.getInterfaces(),h2);
//        InvocationHandler h = new TimeHandler(m2);
//        Moveable m = (Moveable) Proxy.newProxyInstance(cls.getClassLoader(), cls.getInterfaces(), h);
//        m.move();

        //jdk动态代理方式
        Car car2 = new Car();
        Class cls = car2.getClass();
        /**
         * 参数：
         * loader 类加载器
         * interface 实现接口
         * h invocationHandler
         */
        InvocationHandler h = new TimeHandler(car2);
        Moveable m = (Moveable) Proxy.newProxyInstance(cls.getClassLoader(), cls.getInterfaces(), h);
        System.out.println("代理类名字: " + m.getClass().getName());
        m.move();

    }
}
