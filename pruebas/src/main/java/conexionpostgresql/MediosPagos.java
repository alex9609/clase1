package conexionpostgresql;

public class MediosPagos {
	
	private String codigo;
	private String descripcion;
	private String descripcion_corta;
	private Long habilitada;
	private Long id;
	

	public MediosPagos(String codigo, String descripcion, String descripcion_corta, Long habilitada, Long id) {
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.descripcion_corta = descripcion_corta;
		this.habilitada = habilitada;
		this.id = id;
	}


	public MediosPagos() {
		super();
	}


	public String getCodigo() {
		return codigo;
	}


	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public String getDescripcion_corta() {
		return descripcion_corta;
	}


	public void setDescripcion_corta(String descripcion_corta) {
		this.descripcion_corta = descripcion_corta;
	}


	public Long getHabilitada() {
		return habilitada;
	}


	public void setHabilitada(Long habilitada) {
		this.habilitada = habilitada;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	@Override
	public String toString() {
		return "MediosPagos [codigo=" + codigo + ", descripcion=" + descripcion + ", descripcion_corta="
				+ descripcion_corta + ", habilitada=" + habilitada + ", id=" + id + "]";
	}
	
	
	
	
	
	

}
