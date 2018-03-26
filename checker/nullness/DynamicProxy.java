package nullness;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Assignment of a null reference via dynamic proxy.
 */
public class DynamicProxy {

    public static void main(String[] args) {
        MyInterface proxy;
        String s;
        
        // assignment of a non-null via dynamic proxy 
        proxy = (MyInterface) Proxy.newProxyInstance(MyInterface.class.getClassLoader(), 
                new Class[] { MyInterface.class }, 
                new SafeInvocationHandler());
        s = proxy.get().toString();  // safe
        System.out.println(s);  // "text"
     
        // assignment of a null via dynamic proxy 
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
            return "text";
        }
    }
}
