package ar.com.educacionit.domain;

public class Marcas {
	
	private Long id;
	private String marca;
	private String codigo;
	private Long habilitada; //1 ó 0
	
	public Marcas(Long id, String marca, String codigo, Long habilitada) {
		this.id = id;
		this.marca = marca;
		this.codigo = codigo;
		this.habilitada = habilitada;
	}

	public Marcas(String marca, String codigo, Long habilitada) {
		this.marca = marca;
		this.codigo = codigo;
		this.habilitada = habilitada;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Long getHabilitada() {
		return habilitada;
	}

	public void setHabilitada(Long habilitada) {
		this.habilitada = habilitada;
	}

	@Override
	public String toString() {
		return "Marcas [id=" + id + ", marca=" + marca + ", codigo=" + codigo + ", habilitada=" + habilitada + "]";
	}
	
	
	
	
	
	

}
