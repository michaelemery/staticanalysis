package nullness;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Check nullness for field set via reflective constructor.
 */
class ReflectConstructorTest {

    @Test
    void setFooToNonNull() {
        assertDoesNotThrow(() -> {
            ReflectConstructor.setFooToNonNull();
        });
    }

    @Test
    void setFooToNull() {
        assertThrows(NullPointerException.class, () -> {
            ReflectConstructor.setFooToNull();
        });
    }
}
