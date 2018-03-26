package nullness;

import java.lang.reflect.Field;

/**
 * Assignment of a null reference to a field accessed *intraprocedurally* via reflection.
 */
public class ReflectFieldAccessIntraProcedural {
    public String bar;

    public static void main(String[] args) throws Exception {
        ReflectFieldAccessIntraProcedural foo = new ReflectFieldAccessIntraProcedural();
        Class<?> c = foo.getClass();
        Field s = c.getDeclaredField("bar");

        // set a field to a non-null by reflection
        s.set(foo, "text");  // safe
        System.out.println(foo.bar.toString());  // "text"

        // set a field to a null by reflection
        s.set(foo, null);  // unsafe
        System.out.println(foo.bar.toString());  // NullPointerException
    }
}
