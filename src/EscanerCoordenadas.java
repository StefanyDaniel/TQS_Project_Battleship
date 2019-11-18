import java.util.Scanner;

public class EscanerCoordenadas implements Coordenadas {
	private int fila;
	private int columnaInt;
	private char columnaChar;
	private char orientacion;
	
	public EscanerCoordenadas() {
		this.fila = -1;
		this.columnaChar = '\0';
		this.columnaInt = -1;
		this.orientacion = '\0';
	}
	
	@Override
	public void setFila() {
		Scanner capturarFila = new Scanner(System.in);
		String numero = "";
		
		System.out.print("Introduce la fila (Recuerda que el rango de valores es de 1 a 10): ");
		numero = capturarFila.nextLine();
		//Quita todos los espacios en blanco que haya en la cadena
		numero = numero.replaceAll("\\s", "");
	    try
	    {
	    	if(numero.length() > 1 && numero.startsWith("0")) { //Si hay mas de un caracter y empieza por 0 es incorrecto
	    		fila = -1;
	    	}
	    	else if(numero.length() >= 1) {
	    		fila = Integer.parseInt(numero);
	    	}
	    }
	    catch(NumberFormatException e) {
	    	//System.out.println("Fila solo permite numeros enteros!");
	    	fila = -1;
	    }
	    
		/*if(capturarFila.hasNextInt()) {
			fila = capturarFila.nextInt();
		}
		else {
			fila = -1;
		}*/
	}

	@Override
	public void setColumna() {
		Scanner capturarColumna = new Scanner(System.in);
		
		System.out.print("Introduce la columna (Recuerda que el rango de valores es de A a J): ");
		//Character.toLowerCase() convierte el caracter de capturaColumna en minuscula
		columnaChar = Character.toLowerCase(capturarColumna.next().charAt(0));
		columnaInt = convertirColumnaCharToInt(columnaChar);
	}

	@Override
	public void setOrientacion() {
		Scanner capturarOrientacion = new Scanner(System.in);
		
		System.out.print("Orientacion del barco (U:Up, D:Down, L:Left, R:Right): ");
		orientacion = Character.toLowerCase(capturarOrientacion.next().charAt(0));
	}
	
	public int convertirColumnaCharToInt(char columna) {
		int charToInt = -1;
		columna = Character.toLowerCase(columna);
		
		for(int i = 0; i < Tablero.numeroColumnas; i++) {
			if(columna == Character.toLowerCase(Tablero.valorColumnas[i])) {
				charToInt = i;
			}
		}
		return charToInt;
	}

	@Override
	public int getFila() {
		return fila;
	}

	@Override
	public char getColumnaChar() {
		return columnaChar;
	}

	@Override
	public int getColumnaInt() {
		return columnaInt;
	}

	@Override
	public char getOrientacion() {
		return orientacion;
	}
}
