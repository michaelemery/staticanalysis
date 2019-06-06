package init;

import java.lang.reflect.Method;

/**
 * Created by Michael Emery on 2019-06-05.
 */
public class ReflectMethodOverload {

    Object o;

    ReflectMethodOverload() throws Exception {
        Class<?> C = ReflectMethodOverload.class;
        Method m = C.getDeclaredMethod("m");
        this.o = "safe";
        m.invoke(this, 1);
    }

    ReflectMethodOverload(int x) throws Exception {
        Class<?> C = ReflectMethodOverload.class;
        Method m = C.getDeclaredMethod("m");
        m.invoke(this, 1);
    }

    void m() {
        System.out.println(this.o.toString());
    }

    void m(int x) {
        System.out.println(this.o.toString());
    }

    public static void main(String[] args) throws Exception {

        /* safe: set object to non-null */
        new ReflectMethodOverload();

        /* safe: set object to non-null */
        new ReflectMethodOverload(1);
    }
}
