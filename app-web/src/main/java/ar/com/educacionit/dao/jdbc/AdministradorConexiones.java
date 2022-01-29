package ar.com.educacionit.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import ar.com.educacionit.dao.exceptions.GenericException;

public class AdministradorConexiones {
	
	public static Connection obtenerConexion() throws GenericException {
		
		//url, usuario, password, driver
		//El driver pide el timezone sino no se conecta
		String url = "jdbc:mysql://localhost:3306/bootcamp-protalento?serverTimeZone=UTC&userSSL=false";
		String user = "root";
		String password ="root";
		String driverName = "com.mysql.cj.jdbc.Driver";
		
		//
		try {
			//Aqui instanciamos la clase de conexión
			Class.forName(driverName);
			Connection connection = DriverManager.getConnection(url,user,password);
			return connection;
		} catch (SQLException e) {
			throw new GenericException("Error obteniendo conexión");
		}catch(ClassNotFoundException e){
			throw new GenericException("No existe el driver " + driverName);
		}
	}
}
