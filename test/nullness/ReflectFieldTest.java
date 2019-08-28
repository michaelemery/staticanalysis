package nullness;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Check nullness for field set via reflection field access.
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
