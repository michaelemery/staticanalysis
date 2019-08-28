package nullness;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Check nullness for field set via direct value assignment.
 */
class IntraProceduralTest {

    @Test
    void setFooToNonNull() {
        assertDoesNotThrow(() -> {
            IntraProcedural.setFooToNonNull();
        });
    }

    @Test
    void setFooToNull() {
        assertThrows(NullPointerException.class, () -> {
            IntraProcedural.setFooToNull();
        });
    }
}