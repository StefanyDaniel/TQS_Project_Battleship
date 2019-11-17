
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

}
