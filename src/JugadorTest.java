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
		
		//Filas [1, 10]
		//limites: 0, 2 ; 9, 11
		//frontera: 1, 10
		//esquina 0, a
		
		//Test esquinas del tablero
		//Esquina 1,A
		//fila, valor limite 0
		//intenta colocar el carrier de longitud 5 en posicion horizontal hacia la derecha
		filas.add(0);
		columnasChar.add('a');
		columnasInt.add(0);
		orientaciones.add('r');
		
		//fila, valor frontera 1
		//intenta colocar el carrier de longitud 5 en posicion vertical para arriba que no cabe
		filas.add(1);
		columnasChar.add('a');
		columnasInt.add(0);
		orientaciones.add('u');
		
		//fila, valor frontera 1
		//intenta colocar el carrier de longitud 5 en posicion horizontal para la izquierda que no cabe
		filas.add(1);
		columnasChar.add('a');
		columnasInt.add(0);
		orientaciones.add('l');

		//fila, valor limite 2
		//intenta colocar el carrier de longitud 5 en posicion vertical para arriba que no cabe
		filas.add(2);
		columnasChar.add('a');
		columnasInt.add(0);
		orientaciones.add('u');		
		
		//Test esquina 1, J
		//fila, valor frontera 1
		//intenta colocar el carrier de longitud 5 en posicion vertical para arriba que no cabe
		filas.add(1);
		columnasChar.add('j');
		columnasInt.add(9);
		orientaciones.add('u');
		
		//fila, valor frontera 1
		//intenta colocar el carrier de longitud 5 en posicion horizontal hacia la derecha que no cabe
		filas.add(1);
		columnasChar.add('j');
		columnasInt.add(9);
		orientaciones.add('r');
		
		//Test esquina 10, J
		//fila, valor frontera 10
		//intenta colocar el carrier de longitud 5 en posicion vertical hacia abajo que no cabe
		filas.add(10);
		columnasChar.add('j');
		columnasInt.add(9);
		orientaciones.add('d');
		
		//fila, valor frontera 10
		//intenta colocar el carrier de longitud 5 en posicion horizontal hacia la derecha que no cabe
		filas.add(10);
		columnasChar.add('j');
		columnasInt.add(9);
		orientaciones.add('r');
		
		//Test esquina 10, A
		//fila, valor frontera 10
		//intenta colocar el carrier de longitud 5 en posicion horizontal hacia la izquierda que no cabe
		filas.add(10);
		columnasChar.add('a');
		columnasInt.add(0);
		orientaciones.add('l');
		
		//fila, valor frontera 10
		//intenta colocar el carrier de longitud 5 en posicion vertical hacia abajo que no cabe
		filas.add(10);
		columnasChar.add('a');
		columnasInt.add(0);
		orientaciones.add('d');
		
		//fila, valor limite 11
		//intenta colocar el carrier de longitud 5 en posicion vertical hacia abajo que no cabe
		filas.add(11);
		columnasChar.add('a');
		columnasInt.add(0);
		orientaciones.add('d');
		
		//fila, valor frontera 1
		//coloca el carrier en posicion vertical hacia abajo
		filas.add(1);
		columnasChar.add('a');
		columnasInt.add(0);
		orientaciones.add('d');
		
		//Comprobar zonas laterales
		//Lateral superior del tablero
		//intenta colocar el battleship de longitud 4 orientado hacia arriba
		filas.add(1);
		columnasChar.add('e');
		columnasInt.add(4);
		orientaciones.add('u');
		
		filas.add(2);
		columnasChar.add('e');
		columnasInt.add(4);
		orientaciones.add('u');
		
		//Lateral izquierdo del tablero
		//intenta colocar el battleship de longitud 4 orientado hacia la izquierda
		filas.add(5);
		columnasChar.add('a');
		columnasInt.add(0);
		orientaciones.add('l');
		
		//battleship de longitud 4 orientado hacia la izquierda
		filas.add(5);
		columnasChar.add('b');
		columnasInt.add(1);
		orientaciones.add('l');
		
		//battleship de longitud 4 orientado hacia la izquierda
		filas.add(6);
		columnasChar.add('a');
		columnasInt.add(0);
		orientaciones.add('l');
		
		//battleship de longitud 4 orientado hacia la izquierda pero dejando libre una casilla respecto al lateral
		//No cabe igualmente
		filas.add(6);
		columnasChar.add('b');
		columnasInt.add(1);
		orientaciones.add('l');
		
		//Comprobar lateral derecho
		//battleship de longitud 4 orientado hacia la derecha
		filas.add(5);
		columnasChar.add('j');
		columnasInt.add(9);
		orientaciones.add('r');
		
		//COlocar el battleship de longitud 4 orientado hacia la derecha empezando por una casilla anterior al lateral
		filas.add(5);
		columnasChar.add('i');
		columnasInt.add(8);
		orientaciones.add('r');
		
		//Comprobar lateral inferior del tablero
		//colocar el battleship de longitud 4 en vertical hacia abajo
		filas.add(10);
		columnasChar.add('e');
		columnasInt.add(4);
		orientaciones.add('d');
		
		//Colocar el battleship de longitud 4 hacia abajo pero que empiece en una casilla antes del lateral
		filas.add(9);
		columnasChar.add('e');
		columnasInt.add(4);
		orientaciones.add('d');
		
		//Valor limite de columna k
		//intentar colocar battleship de longitud 4
		filas.add(5);
		columnasChar.add('k');
		columnasInt.add(10);
		orientaciones.add('l');
		
		//Se coloca el battleship 4 pegado en el lateral izquierda con orientacion hacia la izquierda
		filas.add(5);
		columnasChar.add('j');
		columnasInt.add(9);
		orientaciones.add('l');
		
		//Comprobar si se solapan los barcos
		//Intentar colocar un barco justo donde empieza otro
		filas.add(5);
		columnasChar.add('g');
		columnasInt.add(6);
		orientaciones.add('d');
		
		//Intentar colocar el Cruiser de longitud 3 justo donde termina el battleship
		filas.add(5);
		columnasChar.add('j');
		columnasInt.add(9);
		orientaciones.add('d');
		
		//Intentar colocar el Cruiser de longitud 3 donde la primera casilla es valida pero las siguientes no 
		//(orientados los dos hacia la derecha)
		filas.add(5);
		columnasChar.add('f');
		columnasInt.add(5);
		orientaciones.add('r');
		
		//Intentar colocar el Cruiser de longitud 3 orientado hacia arriba y que se solape
		filas.add(6);
		columnasChar.add('g');
		columnasInt.add(6);
		orientaciones.add('u');
		
		//Intentar colocar el Cruiser de longitud 3 orientado hacia arriba y que se solape. justo en el lateral
		filas.add(6);
		columnasChar.add('j');
		columnasInt.add(9);
		orientaciones.add('u');
		
		//Se coloca el Cruiser de longitud 3
		filas.add(9);
		columnasChar.add('d');
		columnasInt.add(3);
		orientaciones.add('r');
		
		//Se intenta colocar el submarine de longitud 3 orientado hacia la izquierda, solapandose con otro
		//la primera casilla es valida
		filas.add(9);
		columnasChar.add('g');
		columnasInt.add(6);
		orientaciones.add('l');
		
		//Se intenta colocar submarine de longitud 3 orientado hacia la izquierda
		//las 2 primeras columnas son validas pero la tercera no
		filas.add(9);
		columnasChar.add('h');
		columnasInt.add(7);
		orientaciones.add('l');
		
		//Intentar colocar el submarine de longitud 3 solapando una casilla hacia arriba
		filas.add(7);
		columnasChar.add('a');
		columnasInt.add(0);
		orientaciones.add('u');
		
		//Colocamos el submarine de longitud 3
		filas.add(8);
		columnasChar.add('a');
		columnasInt.add(0);
		orientaciones.add('u');
		
		//Colocamos el destroyer de longitud 2
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
		//Comprobar que cuando se crea un jugador la vida es 5(numero de barcos vivos)
		jugador2.actualizarVida(jugador2);
		assertEquals(5, jugador2.getVida());
		
		//Si un barco sufre un impacto pero no esta hundido la vida del jugador tiene que seguir siendo 5
		jugador2.getBarcos()[0].actualizarVida();
		jugador2.actualizarVida(jugador2);
		assertEquals(5, jugador2.getVida());
		
		Jugador jugador = new Jugador(1);
		int j = 0;
		//Se comprueba que cuando se hunden todos los barcos del jugador, su vida sea 0
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
		//Se colocan los barcos de jugador 1 y 2
		MockCoordenadas mc1 = new MockCoordenadas();
		Jugador jugador1 = new Jugador(1);
		jugador1.setCoordenadas(mc1);
		jugador1.colocarBarcos();
		
		MockCoordenadas mc2 = new MockCoordenadas();
		Jugador jugador2 = new Jugador(2);		
		jugador2.setCoordenadas(mc2);
		jugador2.colocarBarcos();
		
		//Los jugadores disparan sobre el tablero
		while(!mc1.getQFilas().isEmpty() && !mc1.getQColumnasInt().isEmpty() && mc1.getQOrientaciones().isEmpty()) {
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
