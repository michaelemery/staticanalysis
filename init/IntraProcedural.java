package init;

/**
 * Reference an object before initialisation is complete.
 */
public class IntraProcedural {

    Object o;

    public IntraProcedural() {
        this.o = "safe";
        System.out.println(this.o.toString());
    }

    public IntraProcedural(int x) {
        System.out.println(this.o.toString());
        this.o = new IntraProcedural();
    }

    public static void main(String[] args) throws NullPointerException {

        /* safe: set object to non-null */
        new IntraProcedural();

        /* unsafe: access object before setting */
        new IntraProcedural(1);
    }
}
