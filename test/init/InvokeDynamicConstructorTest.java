package init;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test initialisation of an object via dynamic invocation of a constructor.
 */
class InvokeDynamicConstructorTest {

    @Test
    void testInitialiseWithObject() throws Exception {
        assertDoesNotThrow(() -> {
            InvokeDynamicConstructor.initialiseWithObject();
        });
    }

    @Test
    void testFailToInitialise() throws Exception {
        assertThrows(NullPointerException.class, () -> {
            InvokeDynamicConstructor.failToInitialise();
        });
    }
}