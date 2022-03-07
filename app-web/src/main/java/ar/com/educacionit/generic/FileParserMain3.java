package ar.com.educacionit.generic;

import java.util.Collection;

import ar.com.educacionit.domain.Articulos;

public class FileParserMain3 {

	public static void main(String[] args) throws ParseException {
		
		String path = "C:/Users/alexa/OneDrive/Documentos/Desarrollo/Articulo.xlsx";
		
		IParser<Collection<Articulos>> parser = new XLSFileParser(path);
		//XLSFileParser parser = new XLSFileParser(path);
		
		try {
			Collection<Articulos> listaArticulos = parser.parse();
			for(Articulos art : listaArticulos ) {
				System.out.println(art.toString());
				
			}
		} catch (ParseException e) {
			throw new ParseException("Existe algun error" ,e);
		}
	}

}
