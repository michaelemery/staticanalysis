package aliasing;

import org.checkerframework.common.aliasing.qual.Unique;

/**
 * Inter-procedural corruption of an object via an alias.
 */
public class Vanilla_CF {

    String s;

    public Vanilla_CF(String s) {
        this.s = s;
    }

    public static void main(String[] args) {
        @Unique Vanilla_CF foo = new Vanilla_CF("text");
        Vanilla_CF bar;

        // protect an object through cloning (correct)
        bar = foo.makeCopy();
        bar.s = null;
        System.out.println(foo.s.toString());  // "text"

        // corrupt an object via an alias (fail)
        bar = foo.alias();
        bar.s = null;
        System.out.println(foo.s.toString());  // NullPointerException

    }

    public Vanilla_CF makeCopy() {
        Vanilla_CF copy = new Vanilla_CF(this.s);
        return copy;
    }

    public Vanilla_CF alias() {
        return this;
    }

}