package alias;

import org.checkerframework.common.aliasing.qual.Unique;

/**
 * Intra-procedural corruption of an object via an alias.
 */
public class Vanilla_CF {

    String s;

    public Vanilla_CF(String s) {
        this.s = s;
    }

    public Vanilla_CF(Vanilla_CF copy) {
        this.s = copy.s;
    }

    public static void main(String[] args) {
        @Unique Vanilla_CF foo = new Vanilla_CF("text");
        Vanilla_CF bar;

        // protect an object through cloning (correct)
        bar = new Vanilla_CF(foo);
        bar.s = null;
        System.out.println(foo.s.toString());  // "text"

        // corrupt an object via an alias (fail)
        bar = foo;
        bar.s = null;
        System.out.println(foo.s.toString());  // NullPointerException

    }

}