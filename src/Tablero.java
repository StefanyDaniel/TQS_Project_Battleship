
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
}
