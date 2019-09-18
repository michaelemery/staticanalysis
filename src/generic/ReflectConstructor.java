package generic;

import java.lang.reflect.Constructor;

/**
 * generic example of using reflective constructor. TODO: discuss, maybe duplicate with DynamicAllocation example
 */
public class ReflectConstructor {

    Object foo;
    Object bar=new Object();

    ReflectConstructor(Object object) {
        this.foo = object;
    }

    static Constructor getConstructor(Class... args) throws NoSuchMethodException {
        return ReflectConstructor.class.getDeclaredConstructor(args);
    }

    /**
     * a FP if it is reported. otherwise a TP
     */
    public static void setFooToNonNull() throws Exception {
        Constructor constructor = getConstructor(Object.class);
        ((ReflectConstructor) constructor.newInstance(new Object())).foo.toString();
    }

    /**
     *  a FN if it is NOT reported, otherwise a TP
     * @throws java.lang.NullPointerException
     */
    public static void setBarToNull() throws Exception {
        Constructor constructor = getConstructor(Object.class);
        ((ReflectConstructor) constructor.newInstance((Object) null)).bar.toString();
    }
}
