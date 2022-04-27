package ar.com.educacionit.servlet;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ar.com.educacionit.domain.Articulos;
import ar.com.educacionit.web.enums.ViewKeysEnum;

@WebServlet("/controllers/GenerarArchivoErrorServlet")
public class GenerarArchivoErrorServlet extends HttpServlet {


		protected void doPost(HttpServletRequest req, HttpServletResponse resp)throws ServletException,IOException{
			Collection<Articulos> articulosPreview = (Collection<Articulos>) req.getSession()
					.getAttribute(ViewKeysEnum.ARTICULOS_FAIL.getParam());
			
			String fileName = "listado-productos-error";
			
			String format = req.getParameter(ViewKeysEnum.FORMATO.getParam());
			String path = File.separator + "desarrollo" + File.separator + fileName + "." + format ; //Se acomoda al sistema operatico

			File outputFile = new File(path);
			
			if(!outputFile.exists()) {
				Files.createFile(outputFile.toPath());
			}
			
			FileWriter fr = new FileWriter(outputFile);
			
			for(Articulos art : articulosPreview) {
				String lineFromArticulo = this.lineFromArticulo(art);			
				fr.write(lineFromArticulo);
			}
			
			super.doGet(req, resp);
		}

		//Método que coniverte el articulo en una linea
		private String lineFromArticulo(Articulos aux) {
			StringBuffer linea = new StringBuffer();
			linea.append(aux.getCodigo()).append(";");
			linea.append(aux.getTitulo()).append(";");
			linea.append(aux.getPrecio()).append(";");
			return linea.toString(); 
		}
}

