package ar.com.educacionit.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import ar.com.educacionit.dao.exceptions.GenericException;

public class AdministradorConexiones {
	
	public static Connection obtenerConexion() throws GenericException {
		
		//url, usuario, password, driver
		//El driver pide el timezone sino no se conecta
		String url = "jdbc:postgresql://ec2-3-208-121-149.compute-1.amazonaws.com:5432/d1tnit3tds2m1j";
		String user = "azlqopjoohuzmf";
		String password ="6ccbc5de0675ce4f7e7a83acb8fe2fbac912417e1b9a6ea8761e4ece516e2590";
		String driverName = "org.postgresql.Driver";
		
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
