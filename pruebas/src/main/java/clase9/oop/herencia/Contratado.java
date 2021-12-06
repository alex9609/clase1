package clase9.oop.herencia;

public class Contratado extends Empleado{
	private int periodo;
	
	
	
	public Contratado(String nombre, String apellido, String colorPelo, Integer id) {
		super(nombre, apellido, colorPelo, id);
	}

	public Contratado(String nombre, String apellido, String colorPelo, Integer id,int periodo) {
		super(nombre, apellido, colorPelo, id);
		this.periodo = periodo;
	}

	public int getPeriodo() {
		return periodo;
	}

	public void setPeriodo(int periodo) {
		this.periodo = periodo;
	}

	public void detallar() {
		System.out.println(this.getPeriodo() + "Este es el periodo");
	}
	
	
	

}
