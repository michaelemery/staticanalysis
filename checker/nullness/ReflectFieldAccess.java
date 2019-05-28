package checker.nullness;

import java.lang.reflect.Field;

/**
 * Assignment of a null reference via reflection field access.
 */
public class ReflectFieldAccess {

    Object o;

    ReflectFieldAccess(Object obj) {
        this.o = obj;
    }

    public static void main(String[] args) throws Exception {

        /* safe: set object to non-null */
        ReflectFieldAccess i = new ReflectFieldAccess("safe");
        System.out.println(i.o.toString());  // safe

        /* unsafe: set object to null */
        Class<?> C = i.getClass();
        Field f = C.getDeclaredField("o");
        f.set(i, null);
        System.out.println(i.o.toString());  // NullPointerException
    }
}
