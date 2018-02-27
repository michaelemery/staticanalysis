package nullness;

/**
 * Assignment to a null reference by alias.
 */
public class NullAlias {

    String s;

    public NullAlias(String s) {
        this.s = s;
    }

    public static void main(String[] args) throws NullPointerException {

        // assignment to non-null by alias (correct)
        NullAlias foo = new NullAlias("text");
        NullAlias bar = foo;
        System.out.println(bar.s.toString());  // "text"

        // assignment to null by alias (fail)
        foo = null;
        bar = foo;
        System.out.println(bar.s.toString());  // NullPointerException

    }

}