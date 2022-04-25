package ar.com.educacionit.generic;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

import javax.servlet.http.Part;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import ar.com.educacionit.domain.Articulos;

public class XLSFileParser extends BaseFile implements IParser<Collection<Articulos>> {

	public XLSFileParser(String path) {
		super(path);
	}
	
	public XLSFileParser(Part filePart) {
		super(filePart);
	}

	public Collection<Articulos> parse() throws ParseException {
		// Libreria poi

		// Crear el File
		File xlsxFile = new File(super.getFilePath());

		Collection<Articulos> articuloLista = new ArrayList<>();
		// leer un binario
		try (InputStream xlsxInputStream = new FileInputStream(xlsxFile);
				Workbook workbook = new XSSFWorkbook(xlsxInputStream);) {

			// Clases propias de la librerias

			// Se importa org.apache.poi.ss.usermodel.Sheet;
			Sheet dataTypeSheet = workbook.getSheetAt(0); // Representa la hoja del excel - Le decimos que nos
															// quedaremos con la primer hoja

			// collection
			// Se importa el Row de org.apache.poi.ss.usermodel.Row
			Iterator<Row> filasDeLaHoja0 = dataTypeSheet.iterator(); // Se itera po cada una de las filas - row

			boolean primerFila = true;
			// TITULO CODIGO PRECIO STOCK MARCASID CATEGORIASID
			while (filasDeLaHoja0.hasNext()) {
				Row filaActual = filasDeLaHoja0.next();// Dentro de los row del archivo excel existen celdas

				if (primerFila) {
					primerFila = false;// Saltamos el primer dato
					continue;
				}

				// Iterar sobre las celdas del row
				Iterator<Cell> celdas = filaActual.iterator();

				// Crear mi articulo
				Articulos articulos = new Articulos();

				while (celdas.hasNext()) {
					this.fromCellToArticulo(celdas, articulos);
				}

				articuloLista.add(articulos);
			}

		} catch (IOException e) {
			throw new ParseException("No se ha podido parsear el archivo : " + getFilePath(), e);
		}

		// articulos
		return articuloLista;
	}
	
	/*
	 * Recorre las celdas de una fila y por cada celda se mira que
	 * atributo corresponde en articulo y setea en dicho valor
	 */
	private void fromCellToArticulo(Iterator<Cell> celdas, Articulos articulos) {
		Cell celdaActual = celdas.next();// Las celdas tienen un indice

		switch (celdaActual.getColumnIndex()) {
		case 0:
			articulos.setTitulo(celdaActual.getStringCellValue()); // Me devuelve el valor de la celda
			break;
		case 1:
			articulos.setCodigo(celdaActual.getStringCellValue()); // Me devuelve el valor de la celda
			break;
		case 2:
			articulos.setPrecio(celdaActual.getNumericCellValue()); // Retorna un valor númerico
			break;
		case 3:
			Long stock = (long) celdaActual.getNumericCellValue();
			articulos.setStock(stock);
			break;
		case 4:
			articulos.setMarcaId((long) celdaActual.getNumericCellValue());
			break;
		case 5:
			articulos.setCategoriaId((long) celdaActual.getNumericCellValue());
			break;
		}
		
		articulos.setFechaCreacion(new Date());
	}

	@Override
	public Collection<Articulos> parseV2() throws ParseException, IOException {
		return null;
	}

}
