package nullness;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Check nullness of local object set via reflective constructor call.
 */
class MethodHandleMethodTest {

    @Test
    void setFooToNonNull() {
        assertDoesNotThrow(() -> {
            MethodHandleMethod.setFooToNonNull();
        });
    }

    @Test
    void setFooToNull() {
        assertThrows(NullPointerException.class, () -> {
            MethodHandleMethod.setFooToNull();
        });
    }
}
