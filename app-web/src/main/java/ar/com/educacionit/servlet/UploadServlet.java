package ar.com.educacionit.servlet;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import ar.com.educacionit.domain.Articulos;
import ar.com.educacionit.generic.CSVFileParser;
import ar.com.educacionit.generic.IParser;
import ar.com.educacionit.generic.ParseException;
import ar.com.educacionit.web.enums.ViewEnums;
import ar.com.educacionit.web.enums.ViewKeysEnum;

@WebServlet("/controllers/UploadServlet")
@MultipartConfig //Para poder leer archivos binarios
public class UploadServlet extends BaseServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//Leer el archivo
		//Me permite capturar ela rchivo ocmo parametro
		Part filepart = req.getPart(ViewKeysEnum.UPLOAD_FILE.getParam());
		ViewEnums target = ViewEnums.UPLOAD_PREVIEW;
		if(filepart.getSize() > 0) {
			
			//Permite leer cierta informacion de direcciones
			//Formas segura de capturar el nombre del archivo
			String fileName = Paths.get(filepart.getSubmittedFileName()).getFileName().toString();
			String ext = this.getExt(fileName);
			IParser<Collection<Articulos>> parser = null;
			switch (ext) {
			case "csv":
				parser = new CSVFileParser(filepart);
				break;
			case "XLS":
				//parser = new XLSFileParser(ext);
				break;
			default:
				parser = null;
				break;
			}
			if(parser != null) {
				try {
					Collection<Articulos> articulos = parser.parseV2();
					super.addAttribute(req, ViewKeysEnum.UPLOAD_PREVIEW_KEY, articulos);
				} catch (ParseException e) {
					//req.setAttribute(ViewKeysEnum.ERROR_GENERAL.getParam(), e.getMessage());
					super.addAttribute(req,ViewKeysEnum.ERROR_GENERAL,e.getMessage());
					target = ViewEnums.UPLOAD;
				}
			}else {
				target = ViewEnums.UPLOAD;
				super.addAttribute(req,ViewKeysEnum.ERROR_GENERAL, "Formato invalido");
			}
			
			//Todos los servlets podran usar si heredan este método del padre
			super.redirect(target, req,resp);
		}
	}

	private String getExt(String fileName) {
		String[] names = fileName.split("\\.");
		return names[1];
	}

}
