package init;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Validate initialisation of an object via reflective methods calls.
 */
class ReflectMethodTest {

    @Test
    void validInitialise() throws Exception {
        assertDoesNotThrow(() -> {
            new ReflectMethod(ReflectMethod.getBeStringMethod());
        });
    }

    @Test
    void failToInitialise() throws Exception {
        assertThrows(NullPointerException.class, () -> {
            try {
                new ReflectMethod(ReflectMethod.getBeStringMethod(), 1);
            } catch (Exception ex) {
                throw ex.getCause();
            }
        });
    }

    @Test
    void accessBeforeInitialised() throws Exception {
        assertThrows(NullPointerException.class, () -> {
            try {
                new ReflectMethod(ReflectMethod.getBeStringMethod(), 1, 2);
            } catch (Exception ex) {
                throw ex.getCause();
            }
        });
    }
}
