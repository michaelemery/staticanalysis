package aliasing;

/**
 * Interprocedural corruption of an object via an alias.
 */
public class Interprocedural {

    private String s;

    public Interprocedural(String s) {
        this.s = s;
    }

    public static void main(String[] args) {
        Interprocedural foo = new Interprocedural("text");
        Interprocedural bar;

        // protect an object through cloning (correct)
        bar = foo.makeCopy();
        bar.s = null;
        System.out.println(foo.s.toString());  // "text"

        // corrupt an object via an alias (fail)
        bar = foo.alias();
        bar.s = null;
        System.out.println(foo.s.toString());  // NullPointerException

    }

    public Interprocedural makeCopy() {
        Interprocedural copy = new Interprocedural(this.s);
        return copy;
    }

    public Interprocedural alias() {
        return this;
    }

}
