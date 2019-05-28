package checker.init;

/**
 * Constructor accesses uninitialised field via inter-procedural call
 */
public class InterProcedural {

    String s;

    InterProcedural(Boolean safe) {
        this.s = getValue(safe);
    }

    public static void main(String[] args) throws NullPointerException {
        System.out.println(new InterProcedural(true).s);
        System.out.println(new InterProcedural(false).s);
    }

    static String getValue(Boolean safe) {
        return safe ? "safe" : null;
    }
}
