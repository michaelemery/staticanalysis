package init;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

/**
 * Initialisation of an object via dynamic invocation of a field set.
 */
public class InvokeDynamicField {

    Object object;

    // initialises field
    InvokeDynamicField() throws Throwable {
        this.object = new Object();
        getSetterMethodHandle().invoke(this, new Object());
        this.object.toString();
    }

    // fails to initialise field
    InvokeDynamicField(int x) throws Throwable {
        this.object = new Object();
        getSetterMethodHandle().invoke(this, null);
        this.object.toString();
    }

    static MethodHandle getSetterMethodHandle() throws Throwable {
        MethodHandles.Lookup lookup = MethodHandles.lookup();
        return lookup.findSetter(InvokeDynamicField.class, "object", Object.class);
    }

    static void initialiseWithObject() throws Throwable {
        new InvokeDynamicField();
    }

    static void failToInitialise() throws Throwable {
        new InvokeDynamicField(1);
    }
}
