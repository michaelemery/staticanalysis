package alias;

import org.checkerframework.common.aliasing.qual.Unique;

import java.lang.reflect.Method;

/**
 *
 */
public class ReflectMethod {

    Object o;

    public static void main(String[] args) throws Exception {
        @Unique ReflectMethod original = new ReflectMethod();

        /* safe: set unique object uniquely */
        original.o = "safe";
        System.out.println(original.o.toString());

        /* unsafe: make object null via alias */
        Class<?> C = ReflectMethod.class;
        Method m = C.getDeclaredMethod("aliasOf", Object.class);
        ReflectMethod alias = (ReflectMethod) m.invoke(new ReflectMethod(), original);
        alias.o = null;
        System.out.println(original.o.toString());
    }

    Object aliasOf(Object obj) {
        return obj;
    }
}
