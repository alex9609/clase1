package practica_adicional_semana11;

import java.util.HashSet;
import java.util.Set;

public class Persona {
	
	private Interface_idioma nativo;
	private Set<Interface_idioma> idiomas_aprendidos;
	private String nombre;
	
	
	public Persona(Interface_idioma nativo,String nombre) {
		this.nativo = nativo;
		this.idiomas_aprendidos = new HashSet<Interface_idioma>();
		this.nombre = nombre;
	}
	
	public boolean aprender(Interface_idioma idioma_aprendido) {
		Boolean aprendio = false;
		if(!nativo.equals(idioma_aprendido)) {
			boolean confirmacion = this.idiomas_aprendidos.add(idioma_aprendido);
			if(confirmacion) {
				System.out.println("Idioma ha sido aprendido");
			}else {
				System.out.println("El idioma ya ha sido aprendido");
				aprendio = true;
				
			}
		}else {
			System.out.println("El idioma es el nativo, ya lo aprendio");
		}
		return aprendio;
	}
	

	public Set<String> getIdiomas(){
		Set<String> idiomas = new HashSet<String>();
		for(Interface_idioma leng:this.idiomas_aprendidos) {
			idiomas.add(leng.nombreIdioma());
		}
		return idiomas;
	}
	
	public Interface_idioma getNativo() {
		return this.nativo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String toString() {
		return "Persona [nativo=" + nativo + ", nombre=" + nombre + "]";
	}

	
	
	
	
	
	
	
	
	
}
