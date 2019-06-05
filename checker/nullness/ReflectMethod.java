package checker.nullness;

import java.lang.reflect.Method;

/**
 * Assign a null reference via reflection method invocation.
 */
public class ReflectMethod {

    Object o;

    ReflectMethod(Object obj) {
        this.o = obj;
    }

    public static void main(String[] args) throws Exception {
        Class<?> C = ReflectMethod.class;
        Method m = C.getDeclaredMethod("set", Boolean.class);
        ReflectMethod i = new ReflectMethod("init");

        /* safe: set object to non-null */
        i.o = m.invoke(i, true).toString();
        System.out.println(i.o.toString());  // safe

        /* unsafe: set object to null */
        i.o = m.invoke(i, false).toString();
        System.out.println(i.o.toString());  // NullPointerException
    }

    public void set(Boolean safe) {
        this.o = safe ? "safe" : null;
    }
}
