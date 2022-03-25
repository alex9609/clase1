package ar.com.educacionit.conexion;

import ar.com.educacionit.dao.exceptions.GenericException;
import ar.com.educacionit.dao.jdbc.AdministradorConexiones;

public class ConexionTest {

	public static void main(String[] args) {
		
		AdministradorConexiones con = new AdministradorConexiones();
		try {
			con.obtenerConexion();
			System.out.println("Conexion exitosa");
		} catch (GenericException e) {
			e.printStackTrace();
		}
		
	}
}
