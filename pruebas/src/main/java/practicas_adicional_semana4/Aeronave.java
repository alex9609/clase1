package practicas_adicional_semana4;

public  class Aeronave extends Voladores{
	
	private String marca;
	private String modelo;
	private String placa;
	private String piloto;
	private int capacidad_pasajeros;
	private boolean tren_aterrizaje = false;
	

	

	public Aeronave(String tipo, int id, String nombre, String marca, String modelo, String placa, String piloto,
			int capacidad_pasajeros) {
		
		super(tipo, id, nombre);
		this.marca = marca;
		this.modelo = modelo;
		this.placa = placa;
		this.piloto = piloto;
		this.capacidad_pasajeros = capacidad_pasajeros;
	}
	
	
	public boolean desplegandoTren() {
		System.out.println("Desplegando tren de aterrizaje....");
		if(!this.tren_aterrizaje) {
			this.tren_aterrizaje = true;
		}
		return this.tren_aterrizaje;
		
	}
	
	public boolean getTrenAterrizaje() {
		return this.tren_aterrizaje;
	}


	public void reportarAterrizaje() {
		desplegandoTren();
		System.out.println("Permiso para aterrizar...");
		
	}


	public String getPiloto() {
		return piloto;
	}


	public void setPiloto(String piloto) {
		this.piloto = piloto;
	}


	public String getMarca() {
		return marca;
	}


	public String getModelo() {
		return modelo;
	}


	public String getPlaca() {
		return placa;
	}


	public int getCapacidad_pasajeros() {
		return capacidad_pasajeros;
	}


	public String toString() {
		return "Aeronave [marca:" + marca + ", modelo:" + modelo + ", placa:" + placa + "]";
	}
	
	

	
}
