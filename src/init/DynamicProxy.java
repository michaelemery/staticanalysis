package init;

import java.lang.reflect.Proxy;

/**
 * Initialisation of an object via dynamic proxy invocation.
 */
public class DynamicProxy {

    Object o;

    DynamicProxy(Foo proxyInstance) {
        this.o = proxyInstance.get("safe");
        System.out.println(this.o.toString());
    }

    DynamicProxy(Foo proxyInstance, int x) {
        this.o = proxyInstance.get(null);
        System.out.println(this.o.toString());
    }

    interface Foo {
        Object get(Object o);
    }

    static Foo getProxyInstance() {
        Foo proxyInstance = (Foo) Proxy.newProxyInstance(
                Foo.class.getClassLoader(),
                new Class[]{Foo.class},
                (proxy, method, methodArgs) -> {
                    if (method.getName().equals("get")) {
                        return methodArgs[0];
                    } else {
                        throw new UnsupportedOperationException(
                                "Unsupported method: " + method.getName());
                    }
                });
        return proxyInstance;
    }

    // initialises field
    static void constructWithObject() {
        new DynamicProxy(getProxyInstance());
    }

    // fails to initialise field
    static void constructWithNull() {
        new DynamicProxy(getProxyInstance(), 1);
    }
}
