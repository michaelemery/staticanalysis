package nullness;

/**
 * Assignment to a null reference by alias.
 */
public class IntraAlias {

    String s;

    public IntraAlias(String s) {
        this.s = s;
    }

    public static void main(String[] args) throws NullPointerException {

        // assignment to non-null by alias (correct)
        IntraAlias foo = new IntraAlias("text");
        IntraAlias bar = foo;
        System.out.println(bar.s.toString());  // "text"

        // assignment to null by alias (fail)
        foo = null;
        bar = foo;
        System.out.println(bar.s.toString());  // NullPointerException

    }

}