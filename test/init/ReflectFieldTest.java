package init;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test initialisation of an object via reflective field access.
 */
class ReflectFieldTest {

    @Test
    void initWithObject() throws Exception {
        assertDoesNotThrow(() -> {
            new ReflectField();
        });
    }

    @Test
    void initWithNull() throws Exception {
        assertThrows(NullPointerException.class, () -> {
            new ReflectField(1);
        });
    }
}
