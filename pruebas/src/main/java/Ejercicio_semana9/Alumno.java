package Ejercicio_semana9;

public class Alumno {
	
	//Esto es directo de la clase - no de la instancia
	//Cuando instancio un objeto el atributo estatico va a ser igual para todos
	private static int contador = 0;
	
	private int id;
	private int dni;
	private String nombre;
	//private String apellido;

	
	public Alumno(String nombre, int dni) {
		contador += 1;
		this.id = contador;
		this.nombre = nombre;
		this.dni = dni;
		
	}


	public int getDni() {
		return dni;
	}


	public void setDni(int dni) {
		this.dni = dni;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + dni;
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Alumno other = (Alumno) obj;
		if (dni != other.dni)
			return false;
		return true;
	}
	
	
	
	
	
	
	

}
