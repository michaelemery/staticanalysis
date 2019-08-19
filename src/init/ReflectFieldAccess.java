package init;

import java.lang.reflect.Field;

/**
 * Validate initialisation of an object via reflective field access.
 */
public class ReflectFieldAccess {

    Object object;

    ReflectFieldAccess() throws Exception {
        this.object = "init";
        Class<?> C = this.getClass();
        Field f = C.getDeclaredField("object");
        f.set(this, "safe");
        System.out.println(this.object.toString());
    }

    ReflectFieldAccess(int x) throws Exception {
        this.object = "init";
        Class<?> C = this.getClass();
        Field f = C.getDeclaredField("object");
        f.set(this, null);
        System.out.println(this.object.toString());
    }

    public static void main(String[] args) throws Exception {

        /* safe: set object to non-null */
        new ReflectFieldAccess();

        /* safe: set object to non-null */
        new ReflectFieldAccess(1);
    }
}
