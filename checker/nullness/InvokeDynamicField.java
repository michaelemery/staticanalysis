package checker.nullness;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;

/**
 * Assign a null reference via dynamic field access invocation.
 */
public class InvokeDynamicField {

    Object o;

    InvokeDynamicField(Object obj) {
        this.o = obj;
    }

    public static void main(String[] args) throws Throwable {
        MethodHandles.Lookup lookup = MethodHandles.lookup();
        MethodHandle mh =
                lookup.findSetter(InvokeDynamicField.class, "o", Object.class);
        InvokeDynamicField i = new InvokeDynamicField("init");

        /* safe: set object to non-null */
        mh.invoke(i, "safe");
        System.out.println(i.o.toString());  // safe

        /* unsafe: set object to null */
        mh.invoke(i, null);
        System.out.println(i.o.toString());  // NullPointerException
    }
}
