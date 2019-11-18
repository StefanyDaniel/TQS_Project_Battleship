import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class EscanerCoordenadasTest {

	/*@Test
	void testEscanerCoordenadas() {
		//fail("Not yet implemented");
	}*/

	@Test
	void testSetFila() {
		//Testeamos las particiones equivalentes y comprobamos el resultado mostrado por consola
		EscanerCoordenadas ec = new EscanerCoordenadas();
		System.out.println("test setFila(). Si el valor no es correcto deberia devolver un -1");
		
		System.out.println("Introduce el numero 0 (valor limite)");
		ec.setFila();
		System.out.println("Fila guardada: " + ec.getFila());
		
		System.out.println("Introduce el numero 2 (valor limite)");
		ec.setFila();
		System.out.println("Fila guardada: " + ec.getFila());
		
		System.out.println("Introduce el numero 1 (valor frontera)");
		ec.setFila();
		System.out.println("Fila guardada: " + ec.getFila());
		
		System.out.println("Introduce un numero entre 3 y 8");
		ec.setFila();
		System.out.println("Fila guardada: " + ec.getFila());
		
		System.out.println("Introduce el numero 9 (valor limite)");
		ec.setFila();
		System.out.println("Fila guardada: " + ec.getFila());
		
		System.out.println("Introduce el numero 11 (valor limite)");
		ec.setFila();
		System.out.println("Fila guardada: " + ec.getFila());
		
		System.out.println("Introduce el numero 10 (valor frontera)");
		ec.setFila();
		System.out.println("Fila guardada: " + ec.getFila());
		
		System.out.println("Introduce cualquier numero o caracter");
		ec.setFila();
		System.out.println("Fila guardada: " + ec.getFila());
	}

	/*@Test
	void testSetColumna() {
		fail("Not yet implemented");
	}*/

	/*@Test
	void testSetOrientacion() {
		fail("Not yet implemented");
	}*/

	@Test
	void testConvertirColumnaCharToInt() {
		EscanerCoordenadas ec = new EscanerCoordenadas();
		
		//valor frontera a
		int columna0 = ec.convertirColumnaCharToInt('a');
		assertEquals(0, columna0);
		
		//valor frontera j
		int columna9 = ec.convertirColumnaCharToInt('j');
		assertEquals(9, columna9);
		
		//valor limite b
		int columna1 = ec.convertirColumnaCharToInt('b');
		assertEquals(1, columna1);
		
		//valor dentro del rango [a, j]
		int columna3 = ec.convertirColumnaCharToInt('d');
		assertEquals(3, columna3);
		
		//valor limite
		int columna8 = ec.convertirColumnaCharToInt('i');
		assertEquals(8, columna8);
		
		//valores no validos
		int columnaN1 = ec.convertirColumnaCharToInt('\0');
		assertEquals(-1, columnaN1);
		
		int columnaN2 = ec.convertirColumnaCharToInt('\n');
		assertEquals(-1, columnaN2);
		
		int columnaN3 = ec.convertirColumnaCharToInt(' ');
		assertEquals(-1, columnaN3);
		
		int columnaN4 = ec.convertirColumnaCharToInt('4');
		assertEquals(-1, columnaN4);
		
		int columnaN5 = ec.convertirColumnaCharToInt('m');
		assertEquals(-1, columnaN5);
	}
}
