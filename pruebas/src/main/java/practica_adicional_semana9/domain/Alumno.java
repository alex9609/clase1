package practica_adicional_semana9.domain;

public class Alumno implements Entity {
	private String nombre;
	private int Identificacion;
	private int matricula;
	private String apellidoPa;
	private String apellidoMa;
	
	public Alumno() {
		
	}
	public Alumno(String nombre, int identificacion, int matricula, String apellidoPa, String apellidoMa) {
		this.nombre = nombre;
		Identificacion = identificacion;
		this.matricula = matricula;
		this.apellidoPa = apellidoPa;
		this.apellidoMa = apellidoMa;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getId() {
		return Identificacion;
	}
	public void setIdentificacion(int identificacion) {
		Identificacion = identificacion;
	}
	public int getMatricula() {
		return matricula;
	}
	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}
	public String getApellidoPa() {
		return apellidoPa;
	}
	public void setApellidoPa(String apellidoPa) {
		this.apellidoPa = apellidoPa;
	}
	public String getApellidoMa() {
		return apellidoMa;
	}
	public void setApellidoMa(String apellidoMa) {
		this.apellidoMa = apellidoMa;
	}
	
	
	public String toString() {
		return "Alumno [nombre=" + nombre + ", Identificacion=" + Identificacion + ", matricula=" + matricula
				+ ", apellidoPa=" + apellidoPa + ", apellidoMa=" + apellidoMa + "]";
	}
	
	
	
	
	
	

}
