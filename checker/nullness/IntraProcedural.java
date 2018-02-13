package nullness;

/**
 * IntraProcedural assignment to a null reference.
 */
public class IntraProcedural {

    String s;

    public IntraProcedural(String s) {
        this.s = s;
    }

    public static void main(String[] args) throws NullPointerException {

        // IntraProcedural assignment to non-null (correct)
        IntraProcedural foo = new IntraProcedural("text");
        System.out.println(foo.s.toString());  // "text"

        // IntraProcedural assignment to null (fail)
        foo = null;
        System.out.println(foo.s.toString());  // NullPointerException

    }

}