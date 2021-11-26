package clase6MercadoLibrePOO;

public class Articulos {
	String nombre;
	double precio;
	boolean descuento;
	double cantidad_descuento;
	
	Articulos(String nombre, double precio){
		this.nombre = nombre;
		this.precio = precio;
	}
	
	boolean Set_activar_descuento() {
		if(descuento == false) {
			descuento = true;
		}
		
		return descuento;
	}
	
	boolean Set_desactivar_descuento() {
		if(descuento) {
			descuento = false;
		}
		
		return descuento;
	}
	
	double descontar(double cantidad) {
		
		if(descuento) {
			precio = precio * (cantidad/100);
		}else {
			System.out.println("Este articulo no tiene descuento, por favor cambie la categoria de descuento");
		}
		
		return precio;
	}
	
	String get_nombre() {
		return nombre;
	}
	
	void get_info() {
		System.out.println("Nombre: "+ nombre);
		System.out.println("Precio : "+ precio);
		if(descuento) {
			System.out.println("Descuento : Tiene descuendo" );
		}else {
			System.out.println("Descuento : No tiene descuendo" );
		}
		System.out.println("-----------");

	}
	
	
}

