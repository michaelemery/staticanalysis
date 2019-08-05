package alias;

import org.checkerframework.common.aliasing.qual.Unique;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

/**
 * Created by Michael Emery on 2019-06-06.
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

        /* safe: set unique object uniquely */
        @Unique InvokeDynamicConstructor original = (InvokeDynamicConstructor) h.invoke("safe");

        /* unsafe: make object null via alias */
        InvokeDynamicConstructor alias = original;
        alias.o = null;
        System.out.println(original.o.toString());
    }
}
