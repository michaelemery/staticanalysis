package checker.init;

/**
 * Constructor accesses uninitialised field via intra-procedural call
 */
public class IntraProcedural {

    String s;

    // only initialises if argument is true
    IntraProcedural(Boolean safe) {
        if (safe) this.s = "safe";
    }

    public static void main(String[] args) throws NullPointerException {

        // safe
        System.out.println(new IntraProcedural(true).s);

        //unsafe
        System.out.println(new IntraProcedural(false).s);
    }
}
