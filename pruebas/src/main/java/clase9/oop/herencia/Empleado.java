package clase9.oop.herencia;

public class Empleado extends Persona{
	
	//Atributo propio
	private Integer id;	
		
	
	public Empleado(String nombre, String apellido, String colorPelo) {
		super(nombre, apellido, colorPelo);
	}

	//Constructor de la clase
	public Empleado(String nombre, String apellido, String colorPelo,Integer id) {
		//Antes de que nasca el empleado nace la persona
		super(nombre, apellido, colorPelo);
		this.id = id;		
		//Puedo "Setear los atributos propios
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	//Cambiar el comportamiento del padre (reutilizar lo del padre + lo propio)
	public void detallar() {
		System.out.println(this.getId());
	}


	
}
