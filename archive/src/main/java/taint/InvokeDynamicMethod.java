package taint;

import org.checkerframework.checker.tainting.qual.Untainted;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

/**
 * Check tainting of field set via dynamic virtual (non-static) method invocation.
 */
public class InvokeDynamicMethod {

    @Untainted Object foo;

    void setFoo(@Untainted Object object) {
        this.foo = object;
    }

    MethodHandle getSetFooMethodHandle() throws Exception {
        MethodHandles.Lookup lookup = MethodHandles.lookup();
        MethodType type = MethodType.methodType(void.class, Object.class);
        return lookup.findVirtual(InvokeDynamicMethod.class, "setFoo", type);
    }

    /**
     * Untainted field never throws Exception.
     */
    public static void setFooToUntainted() throws Throwable {
        InvokeDynamicMethod i = new InvokeDynamicMethod();
        i.getSetFooMethodHandle().invoke(i, new @Untainted Object());
    }

    /**
     * Tainted field always throws Exception.
     */
    public static void setFooToTainted() throws Throwable {
        InvokeDynamicMethod i = new InvokeDynamicMethod();
        i.getSetFooMethodHandle().invoke(i, new Object());
    }
}
