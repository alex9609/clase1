package ar.com.educacionit.servlet.rest;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import ar.com.educacionit.dao.exceptions.GenericException;
import ar.com.educacionit.domain.Articulos;
import ar.com.educacionit.domain.Categorias;
import ar.com.educacionit.domain.Marcas;
import ar.com.educacionit.services.ArticulosService;
import ar.com.educacionit.services.CategoriaService;
import ar.com.educacionit.services.MarcasService;
import ar.com.educacionit.services.Impl.ArticulosServiceImpl;
import ar.com.educacionit.services.Impl.CategoriaServiceImpl;
import ar.com.educacionit.services.Impl.MarcasServiceImpl;
import ar.com.educacionit.services.exceptions.ServiceException;
import ar.com.educacionit.web.enums.ViewKeysEnum;

@WebServlet("/rest/ProductoRest")
public class ProductRest extends HttpServlet{
	

	private ArticulosService service = new ArticulosServiceImpl();
	private CategoriaService catServices = new CategoriaServiceImpl();
	private MarcasService marcaService = new MarcasServiceImpl();
	private ObjectMapper objectMapper = new ObjectMapper();
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//tomar id que viene por req
		String id = req.getParameter(ViewKeysEnum.ID_PRODUCTO.getParam());
		
		try {
			Articulos articulo = this.service.getOne(Long.parseLong(id));
			List<Marcas> marcas = this.marcaService.findAll();
			List<Categorias> categorias = this.catServices.findAll();
			//escribo en el response el objeto
			
			Map<String,Object> jsonObject = new HashMap<>();
			jsonObject.put("articulo", articulo);
			jsonObject.put("marcas", marcas);
			jsonObject.put("categorias", categorias);
			
			String json = objectMapper.writeValueAsString(jsonObject);
			
			resp.getWriter().print(json);
			
		} catch (ServiceException | GenericException e) {
			//tph: manejar el error y crear un json <algo>
			e.printStackTrace();
		}
	}
	

}
