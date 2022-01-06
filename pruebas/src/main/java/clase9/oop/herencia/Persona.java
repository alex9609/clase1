package clase9.oop.herencia;

public abstract  class Persona {

	//Atributos
	
	private String nombre;
	protected String apellido;
	public String colorPelo;
	public final int cantidadOrejas = 2;
	public static int cantidadNariz= 1;
	
	
	
	//Constructor
	public Persona(String nombre, String apellido, String colorPelo) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.colorPelo = colorPelo;
	}
	
	
	
	//Getters y setter
	public String getNombre() {
		return nombre;
	}
	public  void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getColorPelo() {
		return colorPelo;
	}
	public void setColorPelo(String colorPelo) {
		this.colorPelo = colorPelo;
	}
	
	public void detalle() {
		System.out.println(toString());
		detallar();
	}


	//Metodo es del Object, pero Persona le cambia el comportamiento
	public String toString() {
		return "Persona [nombre=" + nombre + ", apellido=" + apellido + ", colorPelo=" + colorPelo + "]";
	}
	
	public abstract void detallar(); // metodo no implementado -> Los hijos deben definir o implementar el comportamiento
	
}
