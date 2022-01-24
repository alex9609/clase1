package practica_adicional_semana11.UI;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import practica_adicional_semana11.ClaseControladora;
import practica_adicional_semana11.Interface_idioma;
import practica_adicional_semana11.Persona;
import practica_adicional_semana11.hablantes.Hablantes;

public class Menu {
	
	Hablantes espaniol = new Hablantes();
	Hablantes frances = new Hablantes();
	Hablantes italiano = new Hablantes();
	Hablantes aleman = new Hablantes();
	Hablantes ingles = new Hablantes();
	Set<Persona> listadoEstudiantes;
	
	public void start() {
		
		Scanner teclado = new Scanner(System.in);

		listadoEstudiantes = new HashSet<Persona>();
		
		ClaseControladora select = new ClaseControladora();
		
		Interface_idioma idioma;

		
		try {
			int opcion;
			do {
				System.out.println("Tiene las siguientes opciones, escoja una: ");
				System.out.println("1. Ingresar una persona: ");
				System.out.println("2. Registrar un idioma aprendido para una persona");
				System.out.println("3. Personas que hablan el mismo idioma");
				System.out.println("4. Listado de persona");
				System.out.println("5. Salir");
				
				opcion = teclado.nextInt();
				teclado.nextLine();
				
				switch(opcion) {
					case 1:
						System.out.println("Ingrese el nombre de la persona");
						String nombre = teclado.next();
						teclado.nextLine();
						
						if(select.existePersona(listadoEstudiantes, nombre)) {
							System.out.println("El usuario ya ha sido registrado");
						}else {
							idioma = select.getIdioma();
							if(idioma != null) {
								Persona valor = new Persona(idioma,nombre);
								this.listadoEstudiantes.add(valor);
								ingresarHablantes(valor,idioma);									
							}else {
								System.out.println("Idioma inexistente");
							}
						}

						break;
					case 2:
						System.out.println("Ingrese el nombre de la persona que aprendio el lenguaje");
						nombre = teclado.next();
						teclado.nextLine();
						
						if(select.existePersona(this.listadoEstudiantes,nombre)) {
							for(Persona user :this.listadoEstudiantes) {
								if(user.getNombre().equalsIgnoreCase(nombre)) {
									System.out.println("Ingrese el idioma que " + nombre +" aprendio");
									idioma = select.getIdioma();
									if(idioma != null) {
										boolean hablantes = user.aprender(idioma);
										if(!hablantes) {
											ingresarHablantes(user,idioma);										
										}
										break;	
									}else {
										System.out.println("Idioma no existe");
									}
								}
							}
						}else {
							System.out.println("El usuario no existe en la base de datos");
						}
						
						break;
					case 3:
						System.out.println("Ingrese el idioma para saber quienes hablan este idioma");
							idioma = select.getIdioma();
						if(idioma != null) {
							imprimirHablantes(idioma);							
						}else {
							System.out.println("El idioma seleccionado no existe");
						}
						break;
					case 4:
						for(Persona user :this.listadoEstudiantes) {
							System.out.println(user.getNombre() + " " + user.getNativo().nombreIdioma());
							System.out.println(user.getIdiomas());
							System.out.println("---------------");
						}
						break;
					case 5:
						System.out.println("Gracias....");
						break;
					default:
						System.out.println("Opcion invalida");
				}
				
				
			}while(opcion != 5);
			
		}catch(java.util.InputMismatchException e) {
			System.out.println("Ingrese un valor entero valido");
		}
		
		teclado.close();
	}

	private void ingresarHablantes(Persona user,Interface_idioma idioma) {
		if(idioma.nombreIdioma().equalsIgnoreCase("español")) {
			this.espaniol.agregarHablante(user);
		}
		if(idioma.nombreIdioma().equalsIgnoreCase("ingles")) {
			this.ingles.agregarHablante(user);
		}
		if(idioma.nombreIdioma().equalsIgnoreCase("aleman")) {
			this.aleman.agregarHablante(user);
		}
		if(idioma.nombreIdioma().equalsIgnoreCase("italiano")) {
			this.italiano.agregarHablante(user);
		}
		if(idioma.nombreIdioma().equalsIgnoreCase("frances")) {
			this.frances.agregarHablante(user);
		}
		
	}
	
	private void imprimirHablantes(Interface_idioma idioma) {
		if(idioma.nombreIdioma().equalsIgnoreCase("ingles")) {
			System.out.println("Las personas que hablan ingles son");
			recorrer(this.ingles);
		}
		if(idioma.nombreIdioma().equalsIgnoreCase("español")) {
			System.out.println("Las personas que hablan español son");
			recorrer(this.espaniol);
		}
		if(idioma.nombreIdioma().equalsIgnoreCase("aleman")) {
			System.out.println("Las personas que hablan aleman son");
			recorrer(this.aleman);
		}
		if(idioma.nombreIdioma().equalsIgnoreCase("italiano")) {
			System.out.println("Las personas que hablan italiano son");
			recorrer(this.italiano);
		}
		if(idioma.nombreIdioma().equalsIgnoreCase("frances")) {
			System.out.println("Las personas que hablan frances son");
			recorrer(this.frances);
		}
	}
	
	public void recorrer(Hablantes hablante ) {
		for(Persona person: hablante.getHablante()) {
			System.out.println(person.getNombre());
		}
	}
}
