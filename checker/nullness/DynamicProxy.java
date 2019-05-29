package checker.nullness;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Assign a null reference via dynamic proxy.
 */
public class DynamicProxy implements InvocationHandler {

    Object o;

    DynamicProxy() {
        this.o = "safe";
    }

    public static void main(String[] args) {

        /* safe: set object to non-null */
        System.out.println(new DynamicProxy().get());  // safe

        /* unsafe: set object to null */
        DynamicProxy i = (DynamicProxy) Proxy.newProxyInstance(
                DynamicProxy.class.getClassLoader(),
                new Class[]{DynamicProxy.class},
                new DynamicProxy());
        System.out.println(i.get());  // NullPointerException
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("method: " + method.getName());
        return null;
    }

    Object get() {
        return this.o;
    }
}
