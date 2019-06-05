package checker.nullness;

import java.lang.reflect.Method;

/**
 * Assign a null reference via overloaded reflection method invocation.
 */
public class ReflectMethodOverload {

    Object o;

    ReflectMethodOverload(Object obj) {
        this.o = obj;
    }

    public static void main(String[] args) throws Exception {
        Method m;
        ReflectMethodOverload i = new ReflectMethodOverload("init");

        /* safe: set object to non-null */
        m = ReflectMethodOverload.class.getDeclaredMethod("set", String.class);
        m.invoke(i, "safe");
        System.out.println(i.o.toString());  // safe

        /* unsafe: set object to null */
        m = ReflectMethodOverload.class.getDeclaredMethod("set");
        m.invoke(i);
        System.out.println(i.o.toString());  // NullPointerException
    }

    void set(String s) {
        this.o = s;
    }

    void set() {
        this.o = null;
    }
}
