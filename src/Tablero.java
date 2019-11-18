
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
	
	public void setTablero(String[][] t) {
		tablero=t;
	}
	
	public void colocarBarco(int fila, int columna, char orientacion, int longitud, String alias) {
		switch(orientacion) { //Siempre recibimos valores correctos
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
	
	public void mostrar() {
		System.out.println("----------------------------------");
		System.out.println("|  | A| B| C| D| E| F| G| H| I| J|");
		System.out.println("----------------------------------");
		for(int i = 0; i < numeroFilas; i++) {
			if(i != 9) {
				System.out.print("| " + (i + 1));
			}
			else {
				System.out.print("|" + (i + 1));
			}
			for(int j = 0; j < numeroColumnas; j++) {
				System.out.print("|" + tablero[i][j]);
			}
			System.out.println("|");
			System.out.println("----------------------------------");
		}
	}
	
	public boolean marcarImpacto(Tablero configuracionBarcosEnemigo, Barco[] barcosEnemigo, int fila, int columna) {
		boolean impactoMarcado = false;		
		//Aqui no siempre recibimos valores correctos de fila y columna.
		if(Comprobacion.isFilaCorrecta(fila)) {
			if(Comprobacion.isColumnaCorrecta(columna)) {
				if(tablero[fila][columna] == agua) {
					if(configuracionBarcosEnemigo.getTablero()[fila][columna] == agua) {
						tablero[fila][columna] = " O";
						impactoMarcado = true;
					}
					else {
						tablero[fila][columna] = " T";
						String alias = configuracionBarcosEnemigo.getTablero()[fila][columna];
						for(Barco b : barcosEnemigo) {
							if(b.getAlias().equals(alias)) {
								b.actualizarVida();
								if(b.isHundido()) {
									hundir(configuracionBarcosEnemigo,b);
								}
							}
						}
						impactoMarcado = true;
					}
				}
				else {
					System.out.println("Ya has disparado en esta posicion!");
				}
			}
		}
		return impactoMarcado;
	}
	
	public void hundir(Tablero configuracionBarcosEnemigo, Barco bHundido) {
		//Metodo testeado junto con marcarImpacto, metodo sencillo para test.
		String[][] t = configuracionBarcosEnemigo.getTablero();
		for(int fila=0; fila<numeroFilas; fila++) {
			for(int columna=0; columna<numeroColumnas; columna++) {
				if(t[fila][columna].equals(bHundido.getAlias())) {
					tablero[fila][columna] = " H";
				}
			}
		}
	}
	static int getNColumnas() {
		return numeroColumnas;
	}
}
