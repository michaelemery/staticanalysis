package init;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Check initialisation of field set via reflective constructor call.
 */
class ReflectConstructorTest {

    @Test
    void setFooToNonNull() throws Exception {
        assertDoesNotThrow(() -> {
            ReflectConstructor.setFooToNonNull();
        });
    }

    @Test
    void setFooToNull() throws Exception {
        assertThrows(NullPointerException.class, () -> {
            ReflectConstructor.setFooToNull();
        });
    }
}
