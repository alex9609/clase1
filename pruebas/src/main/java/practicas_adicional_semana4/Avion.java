package practicas_adicional_semana4;

public class Avion extends Aeronave implements Aterrizable{
	
	private int cantidad_motores;

	public Avion(String tipo, int id, String nombre, String marca, String modelo, String placa, String piloto,
			int capacidad_pasajeros,int cantidad_motores) {
		super(tipo, id, nombre, marca, modelo, placa, piloto, capacidad_pasajeros);
		this.cantidad_motores = cantidad_motores;
	}

	public int getCantidad_motores() {
		return cantidad_motores;
	}
	
	
	public String toString() {
		return "Avion [tipo: " + tipo + ", Id: " + Id + ", nombre: " + nombre + "]";
	}

	public void aterrizar() {
		System.out.println("Puedo aterrizar ");
	}

}
