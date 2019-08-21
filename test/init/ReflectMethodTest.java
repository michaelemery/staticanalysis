package init;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test initialisation of an object via reflective methods calls.
 */
class ReflectMethodTest {

    @Test
    public void testInitialiseWithObject() {
        assertDoesNotThrow(() -> {
            ReflectMethod.initialiseWithObject();
        });
    }

    @Test
    public void testFailToInitialise() {
        assertThrows(NullPointerException.class, () -> {
            ReflectMethod.failToInitialise();
        });
    }
}
