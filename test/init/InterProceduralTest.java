package init;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Test initialisation of an object via layered methods.
 */
public class InterProceduralTest {

    @Test
    void validInitialise() {
        assertDoesNotThrow(() -> {
            InterProcedural i = new InterProcedural();
        });
    }

    @Test
    void accessBeforeInitialised() {
        assertThrows(NullPointerException.class, () -> {
            InterProcedural i = new InterProcedural(1);
        });
    }
}
