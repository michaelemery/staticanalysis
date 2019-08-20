package init;

/**
 * Validate initialisation of an object via layered methods.
 */
public class InterProcedural {

    Object object;

    // initialises field
    InterProcedural() {
        this.object = set();
        this.object.toString();
    }

    // accesses field before initialised
    InterProcedural(int x) {
        this.object.toString();
        this.object = set();
    }

    static Object set() {
        return new Object();
    }
}
