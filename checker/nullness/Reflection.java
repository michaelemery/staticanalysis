package nullness;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Inter-procedural assignment of a null reference via reflection. 
 */
public class InterReflect {

    String s;

    public InterReflect(String s) {
        this.s = s;
    }

    public static void main(String[] args) {

        Method m;

        try {
            
            // assignment to a non-null reference by reflection (correct)
            m = nullness.InterReflect.class.getDeclaredMethod("returnText");
            InterReflect foo = new InterReflect((String) m.invoke(null));
            System.out.println(foo.s.toString());  // "text"

            // assignment to a null reference by reflection (fail)
            m = nullness.InterReflect.class.getDeclaredMethod("returnNull");
            InterReflect bar = new InterReflect((String) m.invoke(null));
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