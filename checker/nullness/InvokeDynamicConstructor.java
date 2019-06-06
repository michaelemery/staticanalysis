package checker.nullness;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

/**
 * Assign a null reference via dynamic constructor invocation.
 */
public class InvokeDynamicConstructor {

    Object o;

    InvokeDynamicConstructor(Object obj) {
        this.o = obj;
        System.out.println(this.o.toString());
    }

    public static void main(String[] args) throws Throwable {
        MethodHandles.Lookup l = MethodHandles.lookup();
        MethodType t = MethodType.methodType(void.class, Object.class);
        MethodHandle h = l.findConstructor(InvokeDynamicConstructor.class, t);

        /* safe: set object to non-null */
        h.invoke("safe");

        /* unsafe: set object to null */
        h.invoke(null);
    }
}
