package practica_adicional_semana13.dominio;

import java.util.Date;

public class Articulos {

	private String titulo;
	private String codigo;
	private Double precio;
	private Long stock;
	private Long marcaId;
	private Long categoriaId;
	private Date fechaCreacion;

	public Articulos(String titulo, String codigo, Double precio, Long stock, Long marcaId, Long categoriaId) {
		this.titulo = titulo;
		this.codigo = codigo;
		this.precio = precio;
		this.stock = stock;
		this.marcaId = marcaId;
		this.categoriaId = categoriaId;
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
		return marcaId;
	}

	public void setMarcaId(Long marcaId) {
		this.marcaId = marcaId;
	}

	public Long getCategoriaId() {
		return categoriaId;
	}

	public void setCategoriaId(Long categoriaId) {
		this.categoriaId = categoriaId;
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
				+ ", marcaId=" + marcaId + ", categoriaId=" + categoriaId + ", fechaCreacion=" + fechaCreacion + "]";
	}

	
}