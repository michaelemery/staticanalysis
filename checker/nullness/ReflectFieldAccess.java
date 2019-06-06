package checker.nullness;

import java.lang.reflect.Field;

/**
 * Assign a null reference via reflection field access.
 */
public class ReflectFieldAccess {

    Object o;

    ReflectFieldAccess() {
        this.o = "init";
    }
    
    public static void main(String[] args) throws Exception {
        ReflectFieldAccess i = new ReflectFieldAccess();
        Class<?> C = i.getClass();
        Field f = C.getDeclaredField("o");

        /* safe: set object to non-null */
        f.set(i, "safe");
        System.out.println(i.o.toString());

        /* unsafe: set object to null */
        f.set(i, null);
        System.out.println(i.o.toString());
    }
}
