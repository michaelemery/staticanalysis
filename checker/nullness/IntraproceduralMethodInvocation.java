package nullness;

import java.lang.reflect.Method;

/**
 * Assignment of a null reference using method invoked *intraprocedurally* via reflection.
 */
public class IntraproceduralMethodInvocation {

    public static void main(String[] args) throws Exception {
        String s;
        Method m;
        IntraproceduralMethodInvocation foo = new IntraproceduralMethodInvocation();

        // assignment to a non-null reference by reflection (correct)
        m = nullness.IntraproceduralMethodInvocation.class.getDeclaredMethod("returnText");
        s = (String) m.invoke(foo);
        System.out.println(s.toString());  // "text"

        // assignment to a null reference by reflection (fail)
        m = nullness.IntraproceduralMethodInvocation.class.getDeclaredMethod("returnNull");
        s = (String) m.invoke(foo);
        System.out.println(s.toString());  // NullPointerException
    }

    public static String returnText() {
        return "text";
    }

    public static String returnNull() {
        return null;
    }
}
