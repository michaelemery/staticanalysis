import org.checkerframework.checker.signedness.qual.Unsigned;

/**
 * Signedness_CF.java
 *
 * Provide a template to test the effectiveness of static analysis tools in identifying
 * potential causes of null-pointer exceptions.
 *
 * Created by Michael Emery on 30/11/17.
 */

public class Signedness_CF {

    public static void main(String[] args) {

        int s1 = -1;

        // signed ints used where unsigned ints were intended
        @Unsigned int uInt1 = 0xFFFFFFFF;  // as signed = -1
        @Unsigned int uInt2 = 0xFFFFFFFE;  // as signed = -2

        /*
         * The following operations yield unexpected results and would
         * ideally fail if expressions were correctly checked.
         */

        int result;

        // signed and unsigned may not be mixed
        result = uInt1 + s1;
        System.out.println(result);  // -2

        // unsigned may not use / or mod operators
        result = uInt2 / uInt1;
        System.out.println(result);  // 2

        result = uInt1 % uInt2;
        System.out.println(result);  // -1

        // unsigned may not use comparators (<, >, <=, >=)
        System.out.println(uInt1 < uInt2);  // false
        System.out.println(uInt1 > uInt2);  // true
        System.out.println(uInt1 <= uInt2);  // false
        System.out.println(uInt1 >= uInt2);  // true
    }
}
