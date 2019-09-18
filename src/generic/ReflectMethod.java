package generic;

import java.lang.reflect.Method;

/**
 *  generic example of setting a field via reflective method return. It is also a case of aliasing.
 */
public class ReflectMethod {
    Object foo;
    Object bar=new Object();

    Object getObject() { return new Object(); }

    Object getNullObject(){ return null; }

    /**
     * a FP if it is reported. otherwise a TP
     */
    public static void setFooToNonNull() throws Exception {
        ReflectMethod i = new ReflectMethod();
        Method getObjectMethod =
                i.getClass().getDeclaredMethod("getObject");
        i.foo = getObjectMethod.invoke(i);
        i.foo.toString();
    }

    /**
     *  a FN if it is NOT reported, otherwise a TP
     * @throws java.lang.NullPointerException
     */
    public static void setBarToNull() throws Exception {
        ReflectMethod i = new ReflectMethod();
        Method getObjectMethod =
                i.getClass().getDeclaredMethod("getNullObject");
        i.bar = getObjectMethod.invoke(i);
        i.bar.toString();
    }
}
