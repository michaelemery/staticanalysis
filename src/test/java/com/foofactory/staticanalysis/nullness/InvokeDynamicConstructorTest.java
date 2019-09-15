package com.foofactory.staticanalysis.nullness;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Check nullness of field set via dynamic constructor invocation.
 */
class InvokeDynamicConstructorTest {

    @Test
    void setFooToNonNull() {
        assertDoesNotThrow(() -> {
            InvokeDynamicConstructor.setFooToNonNull();
        });
    }

    @Test
    void setFooToNull() {
        assertThrows(NullPointerException.class, () -> {
            InvokeDynamicConstructor.setFooToNull();
        });
    }
}
