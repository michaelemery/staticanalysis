package nullness;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Check nullness for field set via dynamic proxy invocation.
 */
class DynamicProxyTest {

    @Test
    void setFooToNonNull() {
        assertDoesNotThrow(() -> {
            DynamicProxy.setFooToNonNull();
        });
    }

    @Test
    void setFooToNull() {
        assertThrows(NullPointerException.class, () -> {
            DynamicProxy.setFooToNull();
        });
    }
}
