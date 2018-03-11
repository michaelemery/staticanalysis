package nullness;

import java.lang.reflect.Method;

/**
 * Assignment of a null reference using method invoked *interprocedurally* via reflection. 
 */
public class InterproceduralMethodInvocation {

    public static void main(String[] args) throws Exception {
        String s;
        InterproceduralMethodInvocation foo = new InterproceduralMethodInvocation();

        // assignment to a non-null reference by reflection (correct)
        s = foo.getStringFromMethod("returnText");
        System.out.println(s.toString());  // "text"

        // assignment to a null reference by reflection (fail)
        s = foo.getStringFromMethod("returnNull");
        System.out.println(s.toString());  // NullPointerException
    }

    public String getStringFromMethod(String methodName) throws Exception {
        Method m = InterproceduralMethodInvocation.class.getDeclaredMethod(methodName);
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
