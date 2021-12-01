package practica_adicional_semana3;

//Clase examen que nos permite almacenar el numero de examen y la nota de cada uno de ellos
public class Examen {
	int n_examen;
	double nota;
	
	Examen(int n_examen, double nota){
		this.n_examen = n_examen;
		this.nota = nota;
	}
	
	
	double obtenerNota() {
		return this.nota;
	}
}
