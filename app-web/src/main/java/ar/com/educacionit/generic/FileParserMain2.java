package ar.com.educacionit.generic;

import java.util.ArrayList;
import java.util.Collection;

import ar.com.educacionit.domain.Articulos;
import ar.com.educacionit.services.ArticulosService;
import ar.com.educacionit.services.Impl.ArticulosServiceImpl;
import ar.com.educacionit.services.exceptions.ServiceException;

public class FileParserMain2 {

	public static void main(String[] args) throws ServiceException {
		
		String path = "./src/main/java/ar/com/educacionit/generic/Articulos.csv";

		IParser<Collection<Articulos>> parser = new CSVFileParser(path);
		
		Collection<Articulos> articulos = new ArrayList<>();
		try {
			articulos = parser.parse();
		}catch(ParseException e){
			e.printStackTrace();
		}
		
		if(!articulos.isEmpty()) {
			try {
				//Grabar en la db
				ArticulosService service = new ArticulosServiceImpl();
				
			}catch(Exception e) {
				throw new ServiceException(e.getMessage(),e);
			}
		}
	}

}
