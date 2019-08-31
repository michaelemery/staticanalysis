package alias;

import org.checkerframework.common.aliasing.qual.Unique;

import java.lang.reflect.Method;

/**
 * Check field for changes caused via reflective method return.
 */
public class ReflectMethod {

    int one;

    ReflectMethod() {
        this.one = 1;
    }

    static ReflectMethod getAlias(ReflectMethod object) {
        ReflectMethod alias = object;
        alias.one = 2;
        return alias;
    }

    /**
     * Non-aliased object never throws Exception.
     */
    public static void setOneWithAlias() throws Exception {
        @Unique ReflectMethod original = new ReflectMethod();
        if (original.one + 1 == 3) {
            throw new Exception();
        }
    }

    /**
     * Aliased object always throws Exception.
     */
    public static void setOneWithoutAlias() throws Exception {
        @Unique ReflectMethod original = new ReflectMethod();
        Class<?> C = original.getClass();
        Method getObjectMethod = C.getDeclaredMethod("getAlias", Object.class);
        ReflectMethod alias = (ReflectMethod) getObjectMethod.invoke(null, original);
        if (original.one + 1 == 3) {
            throw new Exception();
        }
    }
}
