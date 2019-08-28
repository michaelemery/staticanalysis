package init;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Initialisation of field set via reflective field access.
 */
class ReflectFieldTest {

    @Test
    public void setFooToNonNull() {
        assertDoesNotThrow(() -> {
            ReflectField.setFooToNonNull();
        });
    }

    @Test
    public void setFooToNull() {
        assertThrows(NullPointerException.class, () -> {
            ReflectField.setFooToNull();
        });
    }
}
