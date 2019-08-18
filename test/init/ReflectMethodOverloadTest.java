package init;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Validate initialisation of an object via reflective methods calls.
 */
class ReflectMethodOverloadTest {

    @Test
    void validInitialise() throws Exception {
        assertDoesNotThrow(() -> {
            new ReflectMethodOverload().toString();
        });
    }

    @Test
    void failToInitialise() throws Exception {
        assertThrows(NullPointerException.class, () -> {
            try {
                new ReflectMethodOverload(1).toString();
            } catch (Exception ex) {
                throw ex.getCause();
            }
        });
    }
}
