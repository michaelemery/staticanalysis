package init;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test initialisation of an object via reflective constructor.
 */
class ReflectConstructorTest {

    @Test
    void testInitialiseWithObject() throws Exception {
        assertDoesNotThrow(() -> {
            ReflectConstructor.initialiseWithObject();
        });
    }

    @Test
    void testFailToInitialise() throws Exception {
        assertThrows(NullPointerException.class, () -> {
            try {
                ReflectConstructor.failToInitialise();
            } catch (Exception exception) {
                throw exception.getCause();  // unwrap reflect.InvocationTargetException
            }
        });
    }
}
