package init;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test initialisation of an object via reflective field access.
 */
class ReflectFieldTest {

    @Test
    public void testInitialiseWithObject() {
        assertDoesNotThrow(() -> {
            ReflectField.initialiseWithObject();
        });
    }

    @Test
    public void testFailToInitialise() {
        assertThrows(NullPointerException.class, () -> {
            ReflectField.failToInitialise();
        });
    }
}
