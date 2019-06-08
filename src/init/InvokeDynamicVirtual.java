package init;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

/**
 * Created by Michael Emery on 2019-06-06.
 */
public class InvokeDynamicVirtual {

    Object o;

    InvokeDynamicVirtual(MethodHandle h) throws Throwable {
        this.o = "init";
        h.invoke(this, "safe");
    }

    InvokeDynamicVirtual(MethodHandle h, int x) throws Throwable {
        this.o = "init";
        h.invoke(this, null);
    }

    public static void main(String[] args) throws Throwable {
        MethodHandles.Lookup l = MethodHandles.lookup();
        MethodType t = MethodType.methodType(void.class, Object.class);
        MethodHandle h = l.findVirtual(InvokeDynamicVirtual.class, "set", t);

        /* safe: set object to non-null */
        new InvokeDynamicVirtual(h);

        /* unsafe: set object to null */
        new InvokeDynamicVirtual(h, 1);
    }

    void set(Object obj) {
        this.o = obj;
        System.out.println(this.o.toString());
    }
}