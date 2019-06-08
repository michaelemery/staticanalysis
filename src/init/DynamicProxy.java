package init;

import java.lang.reflect.Proxy;

/**
 * Assign a null reference via dynamic proxy invocation.
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

    public static void main(String[] args) {

        /* safe: set object to non-null */
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

        /* safe: simulate setting object to non-null */
        new DynamicProxy(proxyInstance);

        /* unsafe: simulate setting object to null */
        new DynamicProxy(proxyInstance, 1);
    }
}
