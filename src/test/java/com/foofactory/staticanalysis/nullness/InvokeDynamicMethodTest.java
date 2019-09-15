package com.foofactory.staticanalysis.nullness;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Check nullness of field set via dynamic virtual (non-static) method invocation.
 */
class InvokeDynamicMethodTest {

    @Test
    void setFooToNonNull() {
        assertDoesNotThrow(() -> {
            InvokeDynamicMethod.setFooToNonNull();
        });
    }

    @Test
    void setFooToNull() {
        assertThrows(NullPointerException.class, () -> {
            InvokeDynamicMethod.setFooToNull();
        });
    }
}
