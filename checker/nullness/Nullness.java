package nullness;

/**
 * Nullness.java
 *
 * Provide a template to test the effectiveness of static analysis tools in identifying
 * unsigned expressions that have been used incorrectly.
 *
 * Created by Michael Emery on 30/11/17.
 */
public class Nullness {

    Object o;

    public static void main(String[] args) throws NullPointerException {

        // assignment to an uninitialised object
        Nullness a1 = new Nullness();
        System.out.println(a1.o);  // null

        // directly de-referenced with null
        Object a2 = null;
        System.out.println(a2);  // null

        // assignment to a null reference
        Object b3 = null;
        Object a3 = b3;
        System.out.println(a3);  // null

        // assignment to null via a method return value
        Object a4 = m();
        System.out.println(a4);  // null

        // assignment to an uninitialised object of an under-initialised class
        C1 a5 = new C1();
        System.out.println(a5.o2);  // null

        // assignment to an uninitialised object of an under-initialised extended class
        C2 a6 = new C2();
        System.out.println(a6.o2);  // null
    }

    static Object m() {
        return null;
    }
}

// default constructor fails to initialise all members
class C1 {
    Object o1;
    Object o2;

    C1() {
        o1 = "not null";
    }
}

// fails to initialise all parent members
class C2 extends C1 {
    Object o3;

    C2 () {
        super();
        o3 = "not null";
    }
}
