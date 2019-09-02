package signedness;

import org.checkerframework.checker.signedness.qual.Signed;
import org.checkerframework.checker.signedness.qual.Unsigned;

import java.math.BigDecimal;

/**
 * Check signedness of divisor set via direct value assignment.
 */
class IntraProcedural {

    // integral types are signed by default

    public static void divisorSigned() throws Exception {
        int s1 = -2;  // --> unsigned: 2^31 - 2
        int s2 = -1;  // --> unsigned: 2^31 - 1

        /*
        correct answer is 2
        test passes
         */
        if (s1 / s2 != 2) {
            throw new Exception();
        }
    }

    public static void divisorUnsigned() throws Exception {
        @Unsigned int u1 = 2147483646;  // = 2^31 - 2 --> signed: -2
        @Unsigned int u2 = 2147483647;  // = 2^31 - 1 --> signed: -1

        /*
        expected answer according to checkerframework documentation is 2
        correct answer is 0 (rounded due to using int)
        actual answer is 0 (= correct answer) therefore exception not thrown
        test fails
         */
        if (u1 / u2 == 2) {
            throw new Exception("Division by @Unsigned.");
        }
    }

    public static void modulusSigned() throws Exception {
        int s1 = -1;
        int s2 = 5;

        /*
        correct answer is -1
        test passes
         */
        if (s1 % s2 != -1) {
            throw new Exception();
        }
    }

    public static void modulusUnsigned() throws Exception {
        @Unsigned int u1 = 2147483647;  // = 2^31 - 1, signed: -1
        @Unsigned int u2 = 5;

        /*
        expected answer according to checkerframework documentation is -1
        correct answer is 2
        actual answer is 2 (= correct answer) therefore exception not thrown
        test fails
         */
        int z = u1 % u2;
        System.out.println(z);
        if (z == -1) {
            throw new Exception("Division by @Unsigned.");
        }
    }
}
