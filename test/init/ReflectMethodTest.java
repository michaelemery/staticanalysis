package init;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test initialisation of an object via reflective methods calls.
 */
class ReflectMethodTest {

    @Test
    void initWithObject() throws Exception {
        assertDoesNotThrow(() -> {
            new ReflectMethod();
        });
    }

    @Test
    void initWithNull() throws Exception {
        assertThrows(NullPointerException.class, () -> {
            new ReflectMethod(1);
        });
    }
}
