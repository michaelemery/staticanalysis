package aliasing;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Inter-procedural (using reflection) corruption of an object via an alias.
 */
public class Reflection_CF {

    String s;

    public Reflection_CF(String s) {
        this.s = s;
    }

    public static void main(String[] args) {
        @Unique Reflection_CF foo = new Reflection_CF("text");
        Reflection_CF bar;
        Method m;

        try {

            // protect an object through cloning (correct)
            m = Reflection_CF.class.getDeclaredMethod("makeCopy");
            bar = (Reflection_CF) m.invoke(foo);
            bar.s = null;
            System.out.println(foo.s.toString());  // "text"

            // corrupt an object via an alias (fail)
            m = Reflection_CF.class.getDeclaredMethod("alias");
            bar = (Reflection_CF) m.invoke(foo);
            bar.s = null;
            System.out.println(foo.s.toString());  // NullPointerException

        } catch (NoSuchMethodException |
                IllegalAccessException |
                InvocationTargetException x) {
            x.printStackTrace();
        }

    }

    public Reflection_CF makeCopy() {
        Reflection_CF copy = new Reflection_CF(this.s);
        return copy;
    }

    public Reflection_CF alias() {
        return this;
    }

}