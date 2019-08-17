package init;

/**
 * Intra-procedural initialisation of an object attribute.
 */
public class IntraProcedural {

    Object object;

    // constructor initialises field
    public IntraProcedural() {
        object = new Object();
        object.toString();
    }

    // constructor fails to initialise field
    IntraProcedural(int x) {
        object.toString();
    }

    // constructor accesses field before initialised
    IntraProcedural(int x, int y) {
        object.toString();
        object = new Object();
    }
}