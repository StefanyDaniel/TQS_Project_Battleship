import java.util.LinkedList;
import java.util.Queue;

public class MockCoordenadas implements Coordenadas {
	private Queue<Integer> filas = new LinkedList<>();
	private Queue<Character> columnasChar = new LinkedList<>();
	private Queue<Integer> columnasInt = new LinkedList<>();
	private Queue<Character> orientaciones = new LinkedList<>();
	private Queue<Integer> filasDisparo = new LinkedList<>();
	private Queue<Character> columnasDisparoChar = new LinkedList<>();
	private Queue<Integer> columnasDisparoInt = new LinkedList<>();
	
	public MockCoordenadas(Queue<Integer> qFilas, Queue<Character> qColumnasChar, Queue<Integer> qColumnasInt,
			Queue<Character> qOrientaciones) {
		filas = qFilas;
		columnasChar = qColumnasChar;
		columnasInt = qColumnasInt;
		orientaciones = qOrientaciones;
	}
	
	public MockCoordenadas() {
		//filas
		filas.add(4);
		filas.add(2);
		filas.add(9);
		filas.add(6);
		filas.add(0);
		
		//columnas char
		columnasChar.add('a');
		columnasChar.add('g');
		columnasChar.add('j');
		columnasChar.add('j');
		columnasChar.add('e');
		
		//columnas int
		columnasInt.add(0);
		columnasInt.add(6);
		columnasInt.add(9);
		columnasInt.add(9);
		columnasInt.add(4);
		
		//orientacion
		orientaciones.add('r');
		orientaciones.add('d');
		orientaciones.add('l');
		orientaciones.add('u');
		orientaciones.add('l');
		
		//filas disparo
		filasDisparo.add(0);
		filasDisparo.add(6);
		filasDisparo.add(9);
		filasDisparo.add(2);
		filasDisparo.add(4);
		filasDisparo.add(0);
		filasDisparo.add(9);
		filasDisparo.add(9);
		filasDisparo.add(0);
		filasDisparo.add(4);
		
		//columnas disparo char
		columnasDisparoChar.add('a');
		columnasDisparoChar.add('a');
		columnasDisparoChar.add('j');
		columnasDisparoChar.add('j');
		columnasDisparoChar.add('e');
		columnasDisparoChar.add('e');
		columnasDisparoChar.add('a');
		columnasDisparoChar.add('h');
		columnasDisparoChar.add('j');
		columnasDisparoChar.add('d');
		
		//columnas disparo int
		columnasDisparoInt.add(0);
		columnasDisparoInt.add(0);
		columnasDisparoInt.add(9);
		columnasDisparoInt.add(9);
		columnasDisparoInt.add(4);
		columnasDisparoInt.add(4);
		columnasDisparoInt.add(0);
		columnasDisparoInt.add(7);
		columnasDisparoInt.add(9);
		columnasDisparoInt.add(3);
	}
	
	@Override
	public void setFila() {
		//No hace nada
	}
	
	@Override
	public void setColumna() {
		//No hace nada
	}
	
	@Override
	public void setOrientacion() {
		//No hace nada
	}

	@Override
	public int getFila() {
		return filas.poll();
	}

	@Override
	public char getColumnaChar() {
		return columnasChar.poll();
	}
	
	@Override
	public char getColumnasDisparoChar() {
		return columnasDisparoChar.poll();
	}

	@Override
	public int getColumnaInt() {
		return columnasInt.poll();
	}
	
	
	@Override
	public int getColumnaDisparoInt() {
		return columnasDisparoInt.poll();
	}

	@Override
	public char getOrientacion() {
		return orientaciones.poll();
	}
	
	
}
