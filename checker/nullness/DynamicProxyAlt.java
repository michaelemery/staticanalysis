package checker.nullness;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

interface FooAlt {

    Object get(Boolean safe);
}

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
public class DynamicProxyAlt {

    public static void main(String[] args) {

        /* safe: set object to non-null */
        FooAlt f = (FooAlt) getProxyInstance(FooAlt.class);

        System.out.println(f.get(true).toString());   // safe

        /* unsafe: set object to null */
        System.out.println(f.get(false).toString());  // NullPointerException
    }

    static Object getProxyInstance(Class c) {
        return Proxy.newProxyInstance(
                DynamicProxyAlt.class.getClassLoader(),
                new Class[]{c},
                new DynamicInvocationHandler()
        );
    }
}
