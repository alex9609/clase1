package practica_adicional_semana9.domain;

public class Inscripciones  implements Entity {
	
	private static int contador = 0;
	private int id;
	private Alumno alumno;
	private Materia materia;
	
	public Inscripciones(Alumno alumno, Materia materia) {
		contador +=1;
		this.id = contador;
		this.alumno = alumno;
		this.materia = materia;
	}
	

	public Alumno getAlumno() {
		return alumno;
	}
	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}
	public Materia getMateria() {
		return materia;
	}
	public void setMateria(Materia materia) {
		this.materia = materia;
	}

	public  int getId() {
		return id;
	}




	@Override
	public String toString() {
		return "Inscripciones [id="+ this.getId() + ", alumno= " + alumno.getNombre()+" " + alumno.getId()  + ", materia= " + materia.getId()+" " + materia.getCurso() + "]";
	}
	
	
	
	
	
	
	
	
	
	

}
