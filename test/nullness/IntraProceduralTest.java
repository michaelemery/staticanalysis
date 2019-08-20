package nullness;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * 
 */
class IntraProceduralTest {

<<<<<<< HEAD
	IntraProcedural i;

	@BeforeEach
	void setUp() {
		i = new IntraProcedural("init");
		assertEquals(i.o, "init");
	}

	@AfterEach
	void tearDown() {
		i = null;
	}

	@Test
	public void testSafeSet() {
		i.o = "safe";
		assertEquals(i.o, "safe");
		assertDoesNotThrow(() -> {
			i.o.toString();
		});
	}

	@Test
	public void testUnsafeSet() {
		i.o = null;
		assertThrows(NullPointerException.class, () -> {
			System.out.println(i.o.toString());
		});
	}
=======
    IntraProcedural i;

    @BeforeEach
    void setUp() {
        i = new IntraProcedural("init");
        assertEquals(i.object, "init");
    }

    @AfterEach
    void tearDown() {
        i = null;
    }

    @Test
    public void safeSet() {
        i.object = "safe";
        assertEquals(i.object, "safe");
        assertDoesNotThrow(() -> {
            i.object.toString();
        });
    }

    @Test
    public void unsafeSet() {
        i.object = null;
        assertThrows(NullPointerException.class, () -> {
            System.out.println(i.object.toString());
        });
    }
>>>>>>> 6509b1964bb2744212544ed36e597b8408518b90
}