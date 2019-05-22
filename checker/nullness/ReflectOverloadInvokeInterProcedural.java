package checker.nullness;

import java.lang.reflect.Method;

/**
 * Overloaded interprocedural assignment of a null reference via reflection.
 */
public class ReflectOverloadInvokeInterProcedural {

    public static void main(String[] args) throws Exception {
        String s;
        Method m;
        ReflectOverloadInvokeInterProcedural foo = new ReflectOverloadInvokeInterProcedural();
        
        // assignment to a non-null reference by overloaded reflection
        m = ReflectOverloadInvokeInterProcedural.class.getDeclaredMethod("returnText", Integer.TYPE);
        s = (String) m.invoke(foo, 42);  // safe
        System.out.println(s.toString());  // "text"

        // assignment to a null reference by overloaded reflection
        m = ReflectOverloadInvokeInterProcedural.class.getDeclaredMethod("returnText", Boolean.TYPE);
        s = (String) m.invoke(foo, true);  // unsafe
        System.out.println(s.toString());  // NullPointerException
    }

    private static String returnText(int i) {
        return "text";
    }

    private static String returnText(boolean b) {
        return null;
    }
}
