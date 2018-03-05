package nullness;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Interprocedural assignment of a null reference via reflection. 
 */
public class Reflection {

    public static void main(String[] args) throws Exception {

        Method m;
        String s;

        // assignment to a non-null reference by reflection (correct)
        m = nullness.Reflection.class.getDeclaredMethod("returnText");
        s = (String) m.invoke(null);
        System.out.println(s.toString());  // "text"

        // assignment to a null reference by reflection (fail)
        m = nullness.Reflection.class.getDeclaredMethod("returnNull");
        s = (String) m.invoke(null);
        System.out.println(s.toString());  // NullPointerException

    }

    public static String returnText() {
        return "text";
    }

    public static String returnNull() {
        return null;
    }

}