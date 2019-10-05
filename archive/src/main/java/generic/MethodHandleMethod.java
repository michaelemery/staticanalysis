package generic;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

public class MethodHandleMethod {

    Object foo;
    Object bar =new Object();

    Object getObject() { return new Object(); }

    Object getNullObject(){ return null; }

    /**
     * a FP if it is reported. otherwise a TP
     */
    public static void setFooToNonNull() throws Throwable {
        MethodHandleMethod i = new MethodHandleMethod();
        MethodHandles.Lookup lookup = MethodHandles.lookup();
        MethodType type = MethodType.methodType(Object.class);
        i.foo=lookup.findVirtual(MethodHandleMethod.class, "getObject", type).invoke(i);
        i.foo.toString();
    }

    /**
     *  a FN if it is NOT reported, otherwise a TP
     * @throws java.lang.NullPointerException
     */
    public static void setBarToNull() throws Throwable {
        MethodHandleMethod i = new MethodHandleMethod();
        MethodHandles.Lookup lookup = MethodHandles.lookup();
        MethodType type = MethodType.methodType(Object.class);
        i.bar=lookup.findVirtual(MethodHandleMethod.class, "getNullObject", type).invoke(i);
        i.bar.toString();
    }
}
