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
	
	@Test
	public void testMarcarImpacto() {
		Tablero tablero=new Tablero();
		Barco[] barcosEnemigo = new Barco[] {
                new Barco("Barco", 5),
                new Barco("Barco", 4),
                new Barco("Barco", 3),
                new Barco("CBarco", 3),
                new Barco("Barco", 2)
        };
		tablero.colocarBarco(0, 0, 'd', 5, "B5");
		tablero.colocarBarco(9, 0, 'r', 4, "B4");
		tablero.colocarBarco(9, 9, 'u', 3, "B3");
		tablero.colocarBarco(0, 9, 'l', 3, "C3");
		tablero.colocarBarco(4, 4, 'r', 2, "B2");
		
		boolean I=t.marcarImpacto(tablero, barcosEnemigo, 0, 0);
		assertEquals(I,true);
		int V=barcosEnemigo[0].getVida();
		assertEquals(V,4);
		boolean I1=t.marcarImpacto(tablero, barcosEnemigo, 9, 9);
		assertEquals(I1,true);
		int V1=barcosEnemigo[2].getVida();
		assertEquals(V1,2);
		boolean I2=t.marcarImpacto(tablero, barcosEnemigo, 9, 0);
		assertEquals(I2,true);
		int V2=barcosEnemigo[1].getVida();
		assertEquals(V2,3);
		boolean I3=t.marcarImpacto(tablero, barcosEnemigo, 4, 4);
		assertEquals(I3,true);
		int V3=barcosEnemigo[4].getVida();
		assertEquals(V3,1);
		boolean I4=t.marcarImpacto(tablero, barcosEnemigo, 4, 5);
		assertEquals(I4,true);
		int V4=barcosEnemigo[4].getVida();
		assertEquals(V4,0);
		boolean I5=t.marcarImpacto(tablero, barcosEnemigo, 4, 4);
		assertEquals(I5,false);
		int V5=barcosEnemigo[4].getVida();
		assertEquals(V5,0);
		boolean H5=barcosEnemigo[4].isHundido();
		assertEquals(H5,true);
		assertEquals(t.getTablero()[4][4]," H");
		assertEquals(t.getTablero()[4][5]," H");
		boolean I6=t.marcarImpacto(tablero, barcosEnemigo, -1, 0);
		assertEquals(I6,false);
		boolean I7=t.marcarImpacto(tablero, barcosEnemigo, 4, 9);
		assertEquals(I7,true);
		boolean I8=t.marcarImpacto(tablero, barcosEnemigo, 0, 5);
		assertEquals(I8,true);
		boolean I9=t.marcarImpacto(tablero, barcosEnemigo, 0, -1);
		assertEquals(I9,false);
	}
}
