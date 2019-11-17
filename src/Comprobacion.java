
public class Comprobacion {
	
	private static int MAXFILAS=10;
	private static int MAXCOLUMNAS=10;
	
	Comprobacion(){
	}
	
	static boolean isFilaCorrecta(int fila) {
		boolean filaCorrecta = false;
		
		if(fila >= 0 && fila < MAXFILAS) {
			filaCorrecta = true;
		}
		
		return filaCorrecta;
	}
	
	static boolean isColumnaCorrecta(int columna) {
		boolean columnaCorrecta = false;
		
		if(columna >= 0 && columna < MAXCOLUMNAS) {
			columnaCorrecta = true;
		}
		
		return columnaCorrecta;
	}
	static boolean isCoordenadaCorrecta(int fila, int columna) {
		boolean coordenadaCorrecta = false;
		
		if(isFilaCorrecta(fila)) {
			if(isColumnaCorrecta(columna)) {
				coordenadaCorrecta = true;
			} 
			else {
				System.out.println("Columna fuera de rango");
			}
		} 
		else {
			System.out.println("Fila fuera de rango");
		}
		
		return coordenadaCorrecta;
	}
	
	static boolean isOrientacionCorrecta(Tablero tablero, int fila, int columna, char orientacion, int longitudBarco) {
		String[][] t= tablero.getTablero();
		String agua = "  ";
		int filaInicial = -1;
		int filaFinal = -1;
		int columnaInicial = -1;
		int columnaFinal = -1;
		int i = 0;
		if(longitudBarco>=2 && longitudBarco<=5) {
			switch(orientacion) {
			case 'u':
				filaInicial = fila - longitudBarco + 1;
				filaFinal = fila;
				if(isFilaCorrecta(filaInicial) && isFilaCorrecta(filaFinal)) {
					while(i < longitudBarco) {
						if(t[i + filaInicial][columna] != agua) {
							System.out.println("La casilla no esta vacia");
							return false;
						}
						else {
							i++;
						}
					}
				}
				else {
					System.out.println("No se puede colocar el barco. Espacio insuficiente");
					return false;
				}
				break;
			case 'd':
				filaInicial = fila;
				filaFinal = fila + longitudBarco;
				if(isFilaCorrecta(filaInicial) && isFilaCorrecta(filaFinal)) {
					while(i < longitudBarco) {
						if(t[i + filaInicial][columna] != agua) {
							System.out.println("La casilla no esta vacia");
							return false;
						}
						else {
							i++; 
						}
					}
				}
				else {
					System.out.println("No se puede colocar el barco. Espacio insuficiente");
					return false;
				}
				break;
			case 'r':
				columnaInicial = columna;
				columnaFinal = columna + longitudBarco;
				if(isColumnaCorrecta(columnaInicial) && isColumnaCorrecta(columnaFinal)) {
					while(i < longitudBarco) {
						if(t[fila][i + columnaInicial] != agua) {
							System.out.println("La casilla no esta vacia");
							return false;
						}
						else {
							i++;
						}
					}
				}
				else {
					System.out.println("No se puede colocar el barco. Espacio insuficiente");
					return false;
				}
				break;
			case 'l':
				columnaInicial = columna - longitudBarco + 1;
				columnaFinal = columna;
				if(isColumnaCorrecta(columnaInicial) && isColumnaCorrecta(columnaFinal)) {
					while(i < longitudBarco) {
						if(t[fila][i + columnaInicial] != agua) {
							System.out.println("La casilla no esta vacia");
							return false;
						}
						else {
							i++;
						}
					}
				}
				else {
					System.out.println("No se puede colocar el barco. Espacio insuficiente");
					return false;
				}
				break;
			default:
				System.out.println("Orientacion intrducida incorrecta");
				return false;
			}
		}
		else {
			System.out.println("Longitud del barco incorrecta");
			return false;
		}
		return true;
	}
}
