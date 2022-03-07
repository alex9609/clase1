package ar.com.educacionit.generic;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import ar.com.educacionit.domain.Articulos;

public class CSVFileParser extends BaseFile implements IParser<Collection<Articulos>> {

	public CSVFileParser(String path) {
		super(path);
	}

	public Collection<Articulos> parse() throws ParseException {

		// Lista vacia de articuslo
		Collection<Articulos> articulos = new ArrayList<>();

		File file = new File(super.getFilePath());

		if (!file.exists()) {
			throw new ParseException("No existe el archivo: " + super.getFilePath());
		}
		//Leo el archivo con un FileReader
		try (FileReader fileReader = new FileReader(file);) {
			
			//FileaReader es un reader  -> El constructor de BufferedReader espera un Reader
			try (BufferedReader br = new BufferedReader(fileReader);) {
				// Leer la primer linea y la descarto porque tiene los titulos
				String lineaLeida = br.readLine();
				// id,titulo,precio;

				// vuelvo a leer para tomas los "registros"
				lineaLeida = br.readLine();
				while (lineaLeida != null) {
					String[] datos = lineaLeida.split(";");
					String id = datos[0]; // => Id
					String titulo = datos[1];
					String precio = datos[2];

					// Creo el articulo
					Articulos unArticulo = new Articulos(Long.parseLong(id), titulo, Double.parseDouble(precio));
					articulos.add(unArticulo);
					
					lineaLeida = br.readLine();
				}
			}
		} catch (IOException e) {
			throw new ParseException(e.getMessage(), e);
		}
		return articulos;

	}

}
