package practica_adicional_semana6;

public class Sucursal {
	
	private int id_sucursal;
	private String ciudad;
	
	
	
	public Sucursal(int id_sucursal, String ciudad) {
		this.id_sucursal = id_sucursal;
		this.ciudad = ciudad;
	}
	
	
	public int getId_sucursal() {
		return id_sucursal;
	}
	public void setId_sucursal(int id_sucursal) {
		this.id_sucursal = id_sucursal;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}


	@Override
	public String toString() {
		return "Sucursal [id_sucursal=" + id_sucursal + ", ciudad=" + ciudad + "]";
	}
	
	
	

}
