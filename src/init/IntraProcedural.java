package init;

/**
 * Initialisation of an object via a single method.
 */
public class IntraProcedural {

    Object object;

    // initialises field
    IntraProcedural() {
        this.object = new Object();
        this.object.toString();
    }

    // fail to initialise
    IntraProcedural(int x) {
        this.object.toString();
    }

    // accesses field before initialised
    IntraProcedural(int x, int y) {
        this.object.toString();
        this.object = new Object();
    }

    static void initialiseWithObject() {
        new IntraProcedural();
    }

    static void failToInitialise() {
        new IntraProcedural(1);
    }

    static void accessBeforeInitialise() {
        new IntraProcedural(1, 2);
    }
}
