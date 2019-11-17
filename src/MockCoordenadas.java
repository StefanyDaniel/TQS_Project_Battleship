import java.util.LinkedList;
import java.util.Queue;

public class MockCoordenadas implements Coordenadas {
	private Queue<Integer> filas = new LinkedList<>();
	private Queue<Character> columnasChar = new LinkedList<>();
	private Queue<Integer> columnasInt = new LinkedList<>();
	private Queue<Character> orientaciones = new LinkedList<>();
	
	public MockCoordenadas(Queue<Integer> qFilas, Queue<Character> qColumnasChar, Queue<Integer> qColumnasInt,
			Queue<Character> qOrientaciones) {
		//Para colocar los barcos
		filas = qFilas;
		columnasChar = qColumnasChar;
		columnasInt = qColumnasInt;
		orientaciones = qOrientaciones;
	}
	
	public MockCoordenadas(Queue<Integer> qFilas, Queue<Character> qColumnasChar, Queue<Integer> qColumnasInt) {
		//Para realizar disparos
		filas = qFilas;
		columnasChar = qColumnasChar;
		columnasInt = qColumnasInt;
	}
	
	public MockCoordenadas() {
		//Colocar barcos y disparar
		//filas
		filas.add(5);
		filas.add(3);
		filas.add(10);
		filas.add(5);
		filas.add(1);
		
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
		filas.add(1);
		filas.add(7);
		filas.add(10);
		filas.add(3);
		filas.add(5);
		filas.add(1);
		filas.add(10);
		filas.add(10);
		filas.add(1);
		filas.add(5);
		
		//columnas disparo char
		columnasChar.add('a');
		columnasChar.add('a');
		columnasChar.add('j');
		columnasChar.add('j');
		columnasChar.add('e');
		columnasChar.add('e');
		columnasChar.add('a');
		columnasChar.add('h');
		columnasChar.add('j');
		columnasChar.add('d');
		
		//columnas disparo int
		columnasInt.add(0);
		columnasInt.add(0);
		columnasInt.add(9);
		columnasInt.add(9);
		columnasInt.add(4);
		columnasInt.add(4);
		columnasInt.add(0);
		columnasInt.add(7);
		columnasInt.add(9);
		columnasInt.add(3);
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
		System.out.println("Fila: " + filas.peek());
		return filas.poll();
	}

	@Override
	public char getColumnaChar() {
		System.out.println("(char)Columna: " + columnasChar.peek());
		return columnasChar.poll();
	}
	
	
	@Override
	public int getColumnaInt() {
		System.out.println("(int)Columna: " + columnasInt.peek());
		return columnasInt.poll();
	}
	
	@Override
	public char getOrientacion() {
		System.out.println("(char)Orientacion: " + orientaciones.peek());
		return orientaciones.poll();
	}
	
	public Queue<Integer> getQFilas(){
		return filas;
	}
	
	public Queue<Integer> getQColumnasInt() {
		return columnasInt;
	}
	
	public Queue<Character> getQOrientaciones(){
		return orientaciones;
	}
}
