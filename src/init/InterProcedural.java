package init;

/**
 * Initialisation of an object via layered methods.
 */
public class InterProcedural {

    Object object;

    // initialises field
    InterProcedural() {
        this.object = returnObject(new Object());
        this.object.toString();
    }

    // fail to initialise
    InterProcedural(int x) {
        this.object = returnObject(null);
        this.object.toString();
    }

    // accesses field before initialised
    InterProcedural(int x, int y) {
        this.object.toString();
        this.object = returnObject(new Object());
    }

    static Object returnObject(Object object) {
        return object;
    }

    static void initialiseWithObject() {
        new InterProcedural();
    }

    static void failToInitialise() {
        new InterProcedural(1);
    }

    static void accessBeforeInitialise() {
        new InterProcedural(1, 2);
    }
}
