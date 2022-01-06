package ar.com.educacionit.domain;

import java.util.Date;

public class ArticuloTest {

	public static void main(String[] args) {
		
		//Probamos con prubeas unitarias a traves de src/test/java creamos
		//un package identifico y la clase con el metodo
		
		//Assert aserciones sobre algo
		Articulos miArticulo = new Articulos("titulo1", new Date(), "0001", 2500d, 5, 1l, 1l);
		
		String titulo = miArticulo.getTitulo(true);
		
		boolean iguales = titulo.equals("TITULO1");
		
		if(iguales) {
			System.out.println("ok");
		}else {
			System.out.println("fail");
		}
	}

}
