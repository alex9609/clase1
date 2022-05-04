package ar.com.educacionit.streams;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import ar.com.educacionit.domain.Articulos;
import ar.com.educacionit.services.Impl.ArticulosServiceImpl;
import ar.com.educacionit.services.exceptions.ServiceException;

public class Reduce {
	
	public static void main(String[] args) throws ServiceException {
		//Convertir edades de integer a String
		Collection<Articulos> list = new ArticulosServiceImpl().findAll();
		
		Double suma = list.stream()
		.map(x -> x.getPrecio())
		.peek(x -> System.out.println(x))
		.reduce(0d,(x,y) -> x+y); //Valor inicial (x,y) -> x+y

		System.out.println(suma);
		
		//Sumar el total
		
		
		
	}

}
