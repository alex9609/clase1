package practica_adicional_semana6;

import java.util.Date;

public class Producto {
	private int id_producto;
	private String tipo;  //Ahorro, corriente, prestamo
	private float saldo;
	private Date fecha_apertura;
	
	
	
	public Producto(int id_producto, String tipo, float saldo, Date fecha_apertura) {
		this.id_producto = id_producto;
		this.tipo = tipo;
		this.saldo = saldo;
		this.fecha_apertura = fecha_apertura;
	}
	
	public int getId_producto() {
		return id_producto;
	}
	public void setId_producto(int id_producto) {
		this.id_producto = id_producto;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public float getSaldo() {
		return saldo;
	}

	public Date getFecha_apertura() {
		return fecha_apertura;
	}
	public void setFecha_apertura(Date fecha_apertura) {
		this.fecha_apertura = fecha_apertura;
	}

	@Override
	public String toString() {
		return "Producto [id_producto=" + id_producto + ", tipo=" + tipo + ", saldo=" + saldo + ", fecha_apertura="
				+ fecha_apertura + "]";
	}
	
	
	
	
}
