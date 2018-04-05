package nullness;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import org.checkerframework.checker.nullness.qual.*;

/**
 * Assignment of a null reference via dynamic proxy.
 */
public class DynamicProxy {
    
    public static void main(String[] args) {
        MyInterface proxy;
        @Nullable ClassLoader clLoader = MyInterface.class.getClassLoader();
        String s;
        
        // assignment of a non-null via dynamic proxy
        proxy = (MyInterface) Proxy.newProxyInstance(clLoader, 
                new Class[] { MyInterface.class }, 
                new SafeInvocationHandler());
        s = proxy.get().toString();  // safe
        System.out.println(s);  // "text"
        
        // assignment of a null via dynamic proxy
        proxy = (MyInterface) Proxy.newProxyInstance(clLoader, 
                new Class[] { MyInterface.class }, 
                new UnsafeInvocationHandler());
        s = proxy.get().toString();  // unsafe
        System.out.println(s);  // NullPointer Exception
    }
    
    public interface MyInterface {
        Object get();
    }
    
    public static class SafeInvocationHandler implements InvocationHandler {
        
        @Override
        public @NonNull Object invoke(Object obj, Method m, Object[] arg) throws Throwable {
            return "text";
        }
    }
    
    public static class UnsafeInvocationHandler implements InvocationHandler {
        
        @Override
        public @Nullable Object invoke(Object obj, Method m, Object[] arg) throws Throwable {
            return null;
        }
    }
    
}
