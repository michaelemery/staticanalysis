package alias;

import org.checkerframework.common.aliasing.qual.Unique;

import java.lang.reflect.Method;

/**
 *
 */
public class ReflectConstructor {

    Object o = "init";

    public static void main(String[] args) throws Exception {
        @Unique ReflectConstructor original = new ReflectConstructor();

        /* safe: set unique object uniquely */
        original.o = "safe";
        System.out.println(original.o.toString());

        /* unsafe: make object null via alias */
        Class<?> C = ReflectConstructor.class;
        Method m = C.getDeclaredMethod("aliasOf", Object.class, int.class);
        ReflectConstructor alias =
                (ReflectConstructor) m.invoke(new ReflectConstructor(), original, 1);
        alias.o = null;
        System.out.println(original.o.toString());
    }

    Object aliasOf(Object obj) {
        return obj;
    }

    Object aliasOf(Object obj, int x) {
        return obj;
    }
}
