package init;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test initialisation of an object via dynamic invocation of a static method.
 */
class InvokeDynamicMethodTest {

    @Test
    void testInitialiseWithObject() throws Exception {
        assertDoesNotThrow(() -> {
            InvokeDynamicMethod.initialiseWithObject();
        });
    }

    @Test
    void testFailToInitialise() throws Exception {
        assertThrows(NullPointerException.class, () -> {
            InvokeDynamicMethod.failToInitialise();
        });
    }
}
