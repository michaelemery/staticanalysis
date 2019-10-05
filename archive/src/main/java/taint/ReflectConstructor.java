package taint;

import org.checkerframework.checker.tainting.qual.Untainted;

import java.lang.reflect.Constructor;

/**
 * Check tainting of field set via reflective constructor call.
 */
public class ReflectConstructor {

    @Untainted Object foo;

    ReflectConstructor(@Untainted Object object) {
        this.foo = object;
    }

    static Constructor getConstructor(Class... args) throws NoSuchMethodException {
        return ReflectConstructor.class.getDeclaredConstructor(args);
    }

    /**
     * Untainted field never throws Exception.
     */
    public static void setFooToUntainted() throws Exception {
        Constructor constructor = getConstructor(Object.class);
        ReflectConstructor i =
                (ReflectConstructor) constructor.newInstance(new @Untainted Object());
    }

    /**
     * Tainted field always throws Exception.
     */
    public static void setFooToTainted() throws Exception {
        Constructor constructor = getConstructor(Object.class);
        ReflectConstructor i =
                (ReflectConstructor) constructor.newInstance(new Object());
    }
}
