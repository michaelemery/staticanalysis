package checker.nullness;

import java.lang.reflect.Method;

/**
 * Assignment of a null reference via reflection overloaded method invocation.
 */
public class ReflectOverloadInvoke {

    Object o;

    ReflectOverloadInvoke(Object obj) {
        this.o = obj;
    }

    public static void main(String[] args) throws Exception {
        Method m;
        ReflectOverloadInvoke i = new ReflectOverloadInvoke("init");

        /* safe: set object to non-null */
        m = ReflectOverloadInvoke.class.getDeclaredMethod("set", String.class);
        m.invoke(i, "safe");
        System.out.println(i.o.toString());  // safe

        /* unsafe: set object to null */
        m = ReflectOverloadInvoke.class.getDeclaredMethod("set");
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
