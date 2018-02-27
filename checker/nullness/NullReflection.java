package nullness;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Assignment to a null reference by reflection.
 */
public class NullReflection {

    String s;

    public NullReflection(String s) {
        this.s = s;
    }

    public static void main(String[] args) {

        Method m;

        try {
            // assignment to a non-null reference by reflection (correct)
            m = nullness.NullReflection.class.getDeclaredMethod("returnText");
            NullReflection foo = new NullReflection((String) m.invoke(null));
            System.out.println(foo.s.toString());  // "text"

            // assignment to a null reference by reflection (fail)
            m = nullness.NullReflection.class.getDeclaredMethod("returnNull");
            NullReflection bar = new NullReflection((String) m.invoke(null));
            System.out.println(bar.s.toString());  // NullPointerException
            
        } catch (NoSuchMethodException |
                IllegalAccessException |
                InvocationTargetException x) {
            x.printStackTrace();
        }

    }

    public static String returnText() {
        return "text";
    }

    public static String returnNull() {
        return null;
    }

}