package taint;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Check tainting of field set via reflective constructor call.
 */
class ReflectConstructorTest {

    @Test
    void setFooToUntainted() {
        assertDoesNotThrow(() -> {
            ReflectConstructor.setFooToUntainted();
        });
    }

    @Test
    void setFooToTainted() throws Exception {
        ReflectConstructor.setFooToTainted();  // placeholder: does not test anything
//        Exception thrown = assertThrows(Exception.class, () -> {
//            ReflectConstructor.setFooToTainted();
//        });
//        assertTrue(thrown.getMessage().contains("foo tainted"));
    }
}
