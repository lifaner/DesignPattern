package ProxyPattern.FakeProxy;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TimeHandler implements InvocationHandler {

    //被代理对象
    private Object target;

    public TimeHandler(Object target) {
        this.target = target;
    }

    @Override
    public void invoke(Object o, Method m) {

        try {
            System.out.println("汽车开始行驶...");
            long startTime = System.currentTimeMillis();
            m.invoke(target);
            long endTime = System.currentTimeMillis();
            System.out.println("汽车行驶结束... 行驶时间：" + (endTime - startTime));
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
