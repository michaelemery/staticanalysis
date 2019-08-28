package init;

import java.lang.reflect.Constructor;

/**
 * Initialisation of field via reflective constructor.
 */
public class ReflectConstructor {

    Object foo;

    ReflectConstructor(Object object) {
        this.foo = object;
    }

    static Constructor getConstructor(Class Object) throws NoSuchMethodException {
        return ReflectConstructor.class.getDeclaredConstructor(Object);
    }

    /**
     * Field set to non-null never throws NullPointerException.
     */
    public static void setFooToNonNull() throws Exception {
        Constructor constructor = getConstructor(Object.class);
        ((ReflectConstructor) constructor.newInstance(new Object())).foo.toString();
    }

    /**
     * Field set to null always throws NullPointerException.
     *
     * @throws NullPointerException Checker should warn on compile.
     */
    public static void setFooToNull() throws Exception {
        Constructor constructor = getConstructor(Object.class);
        ((ReflectConstructor) constructor.newInstance((Object) null)).foo.toString();
    }
}
