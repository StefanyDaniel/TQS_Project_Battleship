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
		t = p.getTurno();
		e = p.getTEnemigo();
		assertEquals(1,t);
		assertEquals(0,e);
		p.cambiarTurno();
		t = p.getTurno();
		e = p.getTEnemigo();
		assertEquals(0,t);
		assertEquals(1,e);
	}
	
	@Test
	public void testFinalPartida() {
		p.setJugadors(j1, j2);
		boolean f = p.isFinalPartida();
		assertEquals(false,f);
		j1.setVida(0);
		j2.setVida(5);
		boolean f1 = p.isFinalPartida();
		assertEquals(true,f1);
		j1.setVida(5);
		j2.setVida(0);
		boolean f2 = p.isFinalPartida();
		assertEquals(true,f2);
		j1.setVida(5);
		j2.setVida(1);
		boolean f3 = p.isFinalPartida();
		assertEquals(false,f3);
		j1.setVida(1);
		j2.setVida(5);
		boolean f4 = p.isFinalPartida();
		assertEquals(false,f4);
		j1.setVida(-1);
		j2.setVida(5);
		boolean f5 = p.isFinalPartida();
		assertEquals(false,f5);
		j1.setVida(5);
		j2.setVida(-1);
		boolean f6 = p.isFinalPartida();
		assertEquals(false,f6);
		j1.setVida(6);
		j2.setVida(0);
		boolean f7 = p.isFinalPartida();
		assertEquals(false,f7);
		j1.setVida(0);
		j2.setVida(6);
		boolean f8 = p.isFinalPartida();
		assertEquals(false,f8);
		j1.setVida(0);
		j2.setVida(0);
		boolean f9 = p.isFinalPartida();
		assertEquals(false,f9);
	}

}
