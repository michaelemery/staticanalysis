package init;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Check initialisation of field set via inter-procedural return.
 */
public class InterProceduralTest {

    @Test
    void setFooToNonNull() {
        assertDoesNotThrow(() -> {
            InterProcedural.setFooToNonNull();
        });
    }

    @Test
    void setFooToNull() {
        assertThrows(NullPointerException.class, () -> {
            InterProcedural.setFooToNull();
        });
    }

    @Test
    void accessFooBeforeSet() {
        assertThrows(NullPointerException.class, () -> {
            InterProcedural.accessFooBeforeSet();
        });
    }
}
