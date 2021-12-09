package practicas_adicional_semana4;

public class Helicoptero extends Aeronave implements Aterrizable{
	
	private int peso_maximo;
	private int capacidad_carga;


	public Helicoptero(String tipo, int id, String nombre, String marca, String modelo, String placa, String piloto,
			int capacidad_pasajeros,int peso_maximo,int capacidad_carga) {
		
		super(tipo, id, nombre, marca, modelo, placa, piloto, capacidad_pasajeros);
		this.peso_maximo = peso_maximo;
		this.capacidad_carga = capacidad_carga;
	}
	
	
	public int getPeso_maximo() {
		return peso_maximo;
	}

	public int getCapacidad_carga() {
		return capacidad_carga;
	}
	
	

	public String toString() {
		return "Helicoptero [tipo: "  + tipo + ", Id; " + Id + ", nombre: " + nombre + "]";
	}


	public void aterrizar() {
		System.out.println("Puedo aterrizar ");
	}
	
	
	
}
