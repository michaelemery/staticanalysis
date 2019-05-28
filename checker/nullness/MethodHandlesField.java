package checker.nullness;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;

/**
 * Assignment of a null reference via method handles field access.
 */
public class MethodHandlesField {

    Object o;

    MethodHandlesField(Object obj) {
        this.o = obj;
    }

    public static void main(String[] args) throws Throwable {
        MethodHandles.Lookup lookup = MethodHandles.lookup();
        MethodHandle mh =
                lookup.findSetter(MethodHandlesField.class, "o", Object.class);
        MethodHandlesField i = new MethodHandlesField("init");

        /* safe: set object to non-null */
        mh.invoke(i, "safe");
        System.out.println(i.o.toString());  // safe

        /* unsafe: set object to null */
        mh.invoke(i, null);
        System.out.println(i.o.toString());  // NullPointerException
    }
}
