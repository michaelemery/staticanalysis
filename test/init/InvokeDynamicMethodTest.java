package init;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test initialisation of an object via dynamic invocation of a static method.
 */
class InvokeDynamicMethodTest {

    @Test
    void initWithObject() throws Exception {
        assertDoesNotThrow(() -> {
            new InvokeDynamicMethod();
        });
    }

    @Test
    void initWithNull() throws Exception {
        assertThrows(NullPointerException.class, () -> {
            new InvokeDynamicMethod(1);
        });
    }
}
