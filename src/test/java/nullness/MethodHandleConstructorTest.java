package nullness;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Check nullness of field set by invoking constructor method handle.
 */
class MethodHandleConstructorTest {

    @Test
    void setFooToNonNull() {
        assertDoesNotThrow(() -> {
            MethodHandleConstructor.setFooToNonNull();
        });
    }

    @Test
    void setFooToNull() {
        assertThrows(NullPointerException.class, () -> {
            MethodHandleConstructor.setFooToNull();
        });
    }
}
