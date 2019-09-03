package alias;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Check for changes due to aliasing an object via dynamic proxy.
 */
class DynamicProxyTest {

    @Test
    void setFooWithoutAlias() {
        assertDoesNotThrow(() -> {
            DynamicProxy.setFooWithoutAlias();
        });
    }

    @Test
    void setFooWithAlias() {
        Exception thrown = assertThrows(Exception.class, () -> {
            DynamicProxy.setFooWithAlias();
        });
        assertTrue(thrown.getMessage() == "foo changed by alias");
    }
}
