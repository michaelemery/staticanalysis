package generic;

/**
 *  generic example of dynamic allocation. init an object without using the new keyword
 *
 *   may report it as a FP
 */
public class DynamicAllocation {

    DynamicAllocation foo;
    /**
     * init an object via newInstance, may result as a FP
     * @throws Exception
     */
    public static void loadClass() throws Exception {
        DynamicAllocation i =new DynamicAllocation();
        Class claz= Class.forName("generic.DynamicAllocation");
        i.foo=(DynamicAllocation) claz.newInstance();
        i.foo.toString();
    }
}
