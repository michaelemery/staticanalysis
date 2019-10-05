package generic;

import java.lang.invoke.MethodHandles;

public class MethodHandleField {

    Object foo;
    Object bar =new Object();

    /**
     * a FP if it is reported. otherwise a TP
     */
    public static void setFooToNonNull() throws Throwable {
        MethodHandleField i =new MethodHandleField();
        MethodHandles.Lookup l = MethodHandles.lookup();
        l.findSetter(MethodHandleField.class, "foo", Object.class).invoke(i, new Object());
        i.foo.toString();
    }

    /**
     *  a FN if it is NOT reported, otherwise a TP
     * @throws java.lang.NullPointerException
     */
    public static void setBarToNull() throws Throwable {
        MethodHandleField i =new MethodHandleField();
        MethodHandles.Lookup l = MethodHandles.lookup();
        l.findSetter(MethodHandleField.class, "bar", Object.class).invoke(i, null);
        i.bar.toString();
    }
}
