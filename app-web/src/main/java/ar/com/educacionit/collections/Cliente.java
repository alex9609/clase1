package ar.com.educacionit.collections;

import java.util.Objects;

public class Cliente {
	
	private String dni;
	private String nombre;
	
	
	
	public Cliente(String dni, String nombre) {
		this.dni = dni;
		this.nombre = nombre;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
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
		return Objects.hash(dni);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(dni, other.dni);
	}
	
	//Generar un hashcode and equals para determinar la unicidad del objeto
	//que un valor sea unico
	
	
}
