package practica_adicional_semana9.domain;

public class Materia  implements Entity{
	
	private int id_Materia;
	private String curso;
	private String turno;
	public Materia(int id_Materia, String curso, String turno) {
		this.id_Materia = id_Materia;
		this.curso = curso;
		this.turno = turno;
	}
	
	
	public int getId() {
		return id_Materia;
	}
	public void setId(int id_Materia) {
		this.id_Materia = id_Materia;
	}
	public String getCurso() {
		return curso;
	}
	public void setCurso(String curso) {
		this.curso = curso;
	}
	public String getTurno() {
		return turno;
	}
	public void setTurno(String turno) {
		this.turno = turno;
	}

	
	public String toString() {
		return "Materia [id_Materia=" + id_Materia + ", curso=" + curso + ", turno=" + turno + "]";
	}
	
	
	
	

}
