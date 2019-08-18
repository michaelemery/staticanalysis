package init;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Validate initialisation of an object via a single method.
 */
public class IntraProceduralTest {

    @Test
    public void validInitialise() {
        assertDoesNotThrow(() -> {
            new IntraProcedural();
        });
    }

    @Test
    public void failToInitialise() {
        assertThrows(NullPointerException.class, () -> {
            new IntraProcedural(1);
        });
    }

    @Test
    public void accessBeforeInitialised() {
        assertThrows(NullPointerException.class, () -> {
            new IntraProcedural(1, 2);
        });
    }
}
