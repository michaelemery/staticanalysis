package init;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Check initialisation of field set via dynamic invocation of a field set.
 */
class InvokeDynamicFieldTest {

    @Test
    void setFooToNonNull() {
        assertDoesNotThrow((() -> {
            InvokeDynamicField.setFooToNonNull();
        }));
    }

    @Test
    void setFooToNull() {
        assertThrows(NullPointerException.class, () -> {
            InvokeDynamicField.setFooToNull();
        });
    }
}
