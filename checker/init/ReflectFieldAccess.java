package checker.init;

import java.lang.reflect.Field;

/**
 * Created by Michael Emery on 2019-06-06.
 */
public class ReflectFieldAccess {

    Object o;

    ReflectFieldAccess(int x) throws Exception {
        Class<?> C = this.getClass();
        Field f = C.getDeclaredField("o");
        f.set(this, "safe");
    }

    ReflectFieldAccess(int x, int y) throws Exception {
        Class<?> C = this.getClass();
        Field f = C.getDeclaredField("o");
        f.set(this, null);
    }

    public static void main(String[] args) throws Exception {

        /* safe: set object to non-null */
        System.out.println(
                new ReflectFieldAccess(1).o.toString());  // safe

        /* safe: set object to non-null */
        System.out.println(
                new ReflectFieldAccess(1, 2).o.toString());  // NullPointerException
    }
}
