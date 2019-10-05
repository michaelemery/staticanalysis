package generic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * generic example of dynamic proxy
 */
public class DynamicProxy {

    Object foo;
    Object bar =new Object();

    interface MyClass {
        Object getObject();
        Object getNullObject();
    }

    public class MyClassImple implements MyClass{
        @Override
        public Object getObject(){
            return new Object();
        }

        @Override
        public Object getNullObject(){return null;}
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
     *  a FP if it is reported. otherwise a TP
     */
    public static void setFooToNonNull() {
        DynamicProxy i = new DynamicProxy();
        i.foo = i.getProxyInstance().getObject();
        i.foo.toString();
    }

    /**
     * a FN if it is NOT reported, otherwise a TP
     * @throws java.lang.NullPointerException
     */
    public static void setBarToNull() {
        DynamicProxy i = new DynamicProxy();
        i.bar = i.getProxyInstance().getNullObject();
        i.bar.toString();
    }
}
