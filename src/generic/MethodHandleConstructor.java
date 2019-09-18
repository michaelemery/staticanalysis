package generic;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

public class MethodHandleConstructor {

    Object foo;
    Object bar=new Object();

    MethodHandleConstructor(){
        //default constructor
    }

    MethodHandleConstructor(Object foo,Object bar){
        this.foo=foo;
        this.bar=bar;
    }
    /**
     * a FP if it is reported. otherwise a TP
     */
    public static void setFooToNonNull() throws Throwable {

        MethodHandles.Lookup lookup = MethodHandles.lookup();
        MethodType type = MethodType.methodType(void.class, Object.class,Object.class);
        MethodHandleConstructor i =(MethodHandleConstructor)lookup.findConstructor(MethodHandleConstructor.class,  type).invoke(new Object(),new Object());
        i.foo.toString();
    }

    /**
     *  a FN if it is NOT reported, otherwise a TP
     * @throws java.lang.NullPointerException
     */
    public static void setBarToNull() throws Throwable {
        MethodHandles.Lookup lookup = MethodHandles.lookup();
        MethodType type = MethodType.methodType(void.class, Object.class,Object.class);
        MethodHandleConstructor i =(MethodHandleConstructor)lookup.findConstructor(MethodHandleConstructor.class,  type).invoke(null,null);
        i.bar.toString();
    }
}
