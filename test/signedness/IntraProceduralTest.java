package signedness;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Check signedness of divisor set via direct value assignment.
 */
class IntraProceduralTest {

    @Test
    void divisorSigned() {
        assertDoesNotThrow(() -> {
            IntraProcedural.divisorSigned();
        });
    }

//    @Test
//    void divisorUnsigned() {
//        Exception thrown = assertThrows(Exception.class, () -> {
//            IntraProcedural.divisorUnsigned();
//        });
//        assertTrue(thrown.getMessage().contains("Division by @Unsigned."));
//    }

    @Test
    void modulusSigned() {
        assertDoesNotThrow(() -> {
            IntraProcedural.modulusSigned();
        });
    }

//    @Test
//    void modulusUnsigned() {
//        Exception thrown = assertThrows(Exception.class, () -> {
//            IntraProcedural.modulusUnsigned();
//        });
//        assertTrue(thrown.getMessage().contains("Division by @Unsigned."));
//    }
}