package alias;

import org.checkerframework.common.aliasing.qual.Unique;

import java.lang.reflect.Method;

/**
 *
 */
public class ReflectMethodOverload {

    Object o;

    public static void main(String[] args) throws Exception {
        @Unique ReflectMethodOverload original = new ReflectMethodOverload();

        /* safe: set unique object uniquely */
        original.o = "safe";
        System.out.println(original.o.toString());

        /* unsafe: make object null via alias */
        Class<?> C = ReflectMethodOverload.class;
        Method m = C.getDeclaredMethod("aliasOf", Object.class, int.class);
        ReflectMethodOverload alias =
                (ReflectMethodOverload) m.invoke(new ReflectMethodOverload(), original, 1);
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
