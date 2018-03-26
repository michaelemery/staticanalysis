package nullness;

import java.lang.reflect.Method;

/**
 * Assignment of a null reference using method invoked *interprocedurally* via reflection. 
 */
public class ReflectMethodInvokeInterProcedural {

    public static void main(String[] args) throws Exception {
        String s;
        ReflectMethodInvokeInterProcedural foo = new ReflectMethodInvokeInterProcedural();

        // assignment to a non-null reference by reflection
        s = foo.getStringFromMethod("returnText");  // safe
        System.out.println(s.toString());  // "text"

        // assignment to a null reference by reflection
        s = foo.getStringFromMethod("returnNull");  // unsafe
        System.out.println(s.toString());  // NullPointerException
    }

    public String getStringFromMethod(String methodName) throws Exception {
        Method m = ReflectMethodInvokeInterProcedural.class.getDeclaredMethod(methodName);
        String s = (String) m.invoke(this);
        return s;
    }

    public static String returnText() {
        return "text";
    }

    public static String returnNull() {
        return null;
    }
}
