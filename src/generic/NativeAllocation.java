package generic;

/**
 * TODO: implement the native code.
 *
 */
public class NativeAllocation {

    Object foo;

    public native Object getObject();

    public native Object getNullObject();

    /**
     * may result as a FP
     * @throws Exception
     */
    public static void setFooToNotNull() throws Exception{
        NativeAllocation i= new NativeAllocation();
        i.foo=i.getObject();
        i.foo.toString();
    }

    /**
     *
     * @throws Exception
     */
    public static void setFooToNull() throws Exception{
        NativeAllocation i= new NativeAllocation();
        i.foo=i.getNullObject();
        i.foo.toString();
    }
}
