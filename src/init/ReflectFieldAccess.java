package init;

import java.lang.reflect.Field;

/**
 * Validate initialisation of an object via reflective field access.
 */
public class ReflectFieldAccess {

    Object object;

    ReflectFieldAccess() throws Exception {
        Class<?> C = this.getClass();
        Field f = C.getDeclaredField("object");
        f.set(this, new Object());
        this.object.toString();
    }

    ReflectFieldAccess(int x) throws Exception {
        Class<?> C = this.getClass();
        Field f = C.getDeclaredField("object");
        f.set(this, null);
        this.object.toString();
    }
}
