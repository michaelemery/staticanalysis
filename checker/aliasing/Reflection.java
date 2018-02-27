package aliasing;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Inter-procedural (reflection) corruption of an object via an alias.
 */
public class Reflection {

    String s;

    public Reflection(String s) {
        this.s = s;
    }

    public static void main(String[] args) {
        Reflection foo = new Reflection("text");
        Reflection bar;
        Method m;

        try {

            // protect an object through cloning (correct)
            m = Reflection.class.getDeclaredMethod("makeCopy");
            bar = (Reflection) m.invoke(foo);
            bar.s = null;
            System.out.println(foo.s.toString());  // "text"

            // corrupt an object via an alias (fail)
            m = Reflection.class.getDeclaredMethod("alias");
            bar = (Reflection) m.invoke(foo);
            bar.s = null;
            System.out.println(foo.s.toString());  // NullPointerException

        } catch (NoSuchMethodException |
                IllegalAccessException |
                InvocationTargetException x) {
            x.printStackTrace();
        }

    }

    public Reflection makeCopy() {
        Reflection copy = new Reflection(this.s);
        return copy;
    }

    public Reflection alias() {
        return this;
    }

}