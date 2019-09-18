package generic;

/**
 * TODO: implement the native code.
 *
 */
public class NativeAllocation {

    Object foo;
    Object bar =new Object();

    public native Object getObject();

    public native Object getNullObject();

    /**
     * a FP if it is reported. otherwise a TP
     */
    public static void setFooToNotNull() throws Exception{
        NativeAllocation i= new NativeAllocation();
        i.foo=i.getObject();
        i.foo.toString();
    }

    /**
     *  a FN if it is NOT reported, otherwise a TP
     * @throws java.lang.NullPointerException
     */
    public static void setBarToNull() throws Exception{
        NativeAllocation i= new NativeAllocation();
        i.bar=i.getNullObject();
        i.bar.toString();
    }
}
