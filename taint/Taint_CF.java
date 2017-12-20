import org.checkerframework.checker.tainting.qual.Untainted;

/**
 * Taint_CF.java
 *
 * Provide a template to test the effectiveness of static analysis tools in identifying
 * certain kinds of trust errors.
 *
 * Created by Michael Emery on 30/11/17.
 */
public class Taint_CF {

    public @Untainted String u = "untainted";

    public static void main(String[] args) {

        String t = "tainted";

        // taint an untainted string with a tainted string
        @Untainted String u1 = "untainted";
        u1 += " -> " + t;
        System.out.println(u1);  // untainted -> tainted

        // taint an untainted string with a tainted method return
        @Untainted String u2 = "untainted";
        u2 += taint(t);
        System.out.println(u2);  // untainted -> tainted

        // taint an untainted reference
        @Untainted Taint_CF u3 = new Taint_CF();
        u3.taintInstance(t);
        System.out.println(u3.u);  // untainted -> tainted

        // taint an untainted reference
        @Untainted Taint_CF u4 = new Taint_CF();
        Taint_CF t4 = u4;
        t4.taintInstance(t);
        System.out.println(u4.u);  // untainted -> tainted

        // wrapping an untainted object
        Object u5 = wrap(new Object());
        System.out.println(u5);  // null
    }

    public static String taint(String t) {
        return " -> " + t;
    }

    public void taintInstance(String t) {
        this.u += " -> " + t;
    }

    static <T, U extends T> Wrap<T> wrap(U u) {
        return null;
    }

    static class Wrap<T> {
    }
}
