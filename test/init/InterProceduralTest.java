package init;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Test initialisation of an object via layered methods.
 */
public class InterProceduralTest {

    @Test
    void testInitialiseWithObject() {
        assertDoesNotThrow(() -> {
            InterProcedural.initialiseWithObject();
        });
    }

    @Test
    void testFailToInitialise() {
        assertThrows(NullPointerException.class, () -> {
            InterProcedural.failToInitialise();
        });
    }

    @Test
    void testAccessBeforeInitialised() {
        assertThrows(NullPointerException.class, () -> {
            InterProcedural.accessBeforeInitialise();
        });
    }
}
