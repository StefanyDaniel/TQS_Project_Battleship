
public class Partida {
	private char opcion;
	private int turno;
	private int enemigo;
	private Jugador[] jugador = new Jugador[2];
	private Coordenadas coordenadas;
	private boolean error;
	
	public Partida(char opcionMenu) {
		opcion = opcionMenu;
		turno = 0;
		enemigo = 1;
		coordenadas = new EscanerCoordenadas();
		Jugador j1 = new Jugador(1);
		Jugador j2 = new Jugador(2);
		setJugadors(j1,j2);
		error = false;
		
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
			while(!isFinalPartida() || error) {
				j=jugador[turno];
				System.out.println("Te toca jugador " + this.jugador[turno].getId());
				System.out.println("Configurando coordenadas de disparo...");
				j.disparar(jugador[enemigo]);
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				cambiarTurno();
			}
		}
		if(error) {
			System.out.println("Partida acabada per Error");
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
	
	public int getTurno() {
		return turno;
	}
	
	public int getTEnemigo() {
		return enemigo;
	}
	
	public boolean isFinalPartida() {
		boolean isfinal = false;
		for(Jugador j:jugador) {
			if(j.getVida()>=0 && j.getVida()<=5) {
				if(j.getVida()==0) {
					if(isfinal) {
						error = true;
						return false;
					}
					System.out.println("Fin de la partida!");
					System.out.println("Ha ganado el jugador " + j.getId());
					isfinal=true;
				}
			}
			else {
				error = true;
				System.out.println("Error en la vida de Jugador");
				return false;
			}
		}
		return isfinal;
	}
}
