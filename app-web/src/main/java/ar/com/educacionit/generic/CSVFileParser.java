package ar.com.educacionit.generic;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.servlet.http.Part;

import ar.com.educacionit.domain.Articulos;

public class CSVFileParser extends BaseFile implements IParser<Collection<Articulos>> {

	public CSVFileParser(Part filePart) {
		super(filePart);
	}

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
		// Leo el archivo con un FileReader
		try (FileReader fileReader = new FileReader(file);) {

			// FileaReader es un reader -> El constructor de BufferedReader espera un Reader
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
			return articulos;
		} catch (IOException e) {
			throw new ParseException(e.getMessage(), e);
		}finally {
			//Cerrar br
		}

	}

	public Collection<Articulos> parseV2() throws ParseException, IOException {

		InputStream is = null;
		FileReader fileReader = null;
		BufferedReader br = null;
		try {

			// Detectar si tiene el path como String o el part enviado
			if (this.filePart != null) {
				is = this.filePart.getInputStream();
				br = new BufferedReader(new InputStreamReader(is));
			} else {
				File file = new File(super.getFilePath());
				if (!file.exists()) {
					throw new ParseException("No existe el archivo: " + super.getFilePath());
				}
				fileReader = new FileReader(file);
				br = new BufferedReader(fileReader);
			}
			return this.buildArchivos(br);
		}catch(IOException ie){
			throw new ParseException(ie.getMessage(), ie);
		}finally {
			if (br != null) {
				br.close();
			}

		}
	}

	public Collection<Articulos> buildArchivos(BufferedReader br) throws IOException {
		Collection<Articulos> articulos = new ArrayList<Articulos>();
		String lineaLeida = br.readLine();
		
		lineaLeida = br.readLine();
		// id,titulo,precio;

		// vuelvo a leer para tomas los "registros"
		
		while (lineaLeida != null) {
			String[] datos = lineaLeida.split(";");
			String titulo = datos[0];	
			String codigo = datos[1];
			String precio = datos[2]; 
			String stock = datos[3];
			String marcas = datos[5];
			String categoria = datos[4];
			
			// Creo el articulo
			//validador
			
			Articulos unArticulo = new Articulos(titulo, codigo,Double.parseDouble(precio),Long.parseLong(stock),Long.parseLong(marcas),Long.parseLong(categoria));
			articulos.add(unArticulo);

			lineaLeida = br.readLine();
		}
		return articulos;
	}

}
