package aliasing;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.checkerframework.common.aliasing.qual.Unique;

/**
 * Inter-procedural (reflection) corruption of an object via an alias.
 */
public class Reflect_CF {

    String s;

    public Reflect_CF(String s) {
        this.s = s;
    }

    public static void main(String[] args) {
        @Unique Reflect_CF foo = new Reflect_CF("text");
        Reflect_CF bar;
        Method m;

        try {

            // protect an object through cloning (correct)
            m = Reflect_CF.class.getDeclaredMethod("makeCopy");
            bar = (Reflect_CF) m.invoke(foo);
            bar.s = null;
            System.out.println(foo.s.toString());  // "text"

            // corrupt an object via an alias (fail)
            m = Reflect_CF.class.getDeclaredMethod("alias");
            bar = (Reflect_CF) m.invoke(foo);
            bar.s = null;
            System.out.println(foo.s.toString());  // NullPointerException

        } catch (NoSuchMethodException |
                IllegalAccessException |
                InvocationTargetException x) {
            x.printStackTrace();
        }

    }

    public Reflect_CF makeCopy() {
        Reflect_CF copy = new Reflect_CF(this.s);
        return copy;
    }

    public Reflect_CF alias() {
        return this;
    }

}