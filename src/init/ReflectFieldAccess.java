package init;

import java.lang.reflect.Field;

/**
 * Created by Michael Emery on 2019-06-06.
 */
public class ReflectFieldAccess {

    Object o;

    ReflectFieldAccess() throws Exception {
        this.o = "init";
        Class<?> C = this.getClass();
        Field f = C.getDeclaredField("o");
        f.set(this, "safe");
        System.out.println(this.o.toString());
    }

    ReflectFieldAccess(int x) throws Exception {
        this.o = "init";
        Class<?> C = this.getClass();
        Field f = C.getDeclaredField("o");
        f.set(this, null);
        System.out.println(this.o.toString());
    }

    public static void main(String[] args) throws Exception {

        /* safe: set object to non-null */
        new ReflectFieldAccess();

        /* safe: set object to non-null */
        new ReflectFieldAccess(1);
    }
}
