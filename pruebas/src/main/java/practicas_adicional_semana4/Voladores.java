package practicas_adicional_semana4;

public abstract class Voladores {
	
	protected String tipo;
	protected int Id;
	protected String nombre;
	
	
	
	public Voladores(String tipo, int id, String nombre) {
		this.tipo = tipo;
		this.Id = id;
		this.nombre = nombre;
	}

	public abstract void reportarAterrizaje();

	public String toString() {
		return "Volador [tipo: " + tipo + ", Id: " + Id + ", nombre: " + nombre + "]";
	}
	
	

}
