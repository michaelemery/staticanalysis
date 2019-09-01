package alias;

import org.checkerframework.common.aliasing.qual.Unique;

import java.lang.reflect.Method;

/**
 * Check for changes due to aliasing an object via reflective method return.
 */
public class ReflectMethod {

    int foo;

    ReflectMethod() {
        this.foo = 1;
    }

    static ReflectMethod getAlias(Object object) {
        ReflectMethod alias = (ReflectMethod) object;
        alias.foo = 2;
        return alias;
    }

    /**
     * Non-aliased object never throws Exception.
     */
    public static void setFooWithoutAlias() throws Exception {
        @Unique ReflectMethod original = new ReflectMethod();
        if (original.foo != 1) {
            throw new Exception();
        }
    }


    /**
     * Aliased object always throws Exception.
     */
    public static void setFooWithAlias() throws Exception {
        @Unique ReflectMethod original = new ReflectMethod();
        Method getObjectMethod =
                original.getClass().getDeclaredMethod("getAlias", Object.class);
        ReflectMethod alias = (ReflectMethod) getObjectMethod.invoke(null, original);
        if (original.foo == 2) {
            throw new Exception("original.foo == 2");
        }
    }
}
