package aliasing;

/**
 * Intraprocedural corruption of an object via an alias.
 */
public class Vanilla {

    String s;

    public Vanilla(String s) {
        this.s = s;
    }

    public Vanilla(Vanilla copy) {
        this.s = copy.s;
    }

    public static void main(String[] args) {
        Vanilla foo = new Vanilla("text");
        Vanilla bar;

        // protect an object through cloning (correct)
        bar = new Vanilla(foo);
        bar.s = null;
        System.out.println(foo.s.toString());  // "text"

        // corrupt an object via an alias (fail)
        bar = foo;
        bar.s = null;
        System.out.println(foo.s.toString());  // NullPointerException

    }

}