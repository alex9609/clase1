package practica_adicional_semana6;

import java.util.Date;

public class Empleado extends Persona{
	private int telefono;
	private Date fecha_incorporacion;
	private String rango; //Jefe - Subordinado
	
	public Empleado(String nombre, int identificacion, int telefono, Date fecha_incorporacion, String rango) {
		super(nombre, identificacion);
		this.telefono = telefono;
		this.fecha_incorporacion = fecha_incorporacion;
		this.rango = rango;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public Date getFecha_incorporacion() {
		return fecha_incorporacion;
	}

	public void setFecha_incorporacion(Date fecha_incorporacion) {
		this.fecha_incorporacion = fecha_incorporacion;
	}

	public String getRango() {
		return rango;
	}

	public void setRango(String rango) {
		this.rango = rango;
	}

	@Override
	public String toString() {
		return "Empleado [telefono=" + telefono + ", fecha_incorporacion=" + fecha_incorporacion + ", rango=" + rango
				+ ", nombre=" + nombre + ", identificacion=" + identificacion + "]";
	}

	
	
	

}
