package init;

import java.lang.reflect.Method;

/**
 * Validate initialisation of an object via overloaded reflective methods.
 */
public class ReflectMethodOverload {

    Object object;

    // initialises field
    ReflectMethodOverload() throws Exception {
        Class<?> C = ReflectMethodOverload.class;
        Method method = C.getDeclaredMethod("getObject");
        this.object = method.invoke(this);
        this.object.toString();
    }

    // fails to initialise field
    ReflectMethodOverload(int x) throws Exception {
        Class<?> C = ReflectMethodOverload.class;
        Method method = C.getDeclaredMethod("getObject", int.class);
        this.object = method.invoke(this);
        this.object.toString();
    }

    Object getObject() {
        return new Object();
    }

    Object getObject(int x) {
        return null;
    }
}