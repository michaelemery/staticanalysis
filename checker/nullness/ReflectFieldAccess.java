package checker.nullness;

import java.lang.reflect.Field;

/**
 * Assign a null reference via reflection field access.
 */
public class ReflectFieldAccess {

    Object o;

    ReflectFieldAccess() {
        this.o = "safe";
    }
    
    public static void main(String[] args) throws Exception {
        Class<?> C;
        ReflectFieldAccess i;

        /* safe: set object to non-null */
        i = new ReflectFieldAccess();
        C = i.getClass();
        Field f = C.getDeclaredField("o");
        f.set(i, "safe");
        System.out.println(i.o.toString());  // safe

        /* unsafe: set object to null */
        C = i.getClass();
        f = C.getDeclaredField("o");
        f.set(i, null);
        System.out.println(i.o.toString());  // NullPointerException
    }
}
