package a;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Refactor 
 *
 */
public class A {

    public static void main (String... args) {

        // internal call
        System.out.println(message());
        // "a.A"

        // external package call
        System.out.println(b.B.message());
        // "b.B"

        try {
            // internal call via reflection
            Method aMessage = a.A.class.getDeclaredMethod("message");
            System.out.println(aMessage.invoke(null));
            // "a.A"

            // external package call via reflection
            Method cMessage = b.B.class.getDeclaredMethod("message");
            System.out.println(cMessage.invoke(null));
            // "b.B"

        } catch (NoSuchMethodException |
                IllegalAccessException |
                InvocationTargetException x) {
            x.printStackTrace();
        }
    }

    public static String message() {
        return(A.class.getCanonicalName());
    }

}
