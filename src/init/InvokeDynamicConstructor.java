package init;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

/**
 * Initialisation of an object via dynamic invocation of a constructor.
 */
public class InvokeDynamicConstructor {

    Object object;

    InvokeDynamicConstructor(Object object) throws Throwable {
        this.object = object;
        this.object.toString();
    }

    static MethodHandle getConstructorMethodHandle() throws Throwable {
        MethodHandles.Lookup lookup = MethodHandles.lookup();
        MethodType methodType = MethodType.methodType(void.class, Object.class);
        return lookup.findConstructor(InvokeDynamicConstructor.class, methodType);
    }

    // initialises field
    static void initialiseWithObject() throws Throwable {
        getConstructorMethodHandle().invoke(new Object());
    }

    // fails to initialise field
    static void failToInitialise() throws Throwable {
        getConstructorMethodHandle().invoke(null);
    }
}
