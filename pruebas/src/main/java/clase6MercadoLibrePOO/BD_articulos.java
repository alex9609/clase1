package clase6MercadoLibrePOO;

public class BD_articulos {
	Articulos Laptop = new Articulos("HP", 12000);
	Articulos consola1 = new Articulos("XBOX ONE", 15000);
	Articulos Laptop2 = new Articulos("Asus Legion", 22000);
	Articulos consola2 = new Articulos("PS5", 30000);
	boolean encontrado;
	
	
	Articulos[] Base_datos = new Articulos[] {Laptop,consola1,Laptop2,consola2};
	
	
	void busqueda_Palabra_clave(String palabra_clave) {
		for(Articulos arti: Base_datos) {
			if(arti.get_nombre().equalsIgnoreCase(palabra_clave)) {
				arti.get_info();
				this.encontrado = true;
			}
		}
		
		if(!this.encontrado) {
			System.out.println("El articulo no se encuentra");
		}
		
		
	}
	
	void inventario() {
		for(Articulos arti: Base_datos) {
			arti.get_info();
		}
	}
}
