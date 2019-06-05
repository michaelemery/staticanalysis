package checker.init;

/**
 * Reference an object before initialisation is complete.
 */
public class IntraProcedural {

    Object o;

    public IntraProcedural() {
        this.o = "safe";
    }

    public IntraProcedural(int x) {
    }

    public IntraProcedural(int x, int y) {
        this.o.toString();
    }

    public static void main(String[] args) throws NullPointerException {

        /* safe: set object to non-null */
        System.out.println(
                new IntraProcedural().o.toString());  // safe

        /* safe: set object to non-null */
        System.out.println(
                new IntraProcedural(1).o.toString());  // NullPointerException

        /* unsafe: set object to null */
        System.out.println(
                new IntraProcedural(1, 2).o.toString());  // NullPointerException
    }
}
