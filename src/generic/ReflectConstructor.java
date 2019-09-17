package generic;

import java.lang.reflect.Constructor;

/**
 * generic example of  via reflective constructor call.
 */
public class ReflectConstructor {

    Object foo;

    ReflectConstructor(Object object) {
        this.foo = object;
    }

    static Constructor getConstructor(Class... args) throws NoSuchMethodException {
        return ReflectConstructor.class.getDeclaredConstructor(args);
    }

    /**
     * Field set to non-null never throws NullPointerException.
     *  may result as a FP
     */
    public static void setFooToNonNull() throws Exception {
        Constructor constructor = getConstructor(Object.class);
        ((ReflectConstructor) constructor.newInstance(new Object())).foo.toString();
    }

    /**
     * Field set to null always throws NullPointerException.
     */
    public static void setFooToNull() throws Exception {
        Constructor constructor = getConstructor(Object.class);
        ((ReflectConstructor) constructor.newInstance((Object) null)).foo.toString();
    }
}