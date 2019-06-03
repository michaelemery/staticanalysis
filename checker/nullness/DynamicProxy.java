package checker.nullness;

import java.lang.reflect.Proxy;

/**
 * Assign a null reference via dynamic proxy invocation.
 */
public class DynamicProxy {

    interface Foo {

        Object get(Boolean safe);
    }

    public static void main(String[] args) {

        /* safe: set object to non-null */
        Foo proxyInstance = (Foo) Proxy.newProxyInstance(
                Foo.class.getClassLoader(),
                new Class[]{Foo.class},
                (proxy, method, methodArgs) -> {
                    if (method.getName().equals("get")) {
                        return (Boolean) methodArgs[0] ? "safe" : null;
                    } else {
                        throw new UnsupportedOperationException(
                                "Unsupported method: " + method.getName());
                    }
                });

        /* safe: simulate setting object to non-null */
        System.out.println(proxyInstance.get(true).toString());

        /* unsafe: simulate setting object to null */
        System.out.println(proxyInstance.get(false).toString());
    }
}
