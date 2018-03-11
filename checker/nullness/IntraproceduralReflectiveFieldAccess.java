package nullness;

import java.lang.reflect.Field;

/**
 * Assignment of a null reference to a field accessed *intraprocedurally* via reflection.
 */
public class IntraproceduralReflectiveFieldAccess {
    public String bar;

    public static void main(String[] args) throws Exception {
        IntraproceduralReflectiveFieldAccess foo = new IntraproceduralReflectiveFieldAccess();
        Class<?> c = foo.getClass();
        Field s = c.getDeclaredField("bar");

        // set a field to a non-null by reflection (correct)
        s.set(foo, "text");
        System.out.println(foo.bar.toString());  // "text"

        // set a field to a null by reflection (fail)
        s.set(foo, null);
        System.out.println(foo.bar.toString());  // NullPointerException
    }
}
