
public class Partida {
	private char opcion;
	private int turno;
	private int enemigo;
	private Jugador[] jugador = new Jugador[2];
	private Coordenadas coordenadas;
	
	public Partida(char opcionMenu) {
		opcion = opcionMenu;
		turno = 0;
		enemigo = 1;
		coordenadas = new EscanearCoordenadas();
		Jugador j1 = new Jugador(1);
		Jugador j2 = new Jugador(2);
		
	}
	
	public void setJugadors(Jugador j1, Jugador j2) {
		jugador[0]=j1;
		jugador[1]=j2;
	}
	
	public void empezar() {
		Jugador j = new MockJugador(1);
		if(opcion == '1') {
			jugador[0].setCoordenadas(coordenadas);
			jugador[1].setCoordenadas(coordenadas);
			jugador[0].colocarBarcos();
			jugador[1].colocarBarcos();
			do {
				j=jugador[turno];
				System.out.println("Te toca jugador " + this.jugador[turno].getId());
				System.out.println("Configurando coordenadas de disparo...");
				j.disparar(jugador[enemigo]);
				cambiarTurno();
			} while(!isFinalPartida());
		}
	}
	
	public void cambiarTurno() {
		if(turno == 0) {
			turno = 1;
			enemigo = 0;
		}
		else {
			turno = 0;
			enemigo = 1;
		}
	}
	
	public boolean isFinalPartida() {
		boolean partidaAcabada = false;
		
		if(jugador[0].getVida() == 0) {
			partidaAcabada = true;
			System.out.println("Fin de la partida!");
			System.out.println("Ha ganado el jugador " + jugador[1].getId());
		}
		else if(jugador[1].getVida() == 0) {
			partidaAcabada = true;
			System.out.println("Fin de la partida!");
			System.out.println("Ha ganado el jugador " + jugador[0].getId());
		}
		
		return partidaAcabada;
	}
}
