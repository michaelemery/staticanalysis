package init;

/**
 * Inter-procedural initialisation of an object attribute.
 */
public class InterProcedural {

    Object object;

    public InterProcedural() {
        initialise();
    }

    public InterProcedural(int x) {
        failToInitialise();
    }

    public InterProcedural(int x, int y) {
        accessBeforeInitialised();
    }

    void initialise() {
        object = new Object();
        object.toString();
    }

    // method fails to initialise field
    void failToInitialise() {
        object.toString();
    }

    // method accesses field before initialised
    void accessBeforeInitialised() {
        object.toString();
        object = new Object();
    }
}