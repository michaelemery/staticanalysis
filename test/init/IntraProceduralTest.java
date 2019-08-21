package init;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Test initialisation of an object via a single method.
 */
public class IntraProceduralTest {

    @Test
    public void testInitialiseWithObject() {
        assertDoesNotThrow(() -> {
            IntraProcedural.initialiseWithObject();
        });
    }

    @Test
    public void testFailToInitialise() {
        assertThrows(NullPointerException.class, () -> {
            IntraProcedural.failToInitialise();
        });
    }

    @Test
    public void testAccessBeforeInitialise() {
        assertThrows(NullPointerException.class, () -> {
            IntraProcedural.accessBeforeInitialise();
        });
    }
}
