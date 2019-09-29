package generic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Michael Emery on 29/09/19.
 */
class UnsafeInitializationTest {

    @Test
    void allocateEmptyInstance1() {
        assertDoesNotThrow(() -> {
            UnsafeInitialization.allocateEmptyInstance1();
        });
    }

    @Test
    void allocateEmptyInstance2() {
        assertThrows(NullPointerException.class, () -> {
            UnsafeInitialization.allocateEmptyInstance2();
        });
    }
}