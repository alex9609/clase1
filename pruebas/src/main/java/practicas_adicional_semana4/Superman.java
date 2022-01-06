package practicas_adicional_semana4;

public class Superman extends Voladores {

	private String planeta_nacimiento = "Crypton";
	
	public Superman(String tipo, int id, String nombre) {
		super(tipo, id, nombre);
	}

	public String getPlaneta_nacimiento() {
		return planeta_nacimiento;
	}

	public void reportarAterrizaje() {
		System.out.println("Permiso para aterrizar Superman");
	}
	
	

}
