package alias;

import org.checkerframework.common.aliasing.qual.Unique;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

/**
 *
 */
public class InvokeDynamicVirtual {

    Object o;

    public static void main(String[] args) throws Throwable {
        @Unique InvokeDynamicVirtual original = new InvokeDynamicVirtual();

        /* safe: set unique object uniquely */
        original.o = "safe";
        System.out.println(original.o.toString());

        /* unsafe: make object null via alias */
        MethodHandles.Lookup l = MethodHandles.lookup();
        MethodType t = MethodType.methodType(Object.class, Object.class);
        MethodHandle h = l.findVirtual(InvokeDynamicVirtual.class, "aliasOf", t);
        InvokeDynamicVirtual alias =
                (InvokeDynamicVirtual) h.invoke(new InvokeDynamicVirtual(), original);
        alias.o = null;
        System.out.println(original.o.toString());
    }

    Object aliasOf(Object o) {
        return o;
    }
}