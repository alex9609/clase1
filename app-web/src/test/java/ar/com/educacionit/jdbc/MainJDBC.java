package ar.com.educacionit.jdbc;

import java.sql.Connection;
import java.sql.SQLException;

import ar.com.educacionit.dao.exceptions.GenericException;
import ar.com.educacionit.dao.jdbc.AdministradorConexiones;

public class MainJDBC {

	public static void main(String[] args)  {
		
		
		//Interfaz conecction perteneciente a java.sql - Conección a la DB con user y pass
		try {
			Connection con = AdministradorConexiones.obtenerConexion();
			System.out.println("Se ha conectado a la DB");
			try {
				con.close();
				System.out.println("Se ha cerrado la DB");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (GenericException e) {
			e.printStackTrace();
		}
		
		
		//Statement interfaz que pertenece a java.sql - PreraredStatement : sql
		//ir a las consultas y ejecutar el script
		
		
		//ResultSet interfaz que pertenece a java.sql - 
		//datos (columnas / filas)
	}

}
