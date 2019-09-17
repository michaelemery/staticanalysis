package generic;

/**
 * generic example of using invokedyanmic instruction
 */
public class InvokeDynamic {

    Object foo;

    Object getObject(Object foo){
        return foo;
    }

    /**
     * may result as a FP
     * @throws Exception
     */
    public static void setFooToNotNull() throws Exception{
        InvokeDynamic i= new InvokeDynamic();
        java.util.function.Supplier<Object> c = ()-> i.getObject(new Object());
        i.foo=c.get();
        i.foo.toString();
    }

    /**
     *
     * @throws Exception
     */
    public static void setFooToNull() throws Exception{
        InvokeDynamic i= new InvokeDynamic();
        java.util.function.Supplier<Object> c = ()-> i.getObject(null);
        i.foo=c.get();
        i.foo.toString();
    }
}
