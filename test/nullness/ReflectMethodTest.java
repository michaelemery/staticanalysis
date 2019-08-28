package nullness;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Check nullness for field set via reflection method invocation.
 */
class ReflectMethodTest {

    @Test
    void setFooToNonNull() {
        assertDoesNotThrow(() -> {
            ReflectMethod.setFooToNonNull();
        });
    }

    @Test
    void setFooToNull() {
        assertThrows(NullPointerException.class, () -> {
            ReflectMethod.setFooToNull();
        });
    }
}
