package checker.nullness;

import java.lang.reflect.Method;

/**
 * Assignment of a null reference using method invoked *intraprocedurally* via reflection.
 */
public class ReflectMethodInvokeIntraProcedural {

    public static void main(String[] args) throws Exception {
        String s;
        Method m;
        ReflectMethodInvokeIntraProcedural foo = new ReflectMethodInvokeIntraProcedural();

        // assignment to a non-null reference by reflection
        m = checker.nullness.ReflectMethodInvokeIntraProcedural.class.getDeclaredMethod("returnText");
        s = (String) m.invoke(foo);  // safe
        System.out.println(s.toString());  // "text"

        // assignment to a null reference by reflection
        m = checker.nullness.ReflectMethodInvokeIntraProcedural.class.getDeclaredMethod("returnNull");
        s = (String) m.invoke(foo);  // unsafe
        System.out.println(s.toString());  // NullPointerException
    }

    private static String returnText() {
        return "text";
    }

    private static String returnNull() {
        return null;
    }
}
