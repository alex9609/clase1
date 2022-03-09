package practica_adicional_semana13.pdf;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
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
import practica_adicional_semana13.dominio.Articulos;

public class PDFCreator {
	
	private ArrayList<Articulos> listArticulos = new ArrayList<>();
	
	public PDFCreator(Collection<Articulos> listaArticulos) {
		this.listArticulos = (ArrayList<Articulos>) listaArticulos;
	}
	
	//Crear documento
	public  void createPDF() throws PdfExceptions, DocumentException {
		System.out.println("Creando documento PDF ....");
		Document documento  = new Document();
		//El outputStream para el fichero donde crearemos el pdf
		
		FileOutputStream ficheroPDF;
		try {
			ficheroPDF = new FileOutputStream("src/main/java/practica_adicional_semana13/carpetaArchivos/Articulos.pdf");
			//Se asocia el documento de OutPutStream
			PdfWriter.getInstance(documento, ficheroPDF);
			//Abrir el documento
			documento.open();
			
			//Texto del documento
			Paragraph titulo = new Paragraph("Listado de articulos \n\n",
					FontFactory.getFont("arial",
							20,
							Font.BOLD,
							BaseColor.RED
							)
					);
			//Añadimos el titulo del documento
			documento.add(titulo);
			
			//Creamos una tabla 
			PdfPTable tabla = new PdfPTable(6);
			//titulo, codigo,precio,stock,marcaId, categoriaId
			tabla.addCell("Titulo");
			tabla.addCell("Codigo");
			tabla.addCell("Precio");
			tabla.addCell("Stock");
			tabla.addCell("MarcaID");
			tabla.addCell("CategoriaID");
			
			
			for(Articulos art : this.listArticulos) {
				tabla.addCell(art.getTitulo());
				tabla.addCell(art.getCodigo());
				tabla.addCell(art.getPrecio().toString());
				tabla.addCell(art.getStock().toString());
				tabla.addCell(art.getMarcaId().toString());
				tabla.addCell(art.getCategoriaId().toString());
			}
			
			//Añador la tabla al documento
			
			documento.add(tabla);
			//Cerrar documento
			documento.close();
			System.out.println("Documento creado con exito");
		} catch (FileNotFoundException e) {
			throw new PdfExceptions("Error al crear el fichero",e);
		}
		
	}
	
	

}
