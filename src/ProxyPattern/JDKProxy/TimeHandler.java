package ProxyPattern.JDKProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 时间代理类
 */
public class TimeHandler implements InvocationHandler{

    private Object target;

    public TimeHandler(Object target) {
        this.target = target;
    }

    /**
     *
     * @param proxy 被代理对象
     * @param method 被代理对象方法
     * @param args   方法参数
     * @return
     * Object 方法返回值
     *
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("汽车开始行驶...");
        long startTime = System.currentTimeMillis();
        method.invoke(target);
        long endTime = System.currentTimeMillis();
        System.out.println("汽车结束行驶... 行驶时间" + (endTime - startTime) + "毫秒");
        return null;
    }
}




