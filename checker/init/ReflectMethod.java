package checker.init;

import java.lang.reflect.Method;

/**
 * Created by Michael Emery on 2019-06-05.
 */
public class ReflectMethod {

    Object o;

    ReflectMethod() {
        System.out.println(this.o.toString());
    }

    ReflectMethod(int x) throws Exception {
        Class<?> C = ReflectMethod.class;
        Method m = C.getDeclaredMethod("m");
        this.o = "safe";
        m.invoke(this);
    }

    ReflectMethod(int x, int y) throws Exception {
        Class<?> C = ReflectMethod.class;
        Method m = C.getDeclaredMethod("m");
        m.invoke(this);
    }

    void m() {
        System.out.println(this.o.toString());
    }

    public static void main(String[] args) throws Exception {

        /* safe: set object to non-null */
        new ReflectMethod(1);  // safe

        /* safe: set object to non-null */
        new ReflectMethod(1,2);  // NullPointerException
    }
}
