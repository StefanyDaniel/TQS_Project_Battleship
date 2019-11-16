import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TableroTest {

	Tablero t = new Tablero();
	int numFilas=10;
	int numColumnas=10;

	@Test
	public void testCrearTablero() {
		String[][] tableroBarcosEsperado = {
				{"  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  "},
				{"  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  "},
				{"  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  "},
				{"  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  "},
				{"  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  "},
				{"  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  "},
				{"  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  "},
				{"  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  "},
				{"  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  "},
				{"  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  "}
		};
		String[][] tableroBarcos=t.getTablero();
		for(int i=0;i<numFilas;i++) {
			for(int j=0;j<numColumnas;j++) {
				assertEquals(tableroBarcos[i][j],tableroBarcosEsperado[i][j]);
			}
		}
	}
	@Test
	public void testColocarBarco() {
		String[][] tableroBarcosEsperado = {
				{"B1", "B1", "B1", "B1", "B1", "  ", "  ", "  ", "  ", "B4"},
				{"  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "B4"},
				{"  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "B4"},
				{"  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "B4"},
				{"  ", "  ", "  ", "B5", "B5", "B5", "  ", "  ", "  ", "B4"},
				{"  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "B4"},
				{"  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "B4"},
				{"  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "B3"},
				{"  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "B3"},
				{"B2", "B2", "B2", "B2", "B2", "  ", "  ", "  ", "  ", "B3"}
		};
		t.colocarBarco(0, 0, 'r', 5, "B1");
		t.colocarBarco(9, 4, 'l', 5, "B2");
		t.colocarBarco(9, 9, 'u', 3, "B3");
		t.colocarBarco(0, 9, 'd', 7, "B4");
		t.colocarBarco(4, 5, 'l', 3, "B5");
		String[][] tableroBarcos=t.getTablero();
		for(int i=0;i<numFilas;i++) {
			for(int j=0;j<numColumnas;j++) {
				assertEquals(tableroBarcos[i][j],tableroBarcosEsperado[i][j]);
			}
		}
	}

}
