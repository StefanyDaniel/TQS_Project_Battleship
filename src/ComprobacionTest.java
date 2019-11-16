import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ComprobacionTest {


	
	Comprobacion comp = new Comprobacion();
	
	@Test
	public void testFila() {
		boolean r1 = comp.isFilaCorrecta(-1); //Valor frontera exterior
		assertEquals(r1,false);
		boolean r2 = comp.isFilaCorrecta(0); //Valor límit-frontera interior
		assertEquals(r2,true);
		boolean r3 = comp.isFilaCorrecta(5); //Valor Interior
		assertEquals(r3,true);
		boolean r4 = comp.isFilaCorrecta(9); //Valor limit-Frontera interior
		assertEquals(r4,true);
		boolean r5 = comp.isFilaCorrecta(10); //Valor frontera exterior
		assertEquals(r5,false);
	}
	@Test
	public void testColumna() {
		boolean r1 = comp.isColumnaCorrecta(-1);
		assertEquals(r1,false);
		boolean r2 = comp.isColumnaCorrecta(0);
		assertEquals(r2,true);
		boolean r3 = comp.isColumnaCorrecta(5);
		assertEquals(r3,true);
		boolean r4 = comp.isColumnaCorrecta(9);
		assertEquals(r4,true);
		boolean r5 = comp.isColumnaCorrecta(10);
		assertEquals(r5,false);
	}
}
