package ProxyPattern2;

import java.lang.reflect.Method;

public interface InvocationHandler {

    void invoke(Object o, Method m);
}
