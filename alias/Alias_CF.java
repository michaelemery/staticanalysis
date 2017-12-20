import org.checkerframework.common.aliasing.qual.Unique;

/**
 * Alias_CF.java
 *
 * Provide a template to test the effectiveness of static analysis tools in identifying
 * unintentional mutations of objects that were intended to be unique.
 *
 * Created by Michael Emery on 30/11/17.
 */
public class Alias_CF {

    public static void main(String[] args) {

        // direct assignment of an alias
        // a1 becomes mutable by alias b1
        @Unique Object a1 = new Object();
        Object b1 = a1;
        System.out.println(a1 == b1);  // true

        // referencing an existing alias
        // a2 is a mutable alias of b2
        Object b2 = new Object();
        @Unique Object a2 = b2;
        System.out.println(a2 == b2);  // true

        // pseudo assignment of an alias to method parameters
        // a3 becomes mutable by method m1
        @Unique Object a3 = new Object();
        m1(a3);

        // leakage to an alias via method return value
        // a4 becomes mutable by alias b4 (leaked by method m2)
        @Unique Object a4 = new Object();
        Object b4 = m2(a4);
        System.out.println(a4 == b4);  // true
    }

    // pseudo assignment of alias to method parameter
    static void m1(Object o) {
        System.out.println(o);  // identical reference to caller argument
    }

    // return value leaks mutable alias of caller argument
    static Object m2(Object o) {
        return o;
    }
}
