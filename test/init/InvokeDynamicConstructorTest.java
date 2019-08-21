package init;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test initialisation of an object via dynamic invocation of a constructor.
 */
class InvokeDynamicConstructorTest {

    @Test
    void initWithObject() throws Exception {
        assertDoesNotThrow(() -> {
            InvokeDynamicConstructor.constructWithObject();
        });
    }

    @Test
    void initWithNull() throws Exception {
        assertThrows(NullPointerException.class, () -> {
            InvokeDynamicConstructor.constructWithNull();
        });
    }
}