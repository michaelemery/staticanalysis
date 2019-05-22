package checker.init;

/**
 * Constructor accesses uninitialised field via intra-procedural call
 */
public class InitIntraProcedural {

    String s;

    // safe: field is initialised
    InitIntraProcedural(String x) {
        this.s = x;
    }

    // unsafe: field is not initialised
    InitIntraProcedural(String x, String y) {
    }

    public static void main(String[] args) throws NullPointerException {
        System.out.println(new InitIntraProcedural("safe").s);
        System.out.println(new InitIntraProcedural("unsafe", "unsafe").s);
    }
}
