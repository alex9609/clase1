package ar.com.educacionit.domain;

public class Categorias implements Entity{
	
	private Long id;
	private String descripcion;
	private String codigo;
	
	public Categorias() {
		
	}
	
	
	//Constructor
	public Categorias(Long id, String descripcion, String codigo) {
		this.id = id;
		this.descripcion = descripcion;
		this.codigo = codigo;
	}
	

	public Categorias(String descripcion, String codigo) {
		super();
		this.descripcion = descripcion;
		this.codigo = codigo;
	}




	//get/set
	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public String getCodigo() {
		return codigo;
	}


	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}


	@Override
	public String toString() {
		return "Categoria [id=" + id + ", descripcion=" + descripcion + ", codigo=" + codigo + "]";
	}
	
	
	
	//Metodos
	

}
