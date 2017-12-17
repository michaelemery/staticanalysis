/**
 * Signedness.java
 *
 * Provide a template to test the effectiveness of static analysis tools in identifying
 * potential causes of null-pointer exceptions.
 *
 * Created by Michael Emery on 30/11/17.
 */

public class Signedness {

    public static void main(String[] args) {

        int i = -1;

        // signed ints used where unsigned ints were intended
        int uInt1 = 0xFFFFFFFF;  // as signed = -1
        int uInt2 = 0xFFFFFFFE;  // as signed = -2

        /*
         * The following operations yield unexpected results and would
         * ideally fail if expressions were correctly checked.
         */

        // signed and unsigned may not be mixed
        System.out.println(uInt1 + i);  // -2

        // unsigned may not use / or mod operators
        System.out.println(uInt2 / 2);  // -1
        System.out.println(uInt2 % 2);  // 0

        // unsigned may not use comparators (<, >, <=, >=)
        System.out.println(uInt1 < uInt2);  // false
        System.out.println(uInt1 > uInt2);  // true
        System.out.println(uInt1 <= uInt2);  // false
        System.out.println(uInt1 >= uInt2);  // true
    }
}
