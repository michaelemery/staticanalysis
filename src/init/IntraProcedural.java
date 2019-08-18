package init;

/**
 * Validate initialisation of an object via a single method.
 */
public class IntraProcedural {

    Object object;

    // initialises field
    IntraProcedural() {
        this.object = new Object();
        this.object.toString();
    }

    // fails to initialise field
    IntraProcedural(int x) {
        this.object.toString();
    }

    // accesses field before initialised
    IntraProcedural(int x, int y) {
        this.object.toString();
        this.object = new Object();
    }
}
