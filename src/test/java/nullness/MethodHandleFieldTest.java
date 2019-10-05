package nullness;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Check nullness of field set by invoking setter method handle.
 */
class MethodHandleFieldTest {

    @Test
    void setFooToNonNull() {
        assertDoesNotThrow(() -> {
            MethodHandleField.setFooToNonNull();
        });
    }

    @Test
    void setFooToNull() {
        assertThrows(NullPointerException.class, () -> {
            MethodHandleField.setFooToNull();
        });
    }
}
