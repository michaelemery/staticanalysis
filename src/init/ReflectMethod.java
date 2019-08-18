package init;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Validate initialisation of an object via reflective methods calls.
 */
public class ReflectMethod {

    Object object;

    // initialises field
    ReflectMethod(Method method) throws Exception {
        this.object = new Object();
        method.invoke(this);
    }

    // fails to initialise field
    ReflectMethod(Method method, int x) throws Exception {
        method.invoke(this);
    }

    // accesses field before initialised
    ReflectMethod(Method method, int x, int y) throws Exception {
        method.invoke(this);
        this.object = new Object();
    }

    void beString() {
        this.object.toString();
    }

    static Method getBeStringMethod() throws NoSuchMethodException {
        Class<?> C = ReflectMethod.class;
        return C.getDeclaredMethod("beString");
    }
}
