package ar.com.educacionit.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import ar.com.educacionit.dao.exceptions.GenericException;
import ar.com.educacionit.dao.jdbc.AdministradorConexiones;
import ar.com.educacionit.domain.Categorias;
import ar.com.educacionit.domain.Entity;
import ar.com.educacionit.domain.Socios;

public class MainJDBC2 {

	public static void main(String[] args) throws GenericException, SQLException{
		
		
		Connection con = AdministradorConexiones.obtenerConexion();
		
		
		Statement st = con.createStatement();
		ResultSet res = st.executeQuery("Select * from categorias");
		
		Collection<Entity> lista = new ArrayList<>();
		Categorias categ = null;
		//Obtener todos los datos
		while(res.next()) {
			Long id = res.getLong(1); //Obtener un valir long de la columna1
			String descripcion = res.getString(2);
			String codigo = res.getString(3);
			Long habilitado =res.getLong(4);
			categ = new Categorias(id,descripcion,codigo);
			lista.add(categ);
		}
		
		System.out.println(lista);
		
		/*
		if(res.next()) {
			// Se ouede con strings
			//ResultSet : columnas/filas
			Long id = res.getLong(1); //Obtener un valir long de la columna1
			String descripcion = res.getString(2);
			String codigo = res.getString(3);
			Long habilitado =res.getLong(4);
			
			Categorias categ = new Categorias(id,descripcion,codigo);
			lista.add(categ);
			
			//con.close();			
		}else {
			System.out.println("No hay datos");
		}
		
		*/
		//Socios
		 res = st.executeQuery("Select * from socios");
		 lista = new ArrayList<>();
		 while(res.next()) {
			 	Long id = res.getLong("id"); //Obtener un valir long de la columna1
				String nombre = res.getString("nombre");
				String apellido = res.getString("apellido");
				String email = res.getString("email");
				Date fecha = res.getDate("fecha_alta");
				String direccion = res.getString("direccion");
				Long paises_id = res.getLong("paises_id");

				
				Socios soc = new Socios(id,nombre,apellido,email,direccion,paises_id);
				lista.add(soc);
		 }
		 
		 System.out.println(lista);
		/*
			if(res.next()) {
				// Se ouede con strings
				//ResultSet : columnas/filas
				Long id = res.getLong("id"); //Obtener un valir long de la columna1
				String nombre = res.getString("nombre");
				String apellido = res.getString("apellido");
				String email = res.getString("email");
				Date fecha = res.getDate("fecha_alta");
				String direccion = res.getString("direccion");
				Long paises_id = res.getLong("paises_id");

				
				Socios soc = new Socios(id,nombre,apellido,email,direccion,paises_id);
				System.out.println(soc);
				
				con.close();			
			}else {
				System.out.println("No hay datos");
			}
			*/
	}


}
