package aliasing;

import org.checkerframework.common.aliasing.qual.Unique;

/**
 * Inter-procedural corruption of an object via an alias.
 */
public class Interprocedural_CF {

    String s;

    public Interprocedural_CF(String s) {
        this.s = s;
    }

    public static void main(String[] args) {
        @Unique Interprocedural_CF foo = new Interprocedural_CF("text");
        Interprocedural_CF bar;

        // protect an object through cloning (correct)
        bar = foo.makeCopy();
        bar.s = null;
        System.out.println(foo.s.toString());  // "text"

        // corrupt an object via an alias (fail)
        bar = foo.alias();
        bar.s = null;
        System.out.println(foo.s.toString());  // NullPointerException

    }

    public Interprocedural_CF makeCopy() {
        Interprocedural_CF copy = new Interprocedural_CF(this.s);
        return copy;
    }

    public Interprocedural_CF alias() {
        return this;
    }

}
