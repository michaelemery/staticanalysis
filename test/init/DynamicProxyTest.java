package init;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test initialisation of an object via dynamic proxy invocation.
 */
class DynamicProxyTest {

    @Test
    void initWithObject() throws Exception {
        assertDoesNotThrow(() -> {
            DynamicProxy.constructWithObject();
        });
    }

    @Test
    void initWithNull() throws Exception {
        assertThrows(NullPointerException.class, () -> {
            DynamicProxy.constructWithNull();
        });
    }
}