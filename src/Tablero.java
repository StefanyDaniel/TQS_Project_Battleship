
public class Tablero {
	private String[][] tablero;
	private static final int numeroFilas = 10;
	private static final int numeroColumnas = 10;
	private static final String agua = "  ";
	
	public Tablero() {        
        tablero = new String[numeroFilas][numeroColumnas];
        for(int i = 0; i < numeroFilas; i++) {
        	for(int j = 0; j < numeroColumnas; j++) {
        		tablero[i][j] = agua;
        	}
        }
	}
	
	String[][] getTablero(){
		return tablero;
	}
	
	public void colocarBarco(int fila, int columna, char orientacion, int longitud, String alias) {
		switch(orientacion) {
		case 'u':
			for(int i=fila-(longitud-1);i<fila+1;i++) {
				tablero[i][columna]=alias;
			}
			break;
		case 'd':
			for(int i=fila;i<fila+longitud;i++) {
				tablero[i][columna]=alias;
			}
			break;
		case 'r':
			for(int i=columna;i<columna+longitud;i++) {
				tablero[fila][i]=alias;
			}
			break;
		case 'l':
			for(int i=columna-(longitud-1);i<columna+1;i++) {
				tablero[fila][i]=alias;
			}
			break;
		}
	}
}
