package taint;

import org.checkerframework.checker.tainting.qual.Untainted;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

/**
 * Check tainting of field set via dynamic constructor invocation.
 */
public class InvokeDynamicConstructor {

    @Untainted Object foo;

    InvokeDynamicConstructor(@Untainted Object object) {
        this.foo = object;
    }

    static MethodHandle getConstructorMethodHandle() throws Throwable {
        MethodHandles.Lookup lookup = MethodHandles.lookup();
        MethodType methodType = MethodType.methodType(void.class, Object.class);
        return lookup.findConstructor(InvokeDynamicConstructor.class, methodType);
    }

    /**
     * Untainted field never throws Exception.
     */
    public static void setFooToUntainted() throws Throwable {
        InvokeDynamicConstructor i = (InvokeDynamicConstructor)
                getConstructorMethodHandle().invoke(new @Untainted Object());
    }

    /**
     * Tainted field always throws Exception.
     */
    public static void setFooToTainted() throws Throwable {
        InvokeDynamicConstructor i = (InvokeDynamicConstructor)
                getConstructorMethodHandle().invoke(new Object());
    }
}
