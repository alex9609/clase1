package practica_adicional_semana6;

public class Administracion {
	
	private int id_sucursal;
	private int id_empleado;
	
	
	
	public Administracion(int id_sucursal, int id_empleado) {
		this.id_sucursal = id_sucursal;
		this.id_empleado = id_empleado;
	}
	public int getId_sucursal() {
		return id_sucursal;
	}
	public void setId_sucursal(int id_sucursal) {
		this.id_sucursal = id_sucursal;
	}
	public int getId_empleado() {
		return id_empleado;
	}
	public void setId_empleado(int id_empleado) {
		this.id_empleado = id_empleado;
	}
	
	public String toString() {
		return "Administracion [id_sucursal=" + id_sucursal + ", id_empleado=" + id_empleado + "]";
	}
	
	
	
	
	

}
