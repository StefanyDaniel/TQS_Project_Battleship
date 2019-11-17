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
		j1.setVida(2);
		j2.setVida(5);
		p.empezar();
		assertEquals(j1.getVida(),0);
		assertEquals(j2.getVida(),4);
	}
	
	@Test
	public void testCanviaTorn() {
		int t = p.getTurno();
		int e = p.getTEnemigo();
		assertEquals(0,t);
		assertEquals(1,e);
		p.cambiarTurno();
		assertEquals(1,t);
		assertEquals(0,e);
		p.cambiarTurno();
		assertEquals(0,t);
		assertEquals(1,e);
	}

}
