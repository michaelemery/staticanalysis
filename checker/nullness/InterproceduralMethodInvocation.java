package nullness;

import java.lang.reflect.Method;

/**
 * Assignment of a null reference using method invoked *interprocedurally* via reflection. 
 */
public class InterproceduralMethodInvocation {

    public static void main(String[] args) throws Exception {

        String s;

        // assignment to a non-null reference by reflection (correct)
        s = getStringFromMethod("returnText");
        System.out.println(s.toString());  // "text"

        // assignment to a null reference by reflection (fail)
        s = getStringFromMethod("returnNull");
        System.out.println(s.toString());  // NullPointerException

    }

    public static String getStringFromMethod(String methodName) throws Exception {
        Method m = InterproceduralMethodInvocation.class.getDeclaredMethod(methodName);
        String s = (String) m.invoke(null);
        return s;
    }

    public static String returnText() {
        return "text";
    }

    public static String returnNull() {
        return null;
    }

}
