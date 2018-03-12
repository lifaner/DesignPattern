package ProxyPattern.Cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibProxy implements MethodInterceptor {

    private Enhancer enhancer = new Enhancer();

    public Object getProxy(Class clazz){
        //设置创建子类的类
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(this);
        return enhancer.create();
    }


    /**
     * 拦截所有目标类方法的调用
     * @param o      目标类的实例
     * @param method 目标类的反射对象
     * @param objects 参数
     * @param proxy 代理类实例
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy proxy) throws Throwable {

        System.out.println("开始。。。");
        //代理类调用父类方法
        proxy.invokeSuper(o,objects);
        System.out.println("结束。。。");
        return null;
    }
}
