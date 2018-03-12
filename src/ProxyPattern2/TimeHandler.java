package ProxyPattern2;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TimeHandler implements InvocationHandler {

    private Object target;

    public TimeHandler(Moveable m){
        this.target = m;
    }

    @Override
    public void invoke(Object o, Method m) {
        try {
            System.out.println("启动");
            m.invoke(target);
            System.out.println("停止");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
