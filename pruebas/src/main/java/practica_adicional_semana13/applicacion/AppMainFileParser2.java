package practica_adicional_semana13.applicacion;

import java.util.Collection;
import com.itextpdf.text.DocumentException;
import practica_adicional_semana13.Exceptions.ParseException;
import practica_adicional_semana13.Exceptions.PdfExceptions;
import practica_adicional_semana13.control.IParser;
import practica_adicional_semana13.control.XLSXFile;
import practica_adicional_semana13.dominio.Articulos;
import practica_adicional_semana13.pdf.PDFCreator2;


public class AppMainFileParser2 {

	public static void main(String[] args) throws ParseException, DocumentException, PdfExceptions{

		String path = "src/main/java/practica_adicional_semana13/carpetaArchivos/Articulo.xlsx";
		
		//Path para escribir el pdf
		String pathPDF ="src/main/java/practica_adicional_semana13/carpetaArchivos/Articulos.pdf";

		IParser<Collection<Articulos>> parser = new XLSXFile(path);

		try {
			Collection<Articulos> listaArticulos = parser.parse();
			
			PDFCreator2 doc = new PDFCreator2(listaArticulos,pathPDF);
			doc.createPDF();
			
			//Pasar la informaci�n a PDF
			
		} catch (ParseException e) {
			throw new ParseException("Existe algun error", e);
		}

	}
	

}
