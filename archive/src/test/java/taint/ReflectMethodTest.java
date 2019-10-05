package taint;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Check tainting of field set via reflection method invocation.
 */
class ReflectMethodTest {

    @Test
    void setFooToUntainted() {
        assertDoesNotThrow(() -> {
            ReflectMethod.setFooToUntainted();
        });
    }

    @Test
    void setFooToTainted() throws Exception {
        ReflectMethod.setFooToTainted();  // placeholder: does not test anything
//        Exception thrown = assertThrows(Exception.class, () -> {
//            ReflectMethod.setFooToTainted();
//        });
//        assertTrue(thrown.getMessage().contains("foo tainted"));
    }
}
