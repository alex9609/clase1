package ar.com.educacionit.generic;

import java.util.Collection;

import ar.com.educacionit.domain.Articulos;
import ar.com.educacionit.services.ArticulosService;
import ar.com.educacionit.services.Impl.ArticulosServiceImpl;
import ar.com.educacionit.services.exceptions.ServiceException;

public class TestXLSParser {
	
	public static void main(String[] args) {
		
		String path = "C:/Users/alexa/OneDrive/Documentos/Desarrollo/Articulo.xlsx";
		
		IParser<Collection<Articulos>> articulos = new XLSFileParser(path);
		
		try {
			Collection<Articulos> articuloLista = articulos.parse();
			for(Articulos art : articuloLista) {
				System.out.println(art.toString());
				
			}
		} catch (ParseException e) {
			e.printStackTrace();
			System.err.println(e);
		}

		
	}

}
