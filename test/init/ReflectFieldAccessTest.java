package init;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Validate initialisation of an object via reflective field access.
 */
class ReflectFieldAccessTest {
    @Test
    void validSet() throws Exception {
        assertDoesNotThrow(() -> {
            new ReflectFieldAccess();
        });
    }

    @Test
    void invalidSet() throws Exception {
        assertThrows(NullPointerException.class, () -> {
            new ReflectFieldAccess(1);
        });
    }
}
