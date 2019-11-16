
public class Barco {
	private String nombre;
	private String alias;
	private int longitud;
	private int vida;
	private boolean hundido;
	
	public Barco(String nombreBarco, int longitudBarco) {
		this.nombre = nombreBarco;
		this.longitud = longitudBarco;
		this.vida = longitudBarco;
		this.alias = nombreBarco.charAt(0) + Integer.toString(longitudBarco);
		this.hundido = false;
	}
	
	public void actualizarVida() {
		if(vida > 0) {
			vida--;
			
			if(isHundido()) {
				System.out.println("Tocado y hundido");
			}
			else {
				System.out.println("Tocado");
			}
		}
	}

	public String getNombre() {
		return nombre;
	}
	
	public String getAlias() {
		return alias;
	}
	
	public int getLongitud() {
		return longitud;
	}
	
	public int getVida() {
		return vida;
	}
	
	public boolean isHundido() {
		if(vida == 0) {
			hundido = true;
		}
		
		return hundido;
	}
}
