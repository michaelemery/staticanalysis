package alias;

import org.checkerframework.common.aliasing.qual.Unique;

import java.lang.reflect.Proxy;

/**
 * Check for changes due to aliasing an object via dynamic proxy.
 */
public class DynamicProxy {

    int foo = 1;

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
                        throw new UnsupportedOperationException();
                    }
                });
    }

    /**
     * Non-aliased object never throws Exception.
     */
    public static void setFooWithoutAlias() throws Exception {
        @Unique DynamicProxy original = new DynamicProxy();
        if (original.foo != 1) {
            throw new Exception();
        }
    }

    /**
     * Aliased object always throws Exception.
     */
    public static void setFooWithAlias() throws Exception {
        @Unique DynamicProxy original = new DynamicProxy();
        DynamicProxy alias =
                (DynamicProxy) getProxyInstance().getObject(original);
        alias.foo = 2;
        if (original.foo == 2) {
            throw new Exception("original.foo == 2");
        }
    }
}
