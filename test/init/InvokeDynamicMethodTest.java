package init;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test initialisation of an object via dynamic invocation of a static method.
 */
class InvokeDynamicMethodTest {

    @Test
    void setFooToNonNull() {
        assertDoesNotThrow(() -> {
            InvokeDynamicMethod.setFooToNonNull();
        });
    }

    @Test
    void setFooToNull() {
        assertThrows(NullPointerException.class, () -> {
            InvokeDynamicMethod.setFooToNull();
        });
    }
}
