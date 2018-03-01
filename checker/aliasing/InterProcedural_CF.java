package aliasing;

import org.checkerframework.common.aliasing.qual.Unique;

/**
 * Inter-procedural corruption of an object via an alias.
 */
public class InterProcedural_CF {

    String s;

    public InterProcedural_CF(String s) {
        this.s = s;
    }

    public static void main(String[] args) {
        @Unique InterProcedural_CF foo = new InterProcedural_CF("text");
        InterProcedural_CF bar;

        // protect an object through cloning (correct)
        bar = foo.makeCopy();
        bar.s = null;
        System.out.println(foo.s.toString());  // "text"

        // corrupt an object via an alias (fail)
        bar = foo.alias();
        bar.s = null;
        System.out.println(foo.s.toString());  // NullPointerException

    }

    public InterProcedural_CF makeCopy() {
        InterProcedural_CF copy = new InterProcedural_CF(this.s);
        return copy;
    }

    public InterProcedural_CF alias() {
        return this;
    }

}