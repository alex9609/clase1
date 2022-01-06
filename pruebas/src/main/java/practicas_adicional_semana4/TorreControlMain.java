package practicas_adicional_semana4;

public class TorreControlMain {

	public static void main(String[] args) {
		
		//tipo,id, nombre, marca, modelo, placa, piloto, capacidad_pasajeros, motores
		Avion airbus = new Avion("Comercial", 1001, "coloso", "Airbus", "A320", "HAK102","Alex", 150, 4);
		
		// tipo, id, nombre, marca, modelo, placa, piloto, capacidad_pasajeros, peso_maximo, capacidad_carga
		Helicoptero black = new Helicoptero("Guerra", 1032, "gigante", "black", "new-340R", "HAK140", "Camilo", 6, 200, 400);
		
		//  tipo,  id,  nombre
		Ovni marciano = new Ovni("UFO",12,"Marciano");
		Superman superman = new Superman("Humano",1021221,"Clark");
		
		Aeronave vehiculo = new Aeronave(null, 0, null, null, null, null, null, 0);
		
		Voladores[] vectorVoladores = new Voladores[] {airbus,black,marciano,superman,vehiculo};
		
		for(Voladores fly:vectorVoladores) {
			
			
			if(fly instanceof Aterrizable && fly instanceof Aeronave) {
				System.out.println(" ");
				System.out.println(fly);
				fly.reportarAterrizaje();
				Aterrizable volador = (Aterrizable)fly;
				volador.aterrizar();
				
				System.out.println("-------------------------");
			}else {
				System.out.println(" ");
				System.out.println(fly);
				System.out.println("Permiso denegado - No puede aterrizar ");
				System.out.println("------------------");
			}
		}
		

	}

}
