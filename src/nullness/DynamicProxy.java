package nullness;

import java.lang.reflect.Proxy;

/**
 * Check nullness for field set via dynamic proxy invocation.
 */
public class DynamicProxy {

    Object foo;

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
    public static void setFooToNonNull() {
        DynamicProxy i = new DynamicProxy();
        i.foo = getProxyInstance().getObject(new Object());
        i.foo.toString();
    }

    /**
     * Field set to null always throws NullPointerException.
     */
    public static void setFooToNull() {
        DynamicProxy i = new DynamicProxy();
        i.foo = getProxyInstance().getObject(null);
        i.foo.toString();
    }
}
