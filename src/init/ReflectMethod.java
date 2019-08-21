package init;

import java.lang.reflect.Method;

/**
 * Initialisation of an object via reflective methods.
 */
public class ReflectMethod {

    Object object;

    // initialises field
    ReflectMethod() throws Exception {
        Method method = this.getClass().getDeclaredMethod("returnObject", Object.class);
        this.object = method.invoke(null, new Object());
        this.object.toString();
    }

    // fail to initialise
    ReflectMethod(int x) throws Exception {
        Method method = this.getClass().getDeclaredMethod("returnObject", Object.class);
        this.object = method.invoke(null, (Object) null);
        this.object.toString();
    }

    static Object returnObject(Object object) {
        return object;
    }

    static void initialiseWithObject() throws Exception {
        new ReflectMethod();
    }

    static void failToInitialise() throws Exception {
        new ReflectMethod(1);
    }
}
