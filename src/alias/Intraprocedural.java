package alias;

import org.checkerframework.common.aliasing.qual.NonLeaked;
import org.checkerframework.common.aliasing.qual.Unique;

/**
 * Intraprocedural corruption of an object via an alias.
 */
public class IntraProcedural {

    Object o;

    @NonLeaked @Unique IntraProcedural() {
        this.o = "safe";
    }

    ;

    public static void main(String[] args) {

        /* safe: non-leaky object set */
        @Unique IntraProcedural original = new IntraProcedural();
        System.out.println(original.o.toString());

        /* unsafe: make object null via alias */
        IntraProcedural alias = original;
        alias.o = null;
        System.out.println(original.o.toString());
    }
}
