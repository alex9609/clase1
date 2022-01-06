package practica_adicional_semana6;

public class Cliente extends Persona {
	private String calle;
	private String ciudad;
	
	public Cliente(String nombre, int identificacion, String calle, String ciudad) {
		super(nombre, identificacion);
		this.calle = calle;
		this.ciudad = ciudad;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	@Override
	public String toString() {
		return "Cliente [calle=" + calle + ", ciudad=" + ciudad + ", nombre=" + nombre + ", identificacion="
				+ identificacion + "]";
	}

	
	
	
	
	
	
}
