package nullness;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Check nullness of field set via reflective field access.
 */
class ReflectFieldTest {

    @Test
    void setFooToNonNull() {
        assertDoesNotThrow(() -> {
            ReflectField.setFooToNonNull();
        });
    }

    @Test
    void setFooToNull() {
        assertThrows(NullPointerException.class, () -> {
            ReflectField.setFooToNull();
        });
    }
}
