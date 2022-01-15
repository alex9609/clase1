package practica_adicional_semana9.domain;

import java.util.Arrays;

public class DatosDBMemoria {
	private int tamanio = 4;
	private Inscripciones[] inscripcion = new Inscripciones[tamanio];

	public DatosDBMemoria() {
		
	}

	public Inscripciones getInscripcion(int posicion) {
		
		return inscripcion[posicion];
	}

	public void setInscripcion(Inscripciones insc,int posicion) {
		this.inscripcion[posicion] = insc;
	}

	public String toString() {
		return "DatosDBMemoria [inscripcion=" + Arrays.toString(inscripcion) + "]";
	}	
	
	
	public void recorrerInscripciones() {
		for(Inscripciones inscr:this.inscripcion) {
			if(inscr != null) {
				System.out.println(inscr.toString());
			}else {
				System.out.println("Inscripción vacia");
			}
		}
	}
	
	public int getTamanio() {
		return this.tamanio;
	}
	
	
	
	

}
