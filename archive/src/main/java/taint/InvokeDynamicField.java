package taint;

import org.checkerframework.checker.tainting.qual.Untainted;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;

/**
 * Check tainting of field set via dynamic field access invocation.
 */
public class InvokeDynamicField {

    @Untainted Object foo;

    InvokeDynamicField() {
        this.foo = new @Untainted Object();
    }

    static MethodHandle getSetterMethodHandle() throws Exception {
        MethodHandles.Lookup l = MethodHandles.lookup();
        return l.findSetter(InvokeDynamicField.class, "foo", Object.class);
    }

    /**
     * Untainted field never throws Exception.
     */
    public static void setFooToUntainted() throws Throwable {
        InvokeDynamicField i = new InvokeDynamicField();
        getSetterMethodHandle().invoke(i, new @Untainted Object());
    }

    /**
     * Tainted field always throws Exception.
     */
    public static void setFooToTainted() throws Throwable {
        InvokeDynamicField i = new InvokeDynamicField();
        getSetterMethodHandle().invoke(i, new Object());
    }
}
