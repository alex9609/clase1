package practica_adicional_semana11;

import java.util.Scanner;
import java.util.Set;

public class ClaseControladora {
	Interface_idioma es = new Espaniol();
	Interface_idioma en = new Ingles();			
	Interface_idioma it = new Italiano();			
	Interface_idioma fr = new Frances();			
	Interface_idioma gr = new Aleman();
	

	//Pasar este metodo a un menu
	public  Interface_idioma getIdioma() {
		
		System.out.println("Ingrese el idioma ");
		System.out.println("es - Para español");
		System.out.println("en - Para ingles");
		System.out.println("it - Para italiano");
		System.out.println("fr - Para frances");
		System.out.println("gr - Para aleman");
		
		
		Scanner teclado2 = new Scanner(System.in);
		String leng = teclado2.next();
		teclado2.nextLine();
		
		if(leng.equalsIgnoreCase("es")) {
			return this.es;
		}
		if(leng.equalsIgnoreCase("en")) {
			return this.en;
		}
		if(leng.equalsIgnoreCase("it")) {
			return this.it;
		}
		if(leng.equalsIgnoreCase("fr")) {
			return this.fr;
		}
		if(leng.equalsIgnoreCase("gr")) {
			return this.gr;
		}else {
			return null;
		}
		
	}
	
	//Verificar si en un set Existe un valor
	public boolean existePersona(Set<Persona> conjunto, String valor) {
		boolean existe = false;
		for(Persona user:conjunto) {
			existe = user.getNombre().equalsIgnoreCase(valor);
			if(existe) {
				break;
			}
		}
		System.out.println(existe);
		return existe;
		
	}
	
}
