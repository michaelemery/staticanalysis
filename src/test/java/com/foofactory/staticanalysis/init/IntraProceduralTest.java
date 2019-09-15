package com.foofactory.staticanalysis.init;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Check initialisation of field set via direct value assignment.
 */
public class IntraProceduralTest {

    @Test
    public void setFooToNonNull() {
        assertDoesNotThrow(() -> {
            IntraProcedural.setFooToNonNull();
        });
    }

    @Test
    public void setFooToNull() {
        assertThrows(NullPointerException.class, () -> {
            IntraProcedural.setFooToNull();
        });
    }

    @Test
    public void accessFooBeforeSet() {
        assertThrows(NullPointerException.class, () -> {
            IntraProcedural.accessFooBeforeSet();
        });
    }
}
