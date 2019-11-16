import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedList;
import java.util.Queue;

import org.junit.jupiter.api.Test;

class JugadorTest {

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
	
	@Test
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
		orientaciones.add('r');
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
	}
	
	@Test
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
	}
}
