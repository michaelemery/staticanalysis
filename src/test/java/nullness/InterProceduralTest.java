package nullness;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Check nullness of field set via inter-procedural return.
 */
class InterProceduralTest {

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
}
