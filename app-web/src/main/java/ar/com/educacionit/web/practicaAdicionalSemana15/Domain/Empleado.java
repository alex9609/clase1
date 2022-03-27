package ar.com.educacionit.web.practicaAdicionalSemana15.Domain;


public class Empleado {
	
	private Long documento;
	private String nombre;
	private String apellido;
	private Long edad;
	private String ocupacion;
	private String FechaNacimiento;
	
	
	

	public Empleado(Long documento, String nombre, String apellido, Long edad, String ocupacion,
			String fechaNacimiento) {
		this.documento = documento;
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.ocupacion = ocupacion;
		FechaNacimiento = fechaNacimiento;
	}

	public Long getDocumento() {
		return documento;
	}

	public void setDocumento(Long documento) {
		this.documento = documento;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Long getEdad() {
		return edad;
	}

	public void setEdad(Long edad) {
		this.edad = edad;
	}

	public String getOcupacion() {
		return ocupacion;
	}

	public void setOcupacion(String ocupacion) {
		this.ocupacion = ocupacion;
	}

	public String getFechaNacimiento() {
		return FechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		FechaNacimiento = fechaNacimiento;
	}
	
	
	
	

}
