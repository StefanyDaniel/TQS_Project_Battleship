import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedList;
import java.util.Queue;

import org.junit.jupiter.api.Test;

class JugadorTest {
	@Test
	void testColocarBarcos() {
		Queue<Integer> filas = new LinkedList<>();
		Queue<Character> columnasChar = new LinkedList<>();
		Queue<Integer> columnasInt = new LinkedList<>();
		Queue<Character> orientaciones = new LinkedList<>();
		
		//Test esquinas del tablero
		//esquina 0, a
		//Filas [1, 10]
		//limites: 0, 2 ; 9, 11
		//frontera: 1, 10
		filas.add(0);
		columnasChar.add('a');
		columnasInt.add(0);
		orientaciones.add('r');

		filas.add(1);
		columnasChar.add('a');
		columnasInt.add(0);
		orientaciones.add('u');
		
		filas.add(1);
		columnasChar.add('a');
		columnasInt.add(0);
		orientaciones.add('l');

		filas.add(2);
		columnasChar.add('a');
		columnasInt.add(0);
		orientaciones.add('u');		
		
		//esquina 0, j
		filas.add(1);
		columnasChar.add('j');
		columnasInt.add(9);
		orientaciones.add('u');
		
		filas.add(1);
		columnasChar.add('j');
		columnasInt.add(9);
		orientaciones.add('r');
		
		//esquina 9, j
		filas.add(10);
		columnasChar.add('j');
		columnasInt.add(9);
		orientaciones.add('d');
		
		filas.add(10);
		columnasChar.add('j');
		columnasInt.add(9);
		orientaciones.add('r');
		
		//esquina 9, a
		filas.add(10);
		columnasChar.add('a');
		columnasInt.add(0);
		orientaciones.add('l');
		
		filas.add(10);
		columnasChar.add('a');
		columnasInt.add(0);
		orientaciones.add('d');
		
		filas.add(11);
		columnasChar.add('a');
		columnasInt.add(0);
		orientaciones.add('d');
		
		//Se coloca Carrier 5
		filas.add(1);
		columnasChar.add('a');
		columnasInt.add(0);
		orientaciones.add('d');
		
		//Comprobar zonas laterales
		filas.add(1);
		columnasChar.add('e');
		columnasInt.add(4);
		orientaciones.add('u');
		
		filas.add(2);
		columnasChar.add('e');
		columnasInt.add(4);
		orientaciones.add('u');
		
		filas.add(5);
		columnasChar.add('a');
		columnasInt.add(0);
		orientaciones.add('l');
		
		filas.add(5);
		columnasChar.add('b');
		columnasInt.add(1);
		orientaciones.add('l');
		
		filas.add(6);
		columnasChar.add('a');
		columnasInt.add(0);
		orientaciones.add('l');
		
		filas.add(6);
		columnasChar.add('b');
		columnasInt.add(1);
		orientaciones.add('l');
		
		filas.add(5);
		columnasChar.add('j');
		columnasInt.add(9);
		orientaciones.add('r');
		
		filas.add(5);
		columnasChar.add('j');
		columnasInt.add(9);
		orientaciones.add('r');
		
		filas.add(10);
		columnasChar.add('e');
		columnasInt.add(4);
		orientaciones.add('d');
		
		filas.add(9);
		columnasChar.add('e');
		columnasInt.add(4);
		orientaciones.add('d');
		
		
		filas.add(5);
		columnasChar.add('k');
		columnasInt.add(10);
		orientaciones.add('l');
		
		filas.add(5);
		columnasChar.add('j');
		columnasInt.add(9);
		orientaciones.add('l');
		
		//Comprobar si se solapan
		filas.add(5);
		columnasChar.add('g');
		columnasInt.add(6);
		orientaciones.add('d');
		
		filas.add(5);
		columnasChar.add('j');
		columnasInt.add(9);
		orientaciones.add('d');
		
		filas.add(5);
		columnasChar.add('f');
		columnasInt.add(5);
		orientaciones.add('r');
		
		filas.add(6);
		columnasChar.add('g');
		columnasInt.add(6);
		orientaciones.add('u');
		
		filas.add(6);
		columnasChar.add('j');
		columnasInt.add(9);
		orientaciones.add('u');
		
		filas.add(9);
		columnasChar.add('d');
		columnasInt.add(3);
		orientaciones.add('r');
		
		filas.add(9);
		columnasChar.add('g');
		columnasInt.add(6);
		orientaciones.add('l');
		
		filas.add(9);
		columnasChar.add('h');
		columnasInt.add(7);
		orientaciones.add('l');
		
		//terminar de colocar los barcos
		filas.add(7);
		columnasChar.add('a');
		columnasInt.add(0);
		orientaciones.add('u');
		
		filas.add(8);
		columnasChar.add('a');
		columnasInt.add(0);
		orientaciones.add('u');
		
		filas.add(5);
		columnasChar.add('e');
		columnasInt.add(4);
		orientaciones.add('r');
		
		MockCoordenadas coordenadas = new MockCoordenadas(filas, columnasChar, columnasInt, orientaciones);		
		Jugador jugador = new Jugador(1);
		
		jugador.setCoordenadas(coordenadas);
		while(!coordenadas.getQOrientaciones().isEmpty()) {
			boolean barcoColocado = jugador.colocarBarcos();
			assertEquals(true, barcoColocado);
		}
		//assertEquals(barcoColocado, false);
	}
	
	@Test
	void testActualizarVida() {
		Jugador jugador2 = new Jugador(2);
		jugador2.actualizarVida(jugador2);
		assertEquals(5, jugador2.getVida());
		
		jugador2.getBarcos()[0].actualizarVida();
		jugador2.actualizarVida(jugador2);
		assertEquals(5, jugador2.getVida());
		
		Jugador jugador = new Jugador(1);
		int j = 0;
		for(Barco barco : jugador.getBarcos()) {
			for(int i = 0; i < barco.getLongitud(); i++) {
				barco.actualizarVida();
			}
			j++;
			jugador.actualizarVida(jugador);
			assertEquals(5 - j, jugador.getVida());
		}
		jugador.actualizarVida(jugador);
		assertEquals(0, jugador.getVida());
	}
	
	@Test
	void testDisparar() {
		System.out.println("Test disparos");
		
		MockCoordenadas mc1 = new MockCoordenadas();
		Jugador jugador1 = new Jugador(1);
		jugador1.setCoordenadas(mc1);
		jugador1.colocarBarcos();
		
		MockCoordenadas mc2 = new MockCoordenadas();
		Jugador jugador2 = new Jugador(2);		
		jugador2.setCoordenadas(mc2);
		jugador2.colocarBarcos();
		
		while(!mc1.getQFilas().isEmpty() && !mc1.getQColumnasInt().isEmpty()) {
			boolean disparoRealizado = jugador1.disparar(jugador2);
			jugador2.disparar(jugador1);
			assertEquals(true, disparoRealizado);
		}
	}
	
	/*@Test
	void testColocarBarcos() {
		MockCoordenadas coordenadas = new MockCoordenadas();		
		Jugador[] jugador = new Jugador[] {
				new Jugador(1),
				new Jugador(2)
		};
		
		jugador[0].setCoordenadas(coordenadas);
		boolean barcoColocado = jugador[0].colocarBarcos();
		assertEquals(true, barcoColocado);
	}*/
	
	//Descomentar para testear teclado
	/*@Test
	void testColocarBarcos() {
		EscanerCoordenadas escanerCoordenadas = new EscanerCoordenadas();
		Jugador[] jugador = new Jugador[] {
				new Jugador(1),
				new Jugador(2)
		};
		
		jugador[0].setCoordenadas(escanerCoordenadas);
		boolean barcoColocado = jugador[0].colocarBarcos();
		assertEquals(barcoColocado, true);
	}*/
	
	/*@Test
	void testColocarBarcos() {
		Queue<Integer> filas = new LinkedList<>();
		Queue<Character> columnasChar = new LinkedList<>();
		Queue<Integer> columnasInt = new LinkedList<>();
		Queue<Character> orientaciones = new LinkedList<>();
		
		//Test esquinas del tablero
		filas.add(0);
		filas.add(0);
		filas.add(9);
		filas.add(9);
		filas.add(4);
		
		columnasChar.add('a');
		columnasChar.add('j');
		columnasChar.add('a');
		columnasChar.add('j');
		columnasChar.add('e');
		
		//columnas int
		columnasInt.add(0);
		columnasInt.add(9);
		columnasInt.add(0);
		columnasInt.add(9);
		columnasInt.add(4);
		
		//orientacion
		//barco 1
		orientaciones.add('d');
		//orientaciones.add('d');
		//orientaciones.add('u');
		//orientaciones.add('l');
		
		//barco 2
		orientaciones.add('d');
		//orientaciones.add('r');
		//orientaciones.add('u');
		//orientaciones.add('l');
		
		//barco 3
		orientaciones.add('u');
		//orientaciones.add('d');
		//orientaciones.add('l');
		//orientaciones.add('u');
		
		//barco 4
		orientaciones.add('u');
		//orientaciones.add('l');
		//orientaciones.add('d');
		//orientaciones.add('r');
		
		//barco 5
		orientaciones.add('l');
		//orientaciones.add('d');
		//orientaciones.add('r');
		//orientaciones.add('u');
		
		MockCoordenadas coordenadas = new MockCoordenadas(filas, columnasChar, columnasInt, orientaciones);		
		Jugador jugador = new Jugador(1);
		
		jugador.setCoordenadas(coordenadas);
		boolean barcoColocado = jugador.colocarBarcos();
		assertEquals(true, barcoColocado);
	}*/

	/*@Test
	void testActualizarVida() {
		Jugador jugador = new Jugador(1);
		jugador.actualizarVida(jugador);
		assertEquals(5, jugador.getVida());
		
		jugador.getBarcos()[0].actualizarVida();
		jugador.actualizarVida(jugador);
		assertEquals(5, jugador.getVida());
		
		jugador.getBarcos()[0].actualizarVida();
		jugador.getBarcos()[0].actualizarVida();
		jugador.getBarcos()[0].actualizarVida();
		jugador.getBarcos()[0].actualizarVida();
		jugador.actualizarVida(jugador);
		assertEquals(4, jugador.getVida());
	}*/
}
