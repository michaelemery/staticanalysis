package nullness;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxy {

    public static void main(String[] args) {
        MyInterface proxy = (MyInterface) Proxy.newProxyInstance(MyInterface.class.getClassLoader(), new Class[] { MyInterface.class }, new SafeInvocationHandler());
        String s = proxy.get().toString();  // safe
        System.out.println(s);  // "some result"
     
        proxy = (MyInterface) Proxy.newProxyInstance(MyInterface.class.getClassLoader(), 
                new Class[] { MyInterface.class }, 
                new UnsafeInvocationHandler());
        proxy.get().toString();  // unsafe
        s = proxy.get().toString();
        System.out.println(s);  // NullPointer Exception
    }
    
    public interface MyInterface {
        Object get();
    }
    
    public static class UnsafeInvocationHandler implements InvocationHandler {
 
        @Override
        public Object invoke(Object obj, Method m, Object[] arg) throws Throwable {
            return null;        
        }
    }
     
    public static class SafeInvocationHandler implements InvocationHandler {
 
        @Override
        public Object invoke(Object obj, Method m, Object[] arg) throws Throwable {
            return "some result";
        }
    }
}
