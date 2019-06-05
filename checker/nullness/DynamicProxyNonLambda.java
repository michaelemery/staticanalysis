package checker.nullness;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Dynamic invocation handler for main class.
 */
class DynamicInvocationHandler implements InvocationHandler {

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Invoked " + method.getName() + "(" + args[0] + ")");
        Boolean safe = (Boolean) args[0];
        return safe ? "safe" : null;
    }
}

/**
 * Assign a null reference via dynamic proxy invocation.
 */
public class DynamicProxyNonLambda {

    interface Foo {

        Object get(Boolean safe);
    }

    public static void main(String[] args) {

        /* safe: set object to non-null */
        Foo f = (Foo) getProxyInstance(Foo.class);

        System.out.println(f.get(true).toString());   // safe

        /* unsafe: set object to null */
        System.out.println(f.get(false).toString());  // NullPointerException
    }

    static Object getProxyInstance(Class c) {
        return Proxy.newProxyInstance(
                DynamicProxyNonLambda.class.getClassLoader(),
                new Class[]{c},
                new DynamicInvocationHandler()
        );
    }
}
