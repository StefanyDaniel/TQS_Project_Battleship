import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class PartidaTest {

	Partida p = new Partida('1');
	Jugador j1 = new MockJugador(1);
	Jugador j2 = new MockJugador(2);
	
	@Test
	public void testEmpezar() {
		p.setJugadors(j1, j2);
		p.empezar();
		assertEquals(j1.getVida(),1);
		assertEquals(j2.getVida(),0);
	}
	
	@Test
	public void testCanviaTorn() {
		
	}
}
