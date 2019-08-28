package init;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Initialisation of field via reflective constructor.
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
