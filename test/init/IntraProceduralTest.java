package init;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Intra-procedural initialisation of an object attribute.
 */
public class IntraProceduralTest {

    @Test
    public void initialise() {
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
