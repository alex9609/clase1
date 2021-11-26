package clase6MercadoLibrePOO;

public class Buscador {
	
	String palabra_clave;
	BD_articulos newDB = new BD_articulos();
	
	Buscador(String palabra_clave){
		this.palabra_clave = palabra_clave;
	}
	
	void mostrar_productos(){
		newDB.inventario();
	}
	
	void buscar(){
		System.out.println("Estamos buscando... ");
		System.out.println("       ");
		newDB.busqueda_Palabra_clave(this.palabra_clave);	
		
	}
	
	

}
