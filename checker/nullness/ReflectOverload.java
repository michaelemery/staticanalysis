package nullness;

import java.lang.reflect.Method;

/**
 * Overloaded interprocedural assignment of a null reference via reflection.
 */
public class ReflectOverload {

    public static void main(String[] args) throws Exception {

        Method m;
        String s;

        // assignment to a non-null reference by overloaded reflection (correct)
        m = ReflectOverload.class.getDeclaredMethod("returnText", Integer.TYPE);
        s = (String) m.invoke(null, 42);
        System.out.println(s.toString());  // "text"

        // assignment to a null reference by overloaded reflection (fail)
        m = ReflectOverload.class.getDeclaredMethod("returnText", Boolean.TYPE);
        s = (String) m.invoke(null, true);
        System.out.println(s.toString());  // NullPointerException

    }

    public static String returnText(int i) {
        return "text";
    }

    public static String returnText(boolean b) {
        return null;
    }

}
