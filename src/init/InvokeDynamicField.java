package init;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;

/**
 * Assign a null reference via dynamic field access invocation.
 */
public class InvokeDynamicField {

    Object o;

    InvokeDynamicField(MethodHandle h) throws Throwable {
        this.o = "init";
        h.invoke(this, "safe");
        System.out.println(this.o.toString());
    }

    InvokeDynamicField(MethodHandle h, int x) throws Throwable {
        this.o = "init";
        h.invoke(this, null);
        System.out.println(this.o.toString());
    }

    public static void main(String[] args) throws Throwable {
        MethodHandles.Lookup l = MethodHandles.lookup();
        MethodHandle h = l.findSetter(InvokeDynamicField.class, "o", Object.class);

        /* safe: set object to non-null */
        new InvokeDynamicField(h);

        /* unsafe: set object to null */
        new InvokeDynamicField(h, 1);
    }
}
