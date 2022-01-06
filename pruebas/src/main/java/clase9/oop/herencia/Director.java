package clase9.oop.herencia;

public class Director extends Persona{
	private Integer empACargo;

	//Puedo tener mas de un constructor
	
	

	public Director(String nombre, String apellido, String colorPelo, Integer empACargo) {
		super(nombre, apellido, colorPelo);
		this.empACargo = empACargo;
	}


	public Director(String nombre, String apellido, String colorPelo) {
		super(nombre, apellido, colorPelo);
	}


	public Integer getEmpACargo() {
		return empACargo;
	}


	public void setEmpACargo(Integer empACargo) {
		this.empACargo = empACargo;
	}


	public void detallar() {
		System.out.println(this.empACargo + " Personas a cargo");
	}
	
	//Método estatico
	public static void delegar(Empleado empleado, String tarea) {
		empleado.detalle();
		System.out.println("Ejecutando tarea :" + tarea);
	}
	
	
	

}
