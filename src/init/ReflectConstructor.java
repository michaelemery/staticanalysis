package init;

import java.lang.reflect.Constructor;

/**
 * Initialisation of an object via reflective constructor.
 */
public class ReflectConstructor {

    Object object;

    ReflectConstructor(Object object) throws Exception {
        this.object = object;
        this.object.toString();
    }

    static Constructor getConstructor(Class... args) throws NoSuchMethodException {
        return ReflectConstructor.class.getDeclaredConstructor(args);
    }

    // initialises field
    static void constructWithObject() throws Exception {
        Constructor constructor = ReflectConstructor.getConstructor(Object.class);
        constructor.newInstance(new Object());
    }

    // fails to initialise field
    static void constructWithNull() throws Exception {
        Constructor constructor = ReflectConstructor.getConstructor(Object.class);
        constructor.newInstance((Object) null);
    }
}
