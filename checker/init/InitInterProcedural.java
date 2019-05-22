package checker.init;

/**
 * Constructor accesses uninitialised field via inter-procedural call
 */
public class InitInterProcedural {

    private String s;

    // safe: field is initialised
    InitInterProcedural(String x) {
        this.s = x;
    }

    // unsafe: field is not initialised
    InitInterProcedural(String x, String y) {
    }

    public static void main(String[] args) throws NullPointerException {
        System.out.println(makeStringSafe("safe"));
        System.out.println(makeStringUnsafe("unsafe", "unsafe"));
    }

    private static String makeStringSafe(String x) {
        return new InitInterProcedural(x).s;
    }

    private static String makeStringUnsafe(String x, String y) {
        return new InitInterProcedural(x, y).s;
    }
}
