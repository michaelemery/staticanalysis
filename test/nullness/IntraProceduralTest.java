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
}