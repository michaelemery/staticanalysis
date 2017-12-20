/**
 * Init.java
 *
 * Provide a template to test the effectiveness of static analysis tools in identifying
 * whether or not potential errors could occur as a result of fields being accesses prior
 * to initialisation.
 *
 * Created by Michael Emery on 2/12/17.
 */
public class Init {

    Object o;

    // constructor fails to initialise field before exit
    Init() { }

    // constructor accesses uninitialised field
    Init(int x) {
        System.out.println(this.o);
    }

    // constructor calls method that accesses an uninitialised field
    Init(int x, int y) {
        m();
    }

    public void m() {
        System.out.println(this.o);  // null
    }

    public static void main(String[] args) throws NullPointerException {
        Init a1 = new Init();
        System.out.println(a1.o);  // null
        Init a2 = new Init(1);  // null
        Init a3 = new Init(1, 2);  // null
    }
}
