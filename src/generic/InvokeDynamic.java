package generic;

/**
 * generic example of using invokedyanmic instruction
 */
public class InvokeDynamic {

    Object foo;
    Object bar=new Object();

    void setFoo(Object foo){
        this.foo=foo;
    }
    void setBar(Object bar){
        this.bar=bar;
    }

    /**
     * a FP if it is reported. otherwise a TP
     */
    public static void setFooToNotNull(){
        InvokeDynamic i= new InvokeDynamic();
        java.util.function.Consumer<Object> c = foo -> i.setFoo(foo);
        c.accept(new Object());
        i.foo.toString();
    }

    /**
     * a FN if it is NOT reported, otherwise a TP
     * @throws java.lang.NullPointerException
     */
    public static void setBarToNull(){
        InvokeDynamic i= new InvokeDynamic();
        java.util.function.Consumer<Object> c = foo -> i.setBar(foo);
        c.accept(null);
        i.bar.toString();
    }
}
