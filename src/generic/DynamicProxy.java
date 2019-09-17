package generic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * generic example of dynamic proxy
 */
public class DynamicProxy {

    Object foo;

    interface MyClass {
        Object getObject(Object object);
    }

    public class MyClassImple implements MyClass{
        @Override
        public Object getObject(Object object){
            return object;
        }
    }
    public class MyClassInvocationHandler implements InvocationHandler{
        @Override
        public Object invoke(Object obj, Method m, Object[] arg)
                throws Throwable {
            return m.invoke(new MyClassImple(),arg);
        }
    }

    MyClass getProxyInstance() {
        return (MyClass) Proxy.newProxyInstance(
                MyClass.class.getClassLoader(),
                new Class[]{MyClass.class},
                new MyClassInvocationHandler());
    }


    /**
     * Field set to non-null never throws NullPointerException.
     * may report it as a FP
     */
    public static void setFooToNonNull() {
        DynamicProxy i = new DynamicProxy();
        i.foo = i.getProxyInstance().getObject(new Object());
        i.foo.toString();
    }

    /**
     * Field set to null always throws NullPointerException.
     */
    public static void setFooToNull() {
        DynamicProxy i = new DynamicProxy();
        i.foo = i.getProxyInstance().getObject(null);
        i.foo.toString();
    }
}
