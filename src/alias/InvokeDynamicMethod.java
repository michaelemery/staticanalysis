package alias;

import org.checkerframework.common.aliasing.qual.Unique;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

/**
 * Check for changes due to aliasing an object via dynamic virtual method invocation.
 */
public class InvokeDynamicMethod {

    int foo = 1;

    static Object getObject(Object object) {
        return object;
    }

    static MethodHandle getGetObjectMethodHandle() throws Exception {
        MethodHandles.Lookup lookup = MethodHandles.lookup();
        MethodType type = MethodType.methodType(Object.class, Object.class);
        return lookup.findStatic(InvokeDynamicMethod.class, "getObject", type);
    }

    /**
     * Non-aliased object never throws Exception.
     */
    public static void setFooWithoutAlias() throws Exception {
        @Unique InterProcedural original = new InterProcedural();
        if (original.foo != 1) {
            throw new Exception();
        }
    }

    /**
     * Aliased object always throws Exception.
     */
    public static void setFooWithAlias() throws Throwable {
        @Unique InterProcedural original = new InterProcedural();
        InterProcedural alias =
                (InterProcedural) getGetObjectMethodHandle().invoke(original);
        alias.foo = 2;
        if (original.foo == 2) {
            throw new Exception("original.foo == 2");
        }
    }
}
