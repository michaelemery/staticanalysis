package aliasing;

/**
 * Intra-procedural corruption of an object via an alias.
 */
public class IntraProcedural_CF {

    String s;

    public IntraProcedural_CF(String s) {
        this.s = s;
    }

    public IntraProcedural_CF(IntraProcedural_CF copy) {
        this.s = copy.s;
    }

    public static void main(String[] args) {
        @Unique IntraProcedural_CF foo = new IntraProcedural_CF("text");
        IntraProcedural_CF bar;

        // protect an object through cloning (correct)
        bar = new IntraProcedural_CF(foo);
        bar.s = null;
        System.out.println(foo.s.toString());  // "text"

        // corrupt an object via an alias (fail)
        bar = foo;
        bar.s = null;
        System.out.println(foo.s.toString());  // NullPointerException

    }

}