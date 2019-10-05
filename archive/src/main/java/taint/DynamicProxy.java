package taint;

import org.checkerframework.checker.tainting.qual.Untainted;

import java.lang.reflect.Proxy;

/**
 * Check tainting for field set via dynamic proxy invocation.
 */
public class DynamicProxy {

    @Untainted Object foo;

    interface MyClass {
        Object getObject(Object object);
    }

    MyClass getProxyInstance() {
        return (MyClass) Proxy.newProxyInstance(
                MyClass.class.getClassLoader(),
                new Class[]{MyClass.class},
                (proxy, method, methodArgs) -> {
                    if (method.getName().equals("getObject")) {
                        return methodArgs[0];
                    } else {
                        throw new UnsupportedOperationException();
                    }
                });
    }

    /**
     * Untainted field never throws Exception.
     */
    public static void setFooToUntainted() {
        DynamicProxy i = new DynamicProxy();
        i.foo = i.getProxyInstance().getObject(new @Untainted Object());
    }

    /**
     * Tainted field always throws Exception.
     */
    public static void setFooToTainted() {
        DynamicProxy i = new DynamicProxy();
        i.foo = i.getProxyInstance().getObject(new Object());
    }
}
