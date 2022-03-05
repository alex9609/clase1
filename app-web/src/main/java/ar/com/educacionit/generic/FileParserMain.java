package ar.com.educacionit.generic;

import java.util.ArrayList;
import java.util.Collection;

import com.google.protobuf.ServiceException;

import ar.com.educacionit.domain.Articulos;
import ar.com.educacionit.services.ArticulosService;
import ar.com.educacionit.services.Impl.ArticulosServiceImpl;

public class FileParserMain {

	public static void main(String[] args) {
		String path = "./src/main/java/ar/com/educacionit/generic/Articulos.csv";

		IParser<Collection<Articulos>> parser = new CSVFileParser(path);
		int cantidadRegistro = 0;
		Double precioTotal = 0d;

		try {
			Collection<Articulos> articulos = parser.parse();
			cantidadRegistro = articulos.size();

			for (Articulos articulo : articulos) {
				System.out.println(articulo);
				precioTotal = precioTotal + articulo.getPrecio();

			}
		} catch (ParseException e) {
			e.printStackTrace();
		}

		System.out.println("Cantidad procesados : " + cantidadRegistro);
		System.out.println("Precio tota : " + precioTotal);
	}

}
