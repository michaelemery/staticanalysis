package init;

import java.lang.reflect.Method;

/**
 * Created by Michael Emery on 2019-06-05.
 */
public class ReflectMethod {

    Object o;

    ReflectMethod(Method m) throws Exception {
        this.o = "safe";
        m.invoke(this);
    }

    ReflectMethod(Method m, int x) throws Exception {
        m.invoke(this);
    }

    void m() {
        System.out.println(this.o.toString());
    }

    public static void main(String[] args) throws Exception {
        Class<?> C = ReflectMethod.class;
        Method m = C.getDeclaredMethod("m");

        /* safe: set object to non-null */
        new ReflectMethod(m);

        /* safe: set object to non-null */
        new ReflectMethod(m, 1);
    }
}
