package aliasing;

/**
 * Inter-procedural corruption of an object via an alias.
 */
public class InterProcedural {

    String s;

    public InterProcedural(String s) {
        this.s = s;
    }

    public static void main(String[] args) {
        InterProcedural foo = new InterProcedural("text");
        InterProcedural bar;

        // protect an object through cloning (correct)
        bar = foo.makeCopy();
        bar.s = null;
        System.out.println(foo.s.toString());  // "text"

        // corrupt an object via an alias (fail)
        bar = foo.alias();
        bar.s = null;
        System.out.println(foo.s.toString());  // NullPointerException

    }

    public InterProcedural makeCopy() {
        InterProcedural copy = new InterProcedural(this.s);
        return copy;
    }

    public InterProcedural alias() {
        return this;
    }

}