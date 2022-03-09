package practica_adicional_semana13.control;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import practica_adicional_semana13.Exceptions.ParseException;
import practica_adicional_semana13.dominio.Articulos;


public class XLSXFile extends BaseFile implements IParser<Collection<Articulos>> {

	public XLSXFile(String path) {
		super(path);
	}


	public Collection<Articulos> parse() throws ParseException {
		
		File excelFile  = new File(super.getPath());
		Collection<Articulos> listArticulos = new ArrayList<Articulos>();
		
		try (InputStream ExcelinputStrem = new FileInputStream(excelFile);
			Workbook libroTrabajo = new XSSFWorkbook(ExcelinputStrem);){
			
			//Llamamos las segunda hoja del excel
			Sheet hojaExcel = libroTrabajo.getSheetAt(1);
			
			Iterator<Row> filasDeHoja1 = hojaExcel.iterator();
			boolean primerFila = true;
			
			
			while(filasDeHoja1.hasNext()) {
				Row filaActual = filasDeHoja1.next(); //Nos desplazamos a la primer fila
				Articulos art = new Articulos();
				
				if(primerFila){
					primerFila = false; //Leemos la primer fila y la saltamos
					continue;
				}
				listArticulos.add(this.fromCellToArticulo(art, filaActual));
			}
			
		}catch(IOException e) {
			throw new ParseException("No se ha podido parsear el archivo : " + getPath(), e);
		}
		return listArticulos;
	}


	private Articulos fromCellToArticulo(Articulos art, Row filaActual) {
		art.setTitulo(filaActual.getCell(0).getStringCellValue());
		art.setCodigo(filaActual.getCell(1).getStringCellValue());
		art.setPrecio(filaActual.getCell(2).getNumericCellValue());
		art.setStock((long)filaActual.getCell(3).getNumericCellValue());
		art.setMarcaId((long)filaActual.getCell(4).getNumericCellValue());
		art.setCategoriaId((long)filaActual.getCell(5).getNumericCellValue());

		art.setFechaCreacion(new Date());
		return art;
	}

}
