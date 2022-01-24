package practica_adicional_semana11.hablantes;

import java.util.HashSet;
import java.util.Set;

import practica_adicional_semana11.Persona;

public class Hablantes implements InterfaceHablantes {
	
	Set<Persona> hablantes = new HashSet<Persona>();

	public void agregarHablante(Persona user) {
		hablantes.add(user);
	}

	public Set<Persona> getHablante() {
		return this.hablantes;
	}
	
	
}
