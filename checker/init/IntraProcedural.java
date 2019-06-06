package checker.init;

/**
 * Reference an object before initialisation is complete.
 */
public class IntraProcedural {

    Object o;

    public IntraProcedural() {
        this.o = "safe";
        System.out.println(this.o.toString());  // safe
    }

    public IntraProcedural(int x) {
        System.out.println(this.o.toString());  // NullPointerException
    }

    public IntraProcedural(int x, int y) {
        System.out.println(this.o.toString());  // NullPointerException
        this.o = new IntraProcedural();
    }

    public static void main(String[] args) throws NullPointerException {

        /* safe: set object to non-null */
        new IntraProcedural();

        /* unsafe: fail to set object */
        new IntraProcedural(1);

        /* unsafe: access object before setting */
        new IntraProcedural(1, 2);
    }
}
