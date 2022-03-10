package practica_adicional_semana13.pdf;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.lang.reflect.Field;
import java.util.Collection;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import practica_adicional_semana13.Exceptions.PdfExceptions;
import practica_adicional_semana13.dominio.Entity;

public class PDFCreator2<T extends Entity> {

	private String path;
	private Collection<Entity> listaElementos;

	public PDFCreator2(Collection<Entity> num, String path) {
		this.listaElementos = num;
		this.path = path;
	}

	public void createPDF() throws DocumentException, PdfExceptions {
		System.out.println("Creando documento PDF ....");

		Document documento = new Document();
		// El outputStream para el fichero donde crearemos el pdf

		FileOutputStream ficheroPDF;

		Object primerObjeto = null;
		for (Object obj : this.listaElementos) {
			primerObjeto = obj;
			break;
		}

		Class<? extends Object> clase = primerObjeto.getClass();
		Field[] campos = clase.getDeclaredFields();
		int cantidadTablas = campos.length;

		try {
			ficheroPDF = new FileOutputStream(this.path);
			// Se asocia el documento de OutPutStream
			PdfWriter.getInstance(documento, ficheroPDF);
			// Abrir el documento
			documento.open();

			// Texto del documento
			Paragraph titulo = new Paragraph("Listado de articulos \n\n",
					FontFactory.getFont("arial", 18, Font.BOLD, BaseColor.RED));
			// Agreugamos el titulo del documento
			documento.add(titulo);

			// Creamos una tabla
			PdfPTable tabla = new PdfPTable(cantidadTablas);
			
			//Agregar el titulo de cada tabla
			for (Field campo : campos) {
				tabla.addCell(campo.getName());
			}

			// Obtener los valores de todos los objetos
			for (Object obj : this.listaElementos) {
				clase = obj.getClass();
				// Escribir cada uno de los valores del titulo en la celda
				campos = clase.getDeclaredFields();
				for (Field campo : campos) {
					campo.setAccessible(true);
					try{
						tabla.addCell(campo.get(obj).toString());
					} catch (IllegalArgumentException | IllegalAccessException e) {
						throw new PdfExceptions("Error al ingresar el dato en la tabla", e);
					}
					campo.setAccessible(false);
				}
			}
			documento.add(tabla);
			// Cerrar documento
			documento.close();
			System.out.println("Documento creado con exito");
		} catch (FileNotFoundException e) {
			throw new PdfExceptions("Error al crear el fichero", e);
		}

	}

}
