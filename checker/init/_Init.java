package checker.init;

/**
 * _Init.java
 *
 * Provide a template to test the effectiveness of static analysis tools in identifying
 * whether or not potential errors could occur as a result of fields being accesses prior
 * to initialisation.
 *
 * Created by Michael Emery on 2/12/17.
 */
public class _Init {

    Object o;

    // constructor fails to initialise field before exit
    _Init() {
    }

    // constructor accesses uninitialised field
    _Init(int x) {
        System.out.println(this.o);
    }

    // constructor calls method that accesses an uninitialised field
    _Init(int x, int y) {
        m();
    }

    public void m() {
        System.out.println(this.o);  // null
    }

    public static void main(String[] args) throws NullPointerException {
        _Init a1 = new _Init();
        System.out.println(a1.o);  // null
        _Init a2 = new _Init(1);  // null
        _Init a3 = new _Init(1, 2);  // null
    }
}
