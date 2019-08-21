package init;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test initialisation of an object via a single method.
 */
public class IntraProceduralTest {

    @Test
    public void validInitialise() {
        assertDoesNotThrow(() -> {
            new IntraProcedural();
        });
    }

    @Test
<<<<<<< HEAD
    void testSafeSet() {
        i = new IntraProcedural();
        assertEquals(this.i.toString(), "safe");
=======
    public void failToInitialise() {
        assertThrows(NullPointerException.class, () -> {
            new IntraProcedural(1);
        });
>>>>>>> 6509b1964bb2744212544ed36e597b8408518b90
    }

    @Test
    public void accessBeforeInitialised() {
        assertThrows(NullPointerException.class, () -> {
            new IntraProcedural(1, 2);
        });
    }
}
