package nullness;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Check nullness of field set via sun.misc.Unsafe api.
 */
class UnsafeInitialisationTest {

    @Test
    void setFooToNonNull() {
//        assertDoesNotThrow(() -> {
//            UnsafeInitialisation.setFooToNonNull();
//        });
    }

    @Test
    void setFooToNull() {
        assertThrows(NullPointerException.class, () -> {
            ReflectMethod.setFooToNull();
        });
    }
}