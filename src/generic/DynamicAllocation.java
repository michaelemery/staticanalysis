package generic;

/**
 *  generic example of dynamic allocation. init an object without using the new keyword.
 *  We could extend it to class loading
 *
 */
public class DynamicAllocation {

    DynamicAllocation foo;
    /**
     * a FP if it is reported. otherwise a TP
     */
    public static void initFoo() throws Exception {
        DynamicAllocation i =new DynamicAllocation();
        Class claz= Class.forName("generic.DynamicAllocation");
        i.foo=(DynamicAllocation)claz.newInstance();
        i.foo.toString();
    }
}
