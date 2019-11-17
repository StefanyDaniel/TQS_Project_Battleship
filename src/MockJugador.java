
public class MockJugador extends Jugador{
	private int id;
	private int vida=5;
	private Tablero t;
	
	public MockJugador(int idMock) {
		super(idMock);
		id=idMock;
		t=new Tablero();
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean colocarBarcos() {
		return true;
	}

	@Override
	public void setCoordenadas(Coordenadas c) {}


	public void disparar(MockJugador jugadorEnemigo) {
		int v=jugadorEnemigo.getVida();
		v--;
		jugadorEnemigo.setVida(v);
	}

	@Override
	public int getVida() {
		return vida;
	}

	@Override
	public int getId() {
		return id;
	}

	public void setVida(int v) {
		vida=v;
	}
}
