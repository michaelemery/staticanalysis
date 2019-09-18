package generic;

import java.io.File;

/**
 * command to compile c code in linux:
 * gcc -fPIC -I"$JAVA_HOME/include" -I"$JAVA_HOME/include/linux" -shared -o resources/nativeAllocation.so resources/nativeAllocation.c
 *
 * command to compile c code in MacOS:
 * TODO:
 *
 */
public class NativeAllocation {

    static{
        //load native library in Linux
        System.load(new File("resources/nativeAllocation.so").getAbsolutePath());

    }

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
