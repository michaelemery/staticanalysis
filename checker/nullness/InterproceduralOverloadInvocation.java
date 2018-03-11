package nullness;

import java.lang.reflect.Method;

/**
 * Overloaded interprocedural assignment of a null reference via reflection.
 */
public class InterproceduralOverloadInvocation {

    public static void main(String[] args) throws Exception {
        String s;
        Method m;
        InterproceduralOverloadInvocation foo = new InterproceduralOverloadInvocation();
        
        // assignment to a non-null reference by overloaded reflection (correct)
        m = InterproceduralOverloadInvocation.class.getDeclaredMethod("returnText", Integer.TYPE);
        s = (String) m.invoke(foo, 42);
        System.out.println(s.toString());  // "text"

        // assignment to a null reference by overloaded reflection (fail)
        m = InterproceduralOverloadInvocation.class.getDeclaredMethod("returnText", Boolean.TYPE);
        s = (String) m.invoke(foo, true);
        System.out.println(s.toString());  // NullPointerException
    }

    public static String returnText(int i) {
        return "text";
    }

    public static String returnText(boolean b) {
        return null;
    }
}
