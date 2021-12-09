package practicas_adicional_semana4;

public class Ovni extends Voladores {
	
	private String mensaje = "010001 1110111 1101110 111011101";

	public Ovni(String tipo, int id, String nombre) {
		super(tipo, id, nombre);
	}
	
	public String getMensaje() {
		return mensaje;
	}

	public void reportarAterrizaje() {
		System.out.println("Permiso para aterrizar de Ovni");
	}


}
