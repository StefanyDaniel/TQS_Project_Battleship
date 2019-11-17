import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.Test;

class TableroTest {

	Tablero t = new Tablero();
	int numFilas=10;
	int numColumnas=10;
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final PrintStream originalOut = System.out;

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
	@Test
	public void testMostrar() {
		String resultado = "----------------------------------\n" + 
				"|  | A| B| C| D| E| F| G| H| I| J|\n" + 
				"----------------------------------\n" + 
				"| 1|  |  |  |  |  |  |  |  |  |  |\n" + 
				"----------------------------------\n" + 
				"| 2|  |  |  |  |  |  |  |  |  |  |\n" + 
				"----------------------------------\n" + 
				"| 3|  |  |  |  |  |  |  |  |  |  |\n" + 
				"----------------------------------\n" + 
				"| 4|  |  |  |  |  |  |  |  |  |  |\n" + 
				"----------------------------------\n" + 
				"| 5|  |  |  |  |  |  |  |  |  |  |\n" + 
				"----------------------------------\n" + 
				"| 6|  |  |  |  |  |  |  |  |  |  |\n" + 
				"----------------------------------\n" + 
				"| 7|  |  |  |  |  |  |  |  |  |  |\n" + 
				"----------------------------------\n" + 
				"| 8|  |  |  |  |  |  |  |  |  |  |\n" + 
				"----------------------------------\n" + 
				"| 9|  |  |  |  |  |  |  |  |  |  |\n" + 
				"----------------------------------\n" + 
				"|10|  |  |  |  |  |  |  |  |  |  |\n" + 
				"----------------------------------\n" +
				"----------------------------------\n" + 
				"|  | A| B| C| D| E| F| G| H| I| J|\n" + 
				"----------------------------------\n" + 
				"| 1|B1|B1|B1|B1|B1|  |  |  |  |B4|\n" + 
				"----------------------------------\n" + 
				"| 2|  |  |  |  |  |  |  |  |  |B4|\n" + 
				"----------------------------------\n" + 
				"| 3|  |  |  |  |  |  |  |  |  |B4|\n" + 
				"----------------------------------\n" + 
				"| 4|  |  |  |  |  |  |  |  |  |B4|\n" + 
				"----------------------------------\n" + 
				"| 5|  |  |  |B5|B5|B5|  |  |  |B4|\n" + 
				"----------------------------------\n" + 
				"| 6|  |  |  |  |  |  |  |  |  |B4|\n" + 
				"----------------------------------\n" + 
				"| 7|  |  |  |  |  |  |  |  |  |B4|\n" + 
				"----------------------------------\n" + 
				"| 8|  |  |  |  |  |  |  |  |  |B3|\n" + 
				"----------------------------------\n" + 
				"| 9|  |  |  |  |  |  |  |  |  |B3|\n" + 
				"----------------------------------\n" + 
				"|10|B2|B2|B2|B2|B2|  |  |  |  |B3|\n" + 
				"----------------------------------\n";
		System.setOut(new PrintStream(outContent));
		t.mostrar();
		t.colocarBarco(0, 0, 'r', 5, "B1");
		t.colocarBarco(9, 4, 'l', 5, "B2");
		t.colocarBarco(9, 9, 'u', 3, "B3");
		t.colocarBarco(0, 9, 'd', 7, "B4");
		t.colocarBarco(4, 5, 'l', 3, "B5");
		t.mostrar();
		assertEquals(resultado,outContent.toString());
	}

}
