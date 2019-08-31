package alias;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Michael Emery on 1/09/19.
 */
class ReflectMethodTest {

    @Test
    void setOneWithAlias() {
        assertDoesNotThrow(() -> {
            ReflectMethod.setOneWithAlias();
        });
    }

    @Test
    void setOneWithoutAlias() {
        assertThrows(Exception.class, () -> {
            ReflectMethod.setOneWithoutAlias();
        });
    }
}
