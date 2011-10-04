package belajar.junit;

import static org.junit.Assert.*;

import org.junit.Test;

public class CalculatorTest {

	@Test
	public void testTambah() {
		Integer x = 4;
		Integer y = 3;
		Integer seharusnya = 7;
		
		Calculator c = new Calculator();
		assertEquals(seharusnya, c.tambah(x, y));
	}
	
	@Test
	public void testTambahNullInput() {
		Integer x = null;
		Integer y = 3;
		
		try {
			Calculator c = new Calculator();
			c.tambah(x, y);
			fail("Harusnya terjadi exception");
		} catch (IllegalArgumentException err){
			// biarkan saja, memang seharusnya exception
		} catch (Exception err){
			fail("Jenis exception salah, harusnya IAE, tapi "+err.getClass().getName());
		}
	}

	@Test
	public void testKurang() {
		fail("Not yet implemented");
	}

	@Test
	public void testKali() {
		fail("Not yet implemented");
	}

}
