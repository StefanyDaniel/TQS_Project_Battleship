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
	@Test
	public void testCoordenadaCorrecta() {
		boolean r1 = comp.isCoordenadaCorrecta(-1, 1);
		assertEquals(r1,false);
		boolean r2 = comp.isCoordenadaCorrecta(1, -1);
		assertEquals(r2,false);
		boolean r3 = comp.isCoordenadaCorrecta(5, 5);
		assertEquals(r3,true);
		boolean r4 = comp.isCoordenadaCorrecta(10, -1);
		assertEquals(r4,false);
	}
	@Test
	public void testOrientacionCorrecta() {
		Tablero t=new Tablero();
		//Limits i frontera taulell
		boolean r1 = comp.isOrientacionCorrecta(t, 0, 0, 'u', 5);
		assertEquals(r1,false);
		boolean r2 = comp.isOrientacionCorrecta(t, 0, 0, 'd', 3);
		assertEquals(r2,true);
		boolean r3 = comp.isOrientacionCorrecta(t, 0, 0, 'l', 2);
		assertEquals(r3,false);
		boolean r4 = comp.isOrientacionCorrecta(t, 0, 0, 'r', 3);
		assertEquals(r4,true);
		boolean r11 = comp.isOrientacionCorrecta(t, 9, 0, 'u', 5);
		assertEquals(r11,true);
		boolean r12 = comp.isOrientacionCorrecta(t, 9, 0, 'd', 3);
		assertEquals(r12,false);
		boolean r13 = comp.isOrientacionCorrecta(t, 9, 0, 'l', 2);
		assertEquals(r13,false);
		boolean r14 = comp.isOrientacionCorrecta(t, 9, 0, 'r', 3);
		assertEquals(r14,true);
		boolean r21 = comp.isOrientacionCorrecta(t, 0, 9, 'u', 5);
		assertEquals(r21,false);
		boolean r22 = comp.isOrientacionCorrecta(t, 0, 9, 'd', 3);
		assertEquals(r22,true);
		boolean r23 = comp.isOrientacionCorrecta(t, 0, 9, 'l', 2);
		assertEquals(r23,true);
		boolean r24 = comp.isOrientacionCorrecta(t, 0, 9, 'r', 3);
		assertEquals(r24,false);
		boolean r31 = comp.isOrientacionCorrecta(t, 9, 9, 'u', 5);
		assertEquals(r31,true);
		boolean r32 = comp.isOrientacionCorrecta(t, 9, 9, 'd', 3);
		assertEquals(r32,false);
		boolean r33 = comp.isOrientacionCorrecta(t, 9, 9, 'l', 2);
		assertEquals(r33,true);
		boolean r34 = comp.isOrientacionCorrecta(t, 9, 9, 'r', 3);
		assertEquals(r34,false);
		
		//Valors no valids
		boolean r5 = comp.isOrientacionCorrecta(t, 0, 0, 'z', 5);
		assertEquals(r5,false);
		boolean r6 = comp.isOrientacionCorrecta(t, 0, 0, 'd', -1);
		assertEquals(r6,false);
		boolean r7 = comp.isOrientacionCorrecta(t, 0, 0, 'l', 10);
		assertEquals(r7,false);
		boolean r8 = comp.isOrientacionCorrecta(t, -11, -1, 'r', 5);
		assertEquals(r8,false);
	}
}
