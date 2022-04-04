package ar.com.educacionit.servlet;

import java.io.IOException;
import java.nio.file.Paths;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import ar.com.educacionit.domain.Articulos;
import ar.com.educacionit.generic.CSVFileParser;
import ar.com.educacionit.generic.IParser;
import ar.com.educacionit.generic.XLSFileParser;
import ar.com.educacionit.web.enums.ViewKeysEnum;

@WebServlet("/UploadFileServlet")
public class UploadServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//Leer el archivo
		//Me permite capturar ela rchivo ocmo parametro
		Part filepart = req.getPart(ViewKeysEnum.UPLOAD_FILE.getParam());
		if(filepart.getSize() > 0) {
			
			//Permite leer cierta informacion de direcciones
			//Formas segura de capturar el nombre del archivo
			String fileName = Paths.get(filepart.getSubmittedFileName()).getFileName().toString();
			String ext = this.getExt(fileName);
			IParser<Articulos> parser = null;
			switch (ext) {
			case "csv":
				//parser = new CSVFileParser(ext);
				break;
			case "XLS":
				//parser = new XLSFileParser(ext);
				break;
			default:
				parser = null;
				break;
			}
			if(parser == null) {
				req.setAttribute(ViewKeysEnum.ERROR_GENERAL.getParam(), "Formato invalido");
			}
		}
	}

	private String getExt(String fileName) {
		String[] names = fileName.split(".");
		return names[1];
	}

}
