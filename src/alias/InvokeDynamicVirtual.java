package alias;

import org.checkerframework.common.aliasing.qual.Unique;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

/**
 *
 */
public class InvokeDynamicMethod {

    Object o = "init";

    public static void main(String[] args) throws Throwable {
        @Unique InvokeDynamicMethod original = new InvokeDynamicMethod();

        /* safe: set unique object uniquely */
        original.o = "safe";
        System.out.println(original.o.toString());

        /* unsafe: make object null via alias */
        MethodHandles.Lookup l = MethodHandles.lookup();
        MethodType t = MethodType.methodType(Object.class, Object.class);
        MethodHandle h = l.findVirtual(InvokeDynamicMethod.class, "aliasOf", t);
        InvokeDynamicMethod alias =
                (InvokeDynamicMethod) h.invoke(new InvokeDynamicMethod(), original);
        alias.o = null;
        System.out.println(original.o.toString());
    }

    Object aliasOf(Object o) {
        return o;
    }
}