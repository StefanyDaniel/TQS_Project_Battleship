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
		
		//Altres casos
				String[][] tableroNoVacio = { 
						{"  ", "  ", "X ", "  ", "  ", "  ", "  ", "  ", "X ", "  "},//0
						{"  ", "  ", "X ", "  ", "  ", "  ", "  ", "  ", "X ", "  "},//1
						{"  ", "  ", "X ", "  ", "  ", "  ", "  ", "  ", "X ", "  "},//2
						{"  ", "  ", "X ", "  ", "  ", "  ", "  ", "  ", "X ", "  "},//3
						{"  ", "  ", "X ", "X ", "X ", "X ", "X ", "X ", "X ", "  "},//4
						{"  ", "  ", "X ", "  ", "  ", "  ", "  ", "  ", "X ", "  "},//5
						{"  ", "  ", "X ", "  ", "  ", "  ", "  ", "  ", "X ", "  "},//6
						{"  ", "  ", "X ", "  ", "  ", "  ", "  ", "  ", "X ", "  "},//7
						{"  ", "  ", "X ", "  ", "  ", "  ", "  ", "  ", "X ", "  "},//8
						{"  ", "  ", "X ", "  ", "  ", "  ", "  ", "  ", "X ", "  "}//9
						// 0     1     2     3     4     5     6     7     8     9
				};
				t.setTablero(tableroNoVacio);
				boolean r9 = comp.isOrientacionCorrecta(t, 5, 3, 'u', 5);
				assertEquals(r9,false);
				boolean r10 = comp.isOrientacionCorrecta(t, 3, 4, 'd', 5);
				assertEquals(r10,false);
				boolean r15 = comp.isOrientacionCorrecta(t, 1, 5, 'l', 5);
				assertEquals(r15,false);
				boolean r16 = comp.isOrientacionCorrecta(t, 9, 1, 'r', 5);
				assertEquals(r16,false);
				
				boolean r17 = comp.isOrientacionCorrecta(t, 4, 2, 'r', 5);
				assertEquals(r17,false);
				boolean r18 = comp.isOrientacionCorrecta(t, 9, 2, 'u', 5);
				assertEquals(r18,false);
				boolean r19 = comp.isOrientacionCorrecta(t, 2, 2, 'd', 5);
				assertEquals(r19,false);
				boolean r20 = comp.isOrientacionCorrecta(t, 4, 7, 'l', 5);
				assertEquals(r20,false);
	}
}
