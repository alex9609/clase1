package practica_adicional_semana13.dominio;

import java.util.Date;

public class Articulos implements Entity {

	private String titulo;
	private String codigo;
	private Double precio;
	private Long stock;
	private Long marcaID;
	private Long categoriaID;
	private Date fechaCreacion;

	public Articulos(String titulo, String codigo, Double precio, Long stock, Long marcaId, Long categoriaId) {
		this.titulo = titulo;
		this.codigo = codigo;
		this.precio = precio;
		this.stock = stock;
		this.marcaID = marcaId;
		this.categoriaID = categoriaId;
	}

	public Articulos() {

	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public Long getStock() {
		return stock;
	}

	public void setStock(Long stock) {
		this.stock = stock;
	}

	public Long getMarcaId() {
		return marcaID;
	}

	public void setMarcaId(Long marcaId) {
		this.marcaID = marcaId;
	}

	public Long getCategoriaId() {
		return categoriaID;
	}

	public void setCategoriaId(Long categoriaId) {
		this.categoriaID = categoriaId;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	@Override
	public String toString() {
		return "Articulos [titulo=" + titulo + ", codigo=" + codigo + ", precio=" + precio + ", stock=" + stock
				+ ", marcaId=" + marcaID + ", categoriaId=" + categoriaID + ", fechaCreacion=" + fechaCreacion + "]";
	}

	
}