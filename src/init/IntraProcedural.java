package init;

/**
 * Reference an object before initialisation is complete.
 */
public class IntraProcedural {

    Object object;

    public IntraProcedural() {
        this.object = "safe";
    }

    IntraProcedural(int x) {
        this.object = null;
    }

    public static void main(String[] args) throws NullPointerException {

        /* safe: set object to non-null */
        new IntraProcedural();

        /* unsafe: access object before setting */
        new IntraProcedural(1);
    }
}
