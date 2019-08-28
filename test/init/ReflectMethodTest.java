package init;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Check initialisation of an object via reflective method return.
 */
class ReflectMethodTest {

    @Test
    public void setFooToNonNull() {
        assertDoesNotThrow(() -> {
            ReflectMethod.setFooToNonNull();
        });
    }

    @Test
    public void setFooToNull() {
        assertThrows(NullPointerException.class, () -> {
            ReflectMethod.setFooToNull();
        });
    }
}
