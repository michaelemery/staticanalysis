package init;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

/**
 * Initialisation of an object via dynamic invocation of a static method.
 */
public class InvokeDynamicMethod {

    Object object;

    // initialises field
    InvokeDynamicMethod() throws Throwable {
        this.object = getReturnObjectMethodHandle().invoke(new Object());
        this.object.toString();
    }

    // fails to initialise field
    InvokeDynamicMethod(int x) throws Throwable {
        this.object = getReturnObjectMethodHandle().invoke(null);
        this.object.toString();
    }

    static MethodHandle getReturnObjectMethodHandle() throws Throwable {
        MethodHandles.Lookup lookup = MethodHandles.lookup();
        MethodType methodType = MethodType.methodType(Object.class, Object.class);
        return lookup.findStatic(InvokeDynamicMethod.class, "returnObject", methodType);
    }

    static Object returnObject(Object object) {
        return object;
    }

    static void initialiseWithObject() throws Throwable {
        new InvokeDynamicMethod();
    }

    static void failToInitialise() throws Throwable {
        new InvokeDynamicMethod(1);
    }
}
