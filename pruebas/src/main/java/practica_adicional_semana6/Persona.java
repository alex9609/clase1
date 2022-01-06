package practica_adicional_semana6;

public class Persona {
	
	protected String nombre;
	protected int identificacion;
	
	public Persona(String nombre, int identificacion) {
		this.nombre = nombre;
		this.identificacion = identificacion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(int identificacion) {
		this.identificacion = identificacion;
	}

	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", identificacion=" + identificacion + "]";
	}
	
	
	
	

}
