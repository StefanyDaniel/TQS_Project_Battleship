import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BarcoTest {
	
	@Test
	void testActualizarVida() {
		Barco barco = new Barco("Carrier", 5);
		
		barco.actualizarVida();
		assertEquals(4, barco.getVida());
		
		barco.actualizarVida();
		barco.actualizarVida();
		assertEquals(2, barco.getVida());
		
		barco.actualizarVida();
		assertEquals(1, barco.getVida());
		
		barco.actualizarVida();
		assertEquals(0, barco.getVida());
		
		barco.actualizarVida();
		assertEquals(0, barco.getVida());
	}

	@Test
	void testGetNombre() {
		Barco barco = new Barco("Carrier", 5);
		
		assertEquals("Carrier", barco.getNombre());
	}

	@Test
	void testGetAlias() {
		Barco barco = new Barco("Carrier", 5);
		
		assertEquals("C5", barco.getAlias());
	}

	@Test
	void testGetLongitud() {
		Barco barco = new Barco("Carrier", 5);
		
		assertEquals(5, barco.getLongitud());
	}

	@Test
	void testGetVida() {
		Barco barco = new Barco("Carrier", 5);
		
		assertEquals(5, barco.getVida());
	}

	@Test
	void testIsHundido() {
		Barco barco = new Barco("Carrier", 5);
		
		assertEquals(false, barco.isHundido());
		
		barco.actualizarVida();
		assertEquals(false, barco.isHundido());
		
		barco.actualizarVida();
		barco.actualizarVida();
		assertEquals(false, barco.isHundido());
		
		barco.actualizarVida();
		assertEquals(false, barco.isHundido());
		
		barco.actualizarVida();
		assertEquals(true, barco.isHundido());
		
		barco.actualizarVida();
		assertEquals(true, barco.isHundido());
	}

}
