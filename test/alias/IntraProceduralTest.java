package alias;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Michael Emery on 30/08/19.
 */
class IntraProceduralTest {

    @Test
    void setOneWithoutAlias() {
        assertDoesNotThrow(() -> {
            IntraProcedural.setOneWithoutAlias();
        });
    }

    @Test
    void setOneWithAlias() {
        assertThrows(Exception.class, () -> {
            IntraProcedural.setOneWithAlias();
        });
    }
}
