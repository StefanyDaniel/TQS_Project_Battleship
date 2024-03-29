
public class Jugador {
	private int id;
	private Tablero configuracionBarcos;
	private Tablero registroDisparos;
	private Barco[] barcos;
	private Coordenadas coordenadas;
	private int vida;
	
	public Jugador(int idJugador) {
		this.id = idJugador;
		this.configuracionBarcos = new Tablero();
		this.registroDisparos = new Tablero();
        this.barcos = new Barco[] {
                new Barco("Carrier", 5),
                new Barco("Battleship", 4),
                new Barco("Cruiser", 3),
                new Barco("Submarine", 3),
                new Barco("Destroyer", 2)
        };
        this.vida = barcos.length;
	}
	
	public boolean colocarBarcos() {
		boolean barcoColocado = false;
		configuracionBarcos.mostrar();
		
		for(Barco barco : barcos) {
			barcoColocado = false;
			do {
				System.out.println("Jugador " + id + ", introduce las coordenas donde quieres colocar el "
						+ barco.getNombre() + " (longitud: " + barco.getLongitud() + ")");
				coordenadas.setFila();
				coordenadas.setColumna();
				coordenadas.setOrientacion();
				int fila = coordenadas.getFila();
				int columna = coordenadas.getColumnaInt();
				char orientacion = coordenadas.getOrientacion();
				//Como el usuario introduce para fila, valores entre 1 y 10
				//tenemos que usar fila - 1 para poder acceder a las posiciones del tablero
				if(Comprobacion.isOrientacionCorrecta(configuracionBarcos, fila - 1, columna, orientacion, barco.getLongitud())) {
					configuracionBarcos.colocarBarco(fila - 1, columna, orientacion, barco.getLongitud(), barco.getAlias());
					barcoColocado = true;
				}
			} while(!barcoColocado);
			configuracionBarcos.mostrar();
		}
		
		return true;
	}
	
	public void setCoordenadas(Coordenadas coordenadaIntroducida) {
		coordenadas = coordenadaIntroducida;
	}
	
	public void actualizarVida(Jugador jugador) {
		int barcosRestantes = 0;
		for(Barco barco : jugador.getBarcos()) {
			if(!barco.isHundido()) {
				barcosRestantes++;
			}
		}
		vida = barcosRestantes;
	}
	
	public boolean disparar(Jugador jugadorEnemigo) {
		boolean disparoRealizado = false;
		int fila = -1;
		int columna = -1;
		
		registroDisparos.mostrar();
		configuracionBarcos.mostrar();
		do {
			System.out.println("Jugador " + id + ", introduce las coordenas de disparo");
			coordenadas.setFila();
			coordenadas.setColumna();
			fila = coordenadas.getFila();
			columna = coordenadas.getColumnaInt();
		} while(!registroDisparos.marcarImpacto(jugadorEnemigo.configuracionBarcos, jugadorEnemigo.getBarcos(), fila - 1, columna));
		disparoRealizado = true;
		actualizarVida(jugadorEnemigo);
		registroDisparos.mostrar();
		configuracionBarcos.mostrar();
		
		return disparoRealizado;
	}
	
	public void setVida(int v) {
		vida=v;
	}
	
	public int getId() {
		return id;
	}
	
	public Tablero getConfiguracionBarcos() {
		return configuracionBarcos;
	}
	
	public Tablero getRegistroDisparos() {
		return registroDisparos;
	}
	
	public Barco[] getBarcos() {
		return barcos;
	}
	
	public int getVida() {
		return vida;
	}
}
	
	