package clase9.oop.herencia;

public class CineMain {

	public static void main(String[] args) {
		
		
		//Persona persona = new Persona("Persona1","Apellido 1","Negro");
		
		//Una clase abstracta tampoco se puede instanciar.

		Empleado empleado = new Empleado("NombreEmpleado","ApellidoEmpleado1","Rojo",1);
		Efectivo efectivo = new Efectivo("NombreEfectivo1","ApellidoEfectivo1","Rubio",1);
		Contratado contratado = new Contratado("NombreContratado1","ApellidoContratado1","Azul", 1,6);
		
		Director director = new Director("NombreDirector1","ApellidoDirector1","Negro",10);
		
		//Todas las personas pueden ir al cine
		Persona[] personas = new Persona[4];
		
		//personas[0] = persona;
		personas[0] = empleado;
		personas[1] = efectivo;
		personas[2] = contratado;
		personas[3] = director;
		
		//Recorrer las personas que entran al cine y saber si son un Director
		
		//Por definicion todas las clases heredan de Object y heredan los metodos
		// toString()
		// hashCode
		// equals..
		for(Persona user: personas) {
			System.out.println("---");
			user.detalle();
			
						
			//Queremos saber si user es una instande de Director
			if(user instanceof Director) {
				
				//Castear una persona a director
				Director a = (Director)user;
				System.out.println(a.getNombre());
				System.out.println("VIP para: ");
				System.out.println("Director: " + user.toString());

			}else {
				System.out.println("No VIP");
			}
		}
		
		empleado.detalle();
		
		Empleado empleado2 = new Empleado("NombreEmpleado2","ApellidoEmpleado2","Rojo",2);
		
		//No hace falta crear un Director
		//porque el método delegar no le pertenece a una instancia en particular
		//sino a la clase Director
		Director.delegar(empleado2, "archivar");
		
		
		
	}

}
