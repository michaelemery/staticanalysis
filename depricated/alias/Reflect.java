package alias;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Inter-procedural (reflection) corruption of an object via an alias.
 */
public class Reflect {

    String s;

    public Reflect(String s) {
        this.s = s;
    }

    public static void main(String[] args) {
        Reflect foo = new Reflect("text");
        Reflect bar;
        Method m;

        try {

            // protect an object through cloning (correct)
            m = Reflect.class.getDeclaredMethod("makeCopy");
            bar = (Reflect) m.invoke(foo);
            bar.s = null;
            System.out.println(foo.s.toString());  // "text"

            // corrupt an object via an alias (fail)
            m = Reflect.class.getDeclaredMethod("alias");
            bar = (Reflect) m.invoke(foo);
            bar.s = null;
            System.out.println(foo.s.toString());  // NullPointerException

        } catch (NoSuchMethodException |
                IllegalAccessException |
                InvocationTargetException x) {
            x.printStackTrace();
        }

    }

    public Reflect makeCopy() {
        Reflect copy = new Reflect(this.s);
        return copy;
    }

    public Reflect alias() {
        return this;
    }

}