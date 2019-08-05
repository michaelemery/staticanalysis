package nullness;

import java.lang.reflect.Proxy;

/**
 * Assign a null reference via dynamic proxy invocation.
 */
public class DynamicProxy {

    interface Foo {
        Object get(Object obj);
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
        System.out.println(proxyInstance.get("safe").toString());

        /* unsafe: simulate setting object to null */
        System.out.println(proxyInstance.get(null).toString());
    }
}
