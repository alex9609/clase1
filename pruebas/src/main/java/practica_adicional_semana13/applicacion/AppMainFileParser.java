package practica_adicional_semana13.applicacion;

import java.util.Collection;

import com.itextpdf.text.DocumentException;

import practica_adicional_semana13.Exceptions.ParseException;
import practica_adicional_semana13.Exceptions.PdfExceptions;
import practica_adicional_semana13.control.IParser;
import practica_adicional_semana13.control.XLSXFile;
import practica_adicional_semana13.dominio.Articulos;
import practica_adicional_semana13.pdf.PDFCreator;
public class AppMainFileParser {

	public static void main(String[] args) throws ParseException, PdfExceptions, DocumentException {

		String path = "src/main/java/practica_adicional_semana13/carpetaArchivos/Articulo.xlsx";

		IParser<Collection<Articulos>> parser = new XLSXFile(path);

		try {
			Collection<Articulos> listaArticulos = parser.parse();
			PDFCreator doc = new PDFCreator(listaArticulos);
			doc.createPDF();
			
			//Pasar la información a PDF
			
		} catch (ParseException e) {
			throw new ParseException("Existe algun error", e);
		}
	}

}
