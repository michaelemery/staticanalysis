package init;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test initialisation of an object via dynamic proxy invocation.
 */
class DynamicProxyTest {

    @Test
    void testInitialiseWithObject() throws Exception {
        assertDoesNotThrow(() -> {
            DynamicProxy.initialiseWithObject();
        });
    }

    @Test
    void testFailToInitialise() throws Exception {
        assertThrows(NullPointerException.class, () -> {
            DynamicProxy.failToInitialise();
        });
    }
}