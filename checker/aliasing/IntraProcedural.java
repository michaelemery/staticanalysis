package aliasing;

/**
 * Intra-procedural corruption of an object via an alias.
 */
public class IntraProcedural {

    String s;

    public IntraProcedural(String s) {
        this.s = s;
    }

    public IntraProcedural(IntraProcedural copy) {
        this.s = copy.s;
    }

    public static void main(String[] args) {
        IntraProcedural foo = new IntraProcedural("text");
        IntraProcedural bar;

        // protect an object through cloning (correct)
        bar = new IntraProcedural(foo);
        bar.s = null;
        System.out.println(foo.s.toString());  // "text"

        // corrupt an object via an alias (fail)
        bar = foo;
        bar.s = null;
        System.out.println(foo.s.toString());  // NullPointerException

    }

}