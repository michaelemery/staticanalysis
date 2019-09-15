package com.foofactory.staticanalysis.nullness;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Check nullness of field set via dynamic field access invocation.
 */
class InvokeDynamicFieldTest {

    @Test
    void setFooToNonNull() {
        assertDoesNotThrow(() -> {
            InvokeDynamicField.setFooToNonNull();
        });
    }

    @Test
    void setFooToNull() {
        assertThrows(NullPointerException.class, () -> {
            InvokeDynamicField.setFooToNull();
        });
    }
}
