package nullness;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Check nullness for field set via dynamic proxy invocation.
 */
public class DynamicProxy {

    Object foo;

    interface MyInterface {
        Object getObject(Object object);
    }

    public class MyClass implements MyInterface {
        public Object getObject(Object object) {
            return object;
        }
    }

    public class MyInvocationHandler implements InvocationHandler {
        public Object invoke(Object object, Method method, Object[] methodArgs)
                throws Throwable {
            return method.invoke(new MyClass(), methodArgs);
        }
    }

    MyInterface getProxyInstance() {
        return (MyInterface) Proxy.newProxyInstance(
                MyInterface.class.getClassLoader(),
                new Class[]{MyInterface.class},
                new MyInvocationHandler());
    }

    /**
     * False Positive (FP) if checker reports null warning.
     */
    public static void setFooToNonNull() {
        DynamicProxy i = new DynamicProxy();
        i.foo = i.getProxyInstance().getObject(new Object());
        i.foo.toString();
    }

    /**
     * True Positive (TP) if checker reports null warning, else False Negative (FN).
     * @throws NullPointerException
     */
    public static void setFooToNull() {
        DynamicProxy i = new DynamicProxy();
        i.foo = i.getProxyInstance().getObject(null);
        i.foo.toString();
    }
}