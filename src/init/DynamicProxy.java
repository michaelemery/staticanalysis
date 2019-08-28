package init;

import java.lang.reflect.Proxy;

/**
 * Check initialisation of a field set via dynamic proxy invocation.
 */
public class DynamicProxy {

    Object foo;

    DynamicProxy(MyClass proxyInstance, Object object) {
        this.foo = proxyInstance.getObject(object);
    }

    interface MyClass {
        Object getObject(Object object);
    }

    static MyClass getProxyInstance() {
        return (MyClass) Proxy.newProxyInstance(
                MyClass.class.getClassLoader(),
                new Class[]{MyClass.class},
                (proxy, method, methodArgs) -> {
                    if (method.getName().equals("getObject")) {
                        return methodArgs[0];
                    } else {
                        throw new UnsupportedOperationException(
                                "Unsupported method: " + method.getName());
                    }
                });
    }

    /**
     * Field set to non-null never throws NullPointerException.
     */
    static void setFooToNonNull() {
        new DynamicProxy(getProxyInstance(), new Object()).foo.toString();
    }

    /**
     * Field set to null always throws NullPointerException.
     */
    static void setFooToNull() {
        new DynamicProxy(getProxyInstance(), null).foo.toString();
    }
}
